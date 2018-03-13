package com.github.mdstoy.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class OptionTest {

    @ShellMethod(value = "default value", key = "default")
    public String defaultValue(@ShellOption(defaultValue = "Hello") String option) {
        return option;
    }

    @ShellMethod("help as short description")
    public String echoString(@ShellOption(help = "echo string") String args) {
        return args;
    }

    @ShellMethod(value = "chenge prefix", prefix = "__")
    public String prefix(String param) {
        return param;
    }

    @ShellMethod("camel case option parameter")
    public String camelOption(String paramString) {
        return paramString;
    }

}
