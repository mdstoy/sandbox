package com.github.mdstoy.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ShellCommand {

    @ShellMethod("Hello, world.")
    public String hello() {
        return "Hello, world.";
    }

    @ShellMethod("echo")
    public String echo(String args) {
        return args;
    }

    @ShellMethod("add")
    public int add(int a, int b) {
        return a + b;
    }

    @ShellMethod(value = "Hello, again.", key = "print")
    public String hello2() {
        return "Hello, again.";
    }
}
