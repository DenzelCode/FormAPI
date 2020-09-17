package com.denzelcode.form;

import cn.nukkit.form.element.Element;
import cn.nukkit.plugin.PluginBase;
import com.denzelcode.form.window.CustomWindowForm;
import com.denzelcode.form.window.ModalWindowForm;
import com.denzelcode.form.window.SimpleWindowForm;

import java.util.List;

public class FormAPI extends PluginBase {

    public static SimpleWindowForm simpleWindowForm(String name, String title) {
        return new SimpleWindowForm(name, title);
    }

    public static SimpleWindowForm simpleWindowForm(String name, String title, String content) {
        return new SimpleWindowForm(name, title, content);
    }

    public static CustomWindowForm customWindowForm(String name, String title) {
        return new CustomWindowForm(name, title);
    }

    public static CustomWindowForm customWindowForm(String name, String title, List<Element> content) {
        return new CustomWindowForm(name, title, content);
    }

    public static ModalWindowForm modalWindowForm(String name, String title, String acceptButtonText, String cancelButtonText) {
        return new ModalWindowForm(name, title, acceptButtonText, cancelButtonText);
    }

    public static ModalWindowForm modalWindowForm(String name, String title, String content, String acceptButtonText, String cancelButtonText) {
        return new ModalWindowForm(name, title, content, acceptButtonText, cancelButtonText);
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }
}
