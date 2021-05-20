package jp.co.froide.javaframework;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HelloJunitTest {
    @Test
    public void HelloJunitSample(){
        HelloJunit hello = new HelloJunit();
        assertThat(hello.sayHello(),is("hello"));
    }
}
