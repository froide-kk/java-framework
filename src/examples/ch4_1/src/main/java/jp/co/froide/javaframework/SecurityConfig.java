package jp.co.froide.javaframework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

//     セキュリティ設定　デフォルト設定を継承
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

//    自作認証に差し替え
    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    デフォルトを上書き　暗号化用にパスワードをカスタマイズ
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

//    認証しないものの設定、静的なファイルには認証をかけない
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 静的コンテンツには認証をかけない
        web.ignoring().antMatchers("/favicon.ico", "/css/**", "/js/**", "/images/**", "/fonts/**");
    }

//    認証に使う名前とパスワードのパス設定
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/loginForm").permitAll()  // ログインフォームは許可
                .anyRequest().authenticated();  // それ以外 認証無しの場合アクセス不許可
        http.formLogin()
                .loginProcessingUrl("/login")//ログイン処理をするURL
                .loginPage("/loginForm")//ログイン画面のURL
                .failureUrl("/login?error")//認証失敗時のURL
                .successForwardUrl("/success")//認証成功時のURL
                .usernameParameter("name")//ユーザのパラメータ名
                .passwordParameter("password");//パスワードのパラメータ名
        http.logout()
                .logoutUrl("/logout")//ログアウト時のURL（今回は未実装）
                .logoutSuccessUrl("/login");//ログアウト成功時のURL
    }

}
