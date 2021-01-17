package com.denzelcode.form.event;

import cn.nukkit.Player;
import cn.nukkit.event.HandlerList;
import com.denzelcode.form.window.CustomWindowForm;

public class CustomFormSubmitEvent extends FormEvent<CustomWindowForm> {

    private static final HandlerList handlers = new HandlerList();

    public CustomFormSubmitEvent(Player player, CustomWindowForm form) {
        super(player, form);
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
