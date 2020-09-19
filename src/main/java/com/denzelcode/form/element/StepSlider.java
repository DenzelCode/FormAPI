package com.denzelcode.form.element;

import cn.nukkit.form.element.ElementStepSlider;
import com.denzelcode.form.window.IWindowForm;

import java.util.ArrayList;
import java.util.List;

public class StepSlider extends ElementStepSlider implements IElement {

    protected String name;

    protected transient IWindowForm form;

    protected int value;

    public StepSlider(IWindowForm form, String name, String text) {
        this(form, name, text, new ArrayList<>());
    }

    public StepSlider(IWindowForm form, String name, String text, List<String> steps) {
        this(form, name, text, steps, 0);
    }

    public StepSlider(IWindowForm form, String name, String text, List<String> steps, int defaultStep) {
        super(text, steps, defaultStep);

        this.value = defaultStep;

        this.name = name;

        this.form = form;
    }

    @Override
    public void setDefaultOptionIndex(int index) {
        if (index != getDefaultStepIndex() && value == getDefaultStepIndex()) setValue(index);

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
