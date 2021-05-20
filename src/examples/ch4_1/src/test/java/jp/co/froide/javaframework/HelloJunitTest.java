package jp.co.froide.javaframework;

import jp.co.froide.javaframework.dao.UserDao;
import jp.co.froide.javaframework.util.HelloJunit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static  org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HelloJunitTest {
    private HelloJunit hello;

    @BeforeAll
    public void setUp() {
        hello = new HelloJunit();
    }

    @Test
    public void HelloJunitTestSample(){
        assertThat(hello.sayHello(),is("Hello"));
    }
}
