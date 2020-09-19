package com.denzelcode.form.element;

import cn.nukkit.form.element.ElementToggle;
import com.denzelcode.form.window.IWindowForm;

public class Toggle extends ElementToggle implements IElement {

    protected String name;

    protected boolean value;

    protected transient IWindowForm form;

    public Toggle(IWindowForm form, String name, String text) {
        this(form, name, text, false);
    }

    public Toggle(IWindowForm form, String name, String text, boolean defaultValue) {
        super(text, defaultValue);

        this.value = defaultValue;

        this.name = name;

        this.form = form;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
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
