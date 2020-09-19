package com.denzelcode.form.element;

import cn.nukkit.form.element.ElementDropdown;
import com.denzelcode.form.window.IWindowForm;

import java.util.ArrayList;
import java.util.List;

public class Dropdown extends ElementDropdown implements IElement {

    protected String name;

    protected transient IWindowForm form;

    protected int value;

    public Dropdown(IWindowForm form, String name, String text) {
        this(form, name, text, new ArrayList<>(), 0);
    }

    public Dropdown(IWindowForm form, String name, String text, List<String> options) {
        this(form, name, text, options, 0);
    }

    public Dropdown(IWindowForm form, String name, String text, List<String> options, int defaultOption) {
        super(text, options, defaultOption);

        this.value = defaultOption;

        this.name = name;

        this.form = form;
    }

    @Override
    public void setDefaultOptionIndex(int index) {
        if (index != getDefaultOptionIndex() && value == getDefaultOptionIndex()) setValue(index);

        super.setDefaultOptionIndex(index);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
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
