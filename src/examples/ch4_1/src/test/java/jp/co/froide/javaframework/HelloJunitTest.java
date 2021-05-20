package jp.co.froide.javaframework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static  org.hamcrest.CoreMatchers.is;

public class HelloJunitTest {

    private HelloJunit helloJunit;

    @BeforeAll
    public void setUP(){
        helloJunit = new HelloJunit();
    }

    @Test
    public void HelloTest(){
        assertThat(helloJunit.sayHello(), is("hello"));
    }




}
