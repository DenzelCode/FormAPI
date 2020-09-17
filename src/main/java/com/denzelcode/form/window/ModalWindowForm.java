package com.denzelcode.form.window;

import cn.nukkit.Player;
import cn.nukkit.form.window.FormWindowModal;

public class ModalWindowForm extends FormWindowModal implements IWindowForm {

    protected String name;

    public ModalWindowForm(String name, String title, String content, String acceptButtonText, String cancelButtonText) {
        super(title, content, acceptButtonText, cancelButtonText);

        this.name = name;
    }

    public ModalWindowForm(String name, String title, String acceptButtonText, String cancelButtonText) {
        this(name, title, "", acceptButtonText, cancelButtonText);
    }

    public String getAcceptButton() {
        return super.getButton1();
    }

    public String getCancelButton() {
        return super.getButton2();
    }

    public void setAcceptButton(String button1) {
        super.setButton1(button1);
    }

    public void setCancelButton(String button2) {
        super.setButton2(button2);
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
