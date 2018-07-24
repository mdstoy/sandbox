package com.github.mdstoy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleBean {

    private SampleConfiguration configuration;

    @Autowired
    public SampleBean(SampleConfiguration configuration) {
        this.configuration = configuration;
    }

    public void run() {
        System.out.println(configuration.getHogeCamel());
        System.out.println(configuration.getMoge());
    }
}
