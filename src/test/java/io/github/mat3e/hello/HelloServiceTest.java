package io.github.mat3e.hello;

import io.github.mat3e.lang.Lang;
import io.github.mat3e.lang.LangRepository;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class HelloServiceTest {
    private static final String WELCOME = "Hello";

    @Test
    public void test_prepareGreeting_nullName_returnsGreetingWithFallbackName(){
        //given
        var mockRepository = alwaysReturningHelloRepository();
        var SUT = new HelloService(mockRepository);
        
        //when
        var result = SUT.prepareGreeting(null, -1);

        //then
        assertEquals(WELCOME + " "+ HelloService.FALLBACK_NAME + "!", result);
    }

    @Test
    public void test_prepareGreeting_name_returnsGreetingWithName(){
        //given
        var mockRepository = alwaysReturningHelloRepository();
        var SUT = new HelloService(mockRepository);
        var name = "test";

        //when
        var result = SUT.prepareGreeting(name, -1);

        //then
        assertEquals(WELCOME + " " + name + "!", result);
        
    }

    @Test
    public void test_prepareGreeting_nullLang_returnsGreetingWithFallbackIdLang(){
        //given
        var fallbackIdWelcome = "Hola";
        var mockRepository = new LangRepository(){
            @Override
            public Optional<Lang> findById(Integer id) {
                if(id.equals(HelloService.FALLBACK_LANG.getId())){
                    Optional.of(new Lang(null, fallbackIdWelcome, null));
                }
                return Optional.of(new Lang(1, "Hey", "2"));
            }
        };
        var SUT = new HelloService(mockRepository);

        //when
        var result = SUT.prepareGreeting(null, null);

        //then
        assertEquals(WELCOME + " " + HelloService.FALLBACK_NAME + "!", result);

    }
    private LangRepository alwaysReturningHelloRepository() {
        return new LangRepository() {
            @Override
            public Optional<Lang> findById(Integer id) {
                return Optional.of(new Lang(null, WELCOME, null));
            }
        };
    }
}
