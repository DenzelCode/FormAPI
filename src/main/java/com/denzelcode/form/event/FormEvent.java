package com.denzelcode.form.event;

import cn.nukkit.Player;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.player.PlayerEvent;
import com.denzelcode.form.window.IWindowForm;

public class FormEvent<T extends IWindowForm> extends PlayerEvent implements Cancellable {

    protected T form;

    public FormEvent(Player player, T form) {
        this.player = player;

        this.form = form;
    }

    public T getForm() {
        return form;
    }
}
