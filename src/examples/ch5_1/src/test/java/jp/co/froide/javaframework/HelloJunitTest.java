package jp.co.froide.javaframework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HelloJunitTest {
    private HelloJunit hello;

    @BeforeAll
    public void setUp() {
        hello = new HelloJunit();
    }

    @Test
    public void HelloJunitTestSample() {
        assertThat(hello.sayHello(), is("Hello"));
    }


}
