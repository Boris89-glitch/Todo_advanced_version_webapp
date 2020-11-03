package io.github.mat3e.hello;

import io.github.mat3e.lang.Lang;
import io.github.mat3e.lang.LangRepository;

import java.util.Optional;

 class HelloService {
    private LangRepository repository;

    static final String FALLBACK_NAME = "World";
    static final Lang FALLBACK_LANG = new Lang(1,"Hello","en");

    HelloService() { this(new LangRepository()); }
    HelloService(LangRepository repository) {
        this.repository = repository;
    }

    String prepareGreeting(String name, String lang){
        //get langId if there is one
        var langId = Optional.ofNullable(lang).map(Integer::valueOf).orElse(FALLBACK_LANG.getId());

        //find the lang by id or go to fallback
        var welcomeMsg = repository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMsg();
        var newToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMsg + " " + newToWelcome + "!";
    }
}
