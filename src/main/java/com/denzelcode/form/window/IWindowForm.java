package com.denzelcode.form.window;

import cn.nukkit.Player;
import com.denzelcode.form.event.FormEvent;
import com.denzelcode.form.handler.IHandler;

import java.util.List;

public interface IWindowForm<T extends FormEvent<?>> {

    String getName();

    void sendTo(Player player);

    boolean wasClosed();

    boolean isValid(String formName);

    IWindowForm<T> addHandler(IHandler<T> handler);

    void clearHandlers();

    void dispatchHandlers(T event);

    List<IHandler<T>> getHandlers();
}
