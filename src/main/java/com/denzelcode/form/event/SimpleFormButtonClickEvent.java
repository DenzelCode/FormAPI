package com.denzelcode.form.event;

import cn.nukkit.Player;
import cn.nukkit.event.HandlerList;
import com.denzelcode.form.element.Button;
import com.denzelcode.form.window.SimpleWindowForm;

public class SimpleFormButtonClickEvent extends FormEvent<SimpleWindowForm> {

    private static final HandlerList handlers = new HandlerList();

    protected Button button;

    public SimpleFormButtonClickEvent(Player player, SimpleWindowForm form, Button button) {
        super(player, form);

        this.button = button;
    }

    public Button getButton() {
        return button;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
