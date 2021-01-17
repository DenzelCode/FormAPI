package com.denzelcode.form.handler;

import com.denzelcode.form.event.FormEvent;

public interface IHandler<T extends FormEvent<?>> {

    void handle(T event);
}
