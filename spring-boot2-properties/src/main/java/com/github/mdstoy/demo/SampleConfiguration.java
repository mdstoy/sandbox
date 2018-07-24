package com.github.mdstoy.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "camel-case")
@Component
public class SampleConfiguration {
    private String hoge;
    private String moge;

    public String getHoge() {
        return hoge;
    }

    public String getMoge() {
        return moge;
    }

    public void setHoge(String hoge) {
        this.hoge = hoge;
    }

    public void setMoge(String moge) {
        this.moge = moge;
    }
}
