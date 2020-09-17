package com.denzelcode.form.element;

public enum ImageType {
    PATH("path"),
    URL("url");

    private final String type;

    private ImageType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
