package com.denzelcode.form.element;

import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementButtonImageData;
import com.denzelcode.form.window.IWindowForm;

public class Button extends ElementButton implements IElement {

    protected String name = "";

    protected transient IWindowForm form;

    public Button(IWindowForm form, String text) {
        super(text);

        this.form = form;
    }

    public Button(IWindowForm form, String name, String text) {
        super(text);

        this.name = name;

        this.form = form;
    }

    public Button(IWindowForm form, String name, String text, ImageType imageType, String path) {
        super(text, new ElementButtonImageData(imageType.toString(), path));

        this.name = name;

        this.form = form;
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
