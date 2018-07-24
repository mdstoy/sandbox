package com.github.mdstoy.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "camel-case")
@Component
public class SampleConfiguration {
    private String hogeCamel;
    private String moge;

    public String getHogeCamel() {
        return hogeCamel;
    }

    public String getMoge() {
        return moge;
    }

    public void setHogeCamel(String hogeCamel) {
        this.hogeCamel = hogeCamel;
    }

    public void setMoge(String moge) {
        this.moge = moge;
    }
}
