package com.denzelcode.form.event;

import cn.nukkit.Player;
import cn.nukkit.event.HandlerList;
import com.denzelcode.form.element.Button;
import com.denzelcode.form.window.ModalWindowForm;

public class PlayerModalFormSubmit extends FormEvent<ModalWindowForm> {

    private static final HandlerList handlers = new HandlerList();

    protected Button button;

    protected boolean accepted;

    public PlayerModalFormSubmit(Player player, ModalWindowForm form, boolean accepted) {
        super(player, form);

        this.accepted = accepted;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
