package com.github.mdstoy.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent("Shell Component !!!")
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

    @ShellMethod(value = "group?", group = "grgr")
    public String group() {
        return "What is Group?";
    }

    @ShellMethod(value = "same group", group = "grgr")
    public String group2() {
        return "What is same Group?";
    }

    @ShellMethod(value = "prefix test", prefix = "***")
    public String prefix() {
        return "What is prefix";
    }
}
