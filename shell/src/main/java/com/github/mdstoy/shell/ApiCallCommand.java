package com.github.mdstoy.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent()
public class ApiCallCommand {

    @ShellMethod(value = "hogehogehoge")
    public String getName(int key) {
        return "Name!!";
    }

    @ShellMethod(value = "get Description", prefix = "****")
    public String getName2(int key) {
        return "Name!!";
    }

    @ShellMethod(value = "get Description", key="getName")
    public String getNameName(int key) {
        return "Name!!";
    }
}
