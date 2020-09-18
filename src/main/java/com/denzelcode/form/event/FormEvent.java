package com.denzelcode.form.event;

import cn.nukkit.Player;
import cn.nukkit.event.player.PlayerEvent;
import com.denzelcode.form.window.IWindowForm;

public class FormEvent<T extends IWindowForm> extends PlayerEvent {

    protected T form;

    public FormEvent(Player player, T form) {
        this.player = player;

        this.form = form;
    }

    public T getForm() {
        return form;
    }

    public boolean isClosed() {
        return form.wasClosed();
    }

    public boolean isValid(String formName) {
        return form.isValid(formName);
    }

    public boolean isFormValid(String formName) {
        return isValid(formName);
    }
}
