package com.denzelcode.form;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.Element;
import cn.nukkit.form.window.FormWindow;
import com.denzelcode.form.element.*;
import com.denzelcode.form.event.PlayerCustomFormSubmit;
import com.denzelcode.form.event.PlayerModalFormSubmit;
import com.denzelcode.form.event.PlayerSimpleFormButtonClick;
import com.denzelcode.form.window.CustomWindowForm;
import com.denzelcode.form.window.IWindowForm;
import com.denzelcode.form.window.ModalWindowForm;
import com.denzelcode.form.window.SimpleWindowForm;

import java.util.List;

public class EventListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onResponded(PlayerFormRespondedEvent event) {
        FormWindow formWindow = event.getWindow();

        Player player = event.getPlayer();

        if (!(formWindow instanceof IWindowForm)) return;

        if (formWindow instanceof SimpleWindowForm) {
            SimpleWindowForm window = (SimpleWindowForm) formWindow;

            PlayerSimpleFormButtonClick e = new PlayerSimpleFormButtonClick(
                    player,
                    window,
                    !window.wasClosed() ? (Button) window.getResponse().getClickedButton() : null
            );

            Server.getInstance().getPluginManager().callEvent(e);

            return;
        }

        if (formWindow instanceof ModalWindowForm) {
            ModalWindowForm window = (ModalWindowForm) formWindow;

            PlayerModalFormSubmit e = new PlayerModalFormSubmit(
                    player,
                    window,
                    !window.wasClosed() && window.getResponse().getClickedButtonText().equals(window.getAcceptButton())
            );

            Server.getInstance().getPluginManager().callEvent(e);

            return;
        }

        if (formWindow instanceof CustomWindowForm) {
            CustomWindowForm window = (CustomWindowForm) formWindow;

            PlayerCustomFormSubmit e = new PlayerCustomFormSubmit(player, (CustomWindowForm) formWindow);

            List<Element> elements = window.getElements();

            for (int i = 0; i < elements.size(); i++) {
                Element element = elements.get(i);

                if (element instanceof Input) {
                    Input el = (Input) element;

                    if (window.wasClosed()) {
                        el.setValue(el.getDefaultText());

                        continue;
                    }

                    el.setValue(window.getResponse().getInputResponse(i));
                } else if (element instanceof Dropdown) {
                    Dropdown el = (Dropdown) element;

                    if (window.wasClosed()) {
                        el.setValue(el.getDefaultOptionIndex());

                        continue;
                    }

                    el.setValue(window.getResponse().getDropdownResponse(i).getElementID());
                } else if (element instanceof Label) {
                    Label el = (Label) element;

                    if (window.wasClosed()) {
                        el.setValue("");

                        continue;
                    }

                    el.setValue(window.getResponse().getLabelResponse(i));
                } else if (element instanceof Toggle) {
                    Toggle el = (Toggle) element;

                    if (window.wasClosed()) {
                        el.setValue(el.isDefaultValue());

                        continue;
                    }

                    el.setValue(window.getResponse().getToggleResponse(i));
                } else if (element instanceof Slider) {
                    Slider el = (Slider) element;

                    if (window.wasClosed()) {
                        el.setValue(el.getDefaultValue());

                        continue;
                    }

                    el.setValue(window.getResponse().getDropdownResponse(i).getElementID());
                } else {
                    StepSlider el = (StepSlider) element;

                    if (window.wasClosed()) {
                        el.setValue(el.getDefaultStepIndex());

                        continue;
                    }

                    el.setValue(window.getResponse().getDropdownResponse(i).getElementID());
                }
            }

            Server.getInstance().getPluginManager().callEvent(e);
        }
    }
}
