package com.denzelcode.form.element;

import cn.nukkit.form.element.ElementInput;
import com.denzelcode.form.window.IWindowForm;

public class Input extends ElementInput implements IElement {

    protected String name;

    protected String value;

    protected transient IWindowForm form;

    public Input(IWindowForm form, String name, String text) {
        this(form, name, text, "");
    }

    public Input(IWindowForm form, String name, String text, String placeholder) {
        this(form, name, text, placeholder, "");
    }

    public Input(IWindowForm form, String name, String text, String placeholder, String defaultValue) {
        super(text, placeholder, defaultValue);

        this.value = defaultValue;

        this.name = name;

        this.form = form;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IWindowForm getForm() {
        return form;
    }
}
