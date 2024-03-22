package com.example.demo;

public class StringTemplates {
    public void run() throws Throwable {
        var name = "josh";
        System.out.println(STR."""
            name: \{name.toUpperCase()}
            """);
    }
}
