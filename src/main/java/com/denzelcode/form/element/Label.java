package com.denzelcode.form.element;

import cn.nukkit.form.element.ElementLabel;
import com.denzelcode.form.window.IWindowForm;

public class Label extends ElementLabel implements IElement {

    protected String name;

    protected String value;

    protected transient IWindowForm form;

    public Label(IWindowForm form, String text) {
        this(form, "", text, "");
    }

    public Label(IWindowForm form, String name, String text) {
        this(form, name, text, "");
    }

    public Label(IWindowForm form, String name, String text, String defaultValue) {
        super(text);

        this.name = name;

        this.form = form;

        this.value = defaultValue;
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
