package io.github.mat3e;

import java.util.Optional;

class HelloService {
    private LangRepository repository;

    HelloService() {
        this(new LangRepository());
    }

    HelloService(LangRepository repository) {
        this.repository = repository;
    }

    static final String FALLBACK_VALUE = "World";

    String prepareGreeting(String name){
        return "Hello " + Optional.ofNullable(name).orElse(FALLBACK_VALUE) + "!";
    }
}
