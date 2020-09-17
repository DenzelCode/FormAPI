package com.denzelcode.form.window;

import cn.nukkit.Player;
import cn.nukkit.form.element.Element;
import cn.nukkit.form.element.ElementButtonImageData;
import cn.nukkit.form.window.FormWindowCustom;
import com.denzelcode.form.element.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class CustomWindowForm extends FormWindowCustom implements IWindowForm {
    protected String name;

    public CustomWindowForm(String name, String title) {
        this(name, title, new ArrayList<>());
    }

    public CustomWindowForm(String name, String title, List<Element> contents) {
        super(title, contents);

        this.name = name;
    }

    public CustomWindowForm(String name, String title, List<Element> contents, String icon) {
        this(name, title, contents, ImageType.URL, icon);
    }

    public CustomWindowForm(String name, String title, List<Element> contents, ImageType imageType, String path) {
        super(title, contents, new ElementButtonImageData(imageType.toString(), path));

        this.name = name;
    }

    public CustomWindowForm addDropdown(String name, String text) {
        Dropdown element = new Dropdown(this, name, text);

        addElement(element);

        return this;
    }

    public CustomWindowForm addDropdown(String name, String text, List<String> options) {
        Dropdown element = new Dropdown(this, name, text, options);

        addElement(element);

        return this;
    }

    public CustomWindowForm addDropdown(String name, String text, List<String> options, int defaultOption) {
        Dropdown element = new Dropdown(this, name, text, options, defaultOption);

        addElement(element);

        return this;
    }

    public CustomWindowForm addInput(String name, String text) {
        Input element = new Input(this, name, text);

        addElement(element);

        return this;
    }

    public CustomWindowForm addInput(String name, String text, String placeholder) {
        Input element = new Input(this, name, text, placeholder);

        addElement(element);

        return this;
    }

    public CustomWindowForm addInput(String name, String text, String placeholder, String defaultValue) {
        Input element = new Input(this, name, text, placeholder, defaultValue);

        addElement(element);

        return this;
    }

    public CustomWindowForm addLabel(String text) {
        Label element = new Label(this, text);

        addElement(element);

        return this;
    }

    public CustomWindowForm addLabel(String name, String text) {
        Label element = new Label(this, name, text);

        addElement(element);

        return this;
    }

    public CustomWindowForm addSlider(String name, String text, float min, float max) {
        Slider element = new Slider(this, name, text, min, max);

        addElement(element);

        return this;
    }

    public CustomWindowForm addSlider(String name, String text, float min, float max, int step) {
        Slider element = new Slider(this, name, text, min, max, step);

        addElement(element);

        return this;
    }

    public CustomWindowForm addSlider(String name, String text, float min, float max, int step, float defaultValue) {
        Slider element = new Slider(this, name, text, min, max, step, defaultValue);

        addElement(element);

        return this;
    }

    public CustomWindowForm addStepSlider(String name, String text) {
        StepSlider element = new StepSlider(this, name, text);

        addElement(element);

        return this;
    }

    public CustomWindowForm addStepSlider(String name, String text, List<String> steps) {
        StepSlider element = new StepSlider(this, name, text, steps);

        addElement(element);

        return this;
    }

    public CustomWindowForm addStepSlider(String name, String text, List<String> steps, int defaultStep) {
        StepSlider element = new StepSlider(this, name, text, steps, defaultStep);

        addElement(element);

        return this;
    }

    public CustomWindowForm addToggle(String name, String text) {
        Toggle element = new Toggle(this, name, text);

        addElement(element);

        return this;
    }

    public CustomWindowForm addToggle(String name, String text, boolean defaultValue) {
        Toggle element = new Toggle(this, name, text, defaultValue);

        addElement(element);

        return this;
    }

    @Override
    public void addElement(Element element) {
        if (!(element instanceof IElement))
            throw new InvalidParameterException("IElement implementation is required to add an element.");

        super.addElement(element);
    }

    public Element getRegularElement(String name) {
        for (Element element: getElements())
            if (((IElement)element).getName().equals(name)) return element;

        return null;
    }

    public <T extends IElement> T getElement(String name) {
        for (Element element: getElements())
            if (((IElement)element).getName().equals(name)) return (T) element;

        return null;
    }

    @Override
    public boolean wasClosed() {
        return super.wasClosed() || this.getResponse() == null;
    }

    @Override
    public void sendTo(Player player) {
        if (player == null) return;

        player.showFormWindow(this);
    }

    @Override
    public String getName() {
        return name;
    }
}
