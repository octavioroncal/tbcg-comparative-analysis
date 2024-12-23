package com.example

class Field {
    public val String type
    public val String name
    public val String defaultValue

    new(String type, String name, String defaultValue) {
        this.type = type
        this.name = name
        this.defaultValue = defaultValue
    }
}