package io.github.mat3e;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloServiceTest {
    private  HelloService SUT = new HelloService();

    @Test
    public void test_prepareGreeting_null_returnsGreetingWithFallback(){
        //given
        String name = null;
        
        //when
        var result = SUT.prepareGreeting(name);

        //then
        assertEquals("Hello " + HelloService.FALLBACK_VALUE + "!", result);
    }
    @Test
    public void test_prepareGreeting_name_returnsGreetingWithName(){
        //given
        String name = "test";

        //when
        var result = SUT.prepareGreeting(name);

        //then
        assertEquals("Hello " + name + "!", result);
        
    }
}
