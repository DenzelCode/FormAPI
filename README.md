# FormAPI
FormAPI Provider for Nukkit.

## What's FormAPI?
FormAPI is an API that provides you everything that you need to enhance your plugins with the forms system implemented on Nukkit.


## Download
Download the latest JAR: https://github.com/DenzelCode/FormAPI/releases/latest

## Dependency for maven:
```
<dependency>
    <groupId>com.denzelcode.form</groupId>
    <artifactId>FormAPI</artifactId>
    <version>1.0.0</version>
    <systemPath>${project.basedir}/lib/FormAPI.jar</systemPath>
</dependency>
```

## Instalation:
- Put the FormAPI.jar inside of /plugins. 

In case you don't want to put it inside of plugins just execute this line of code inside of your plugin to run the EventListener:
```
getServer().getPluginManager().registerEvents(new com.denzelcode.form.EventListener(), this);
```

## Example:
**Create formulary and send it to the client:**
```java
package com.denzelcode.test;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import com.denzelcode.form.FormAPI;

public class TestCommand extends Command {
    public TestCommand() {
        super("test");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        FormAPI.customWindowForm("login", "Custom Form")
                .addInput("username", "Username", "Enter your username")
                .addInput("password", "Password", "Enter your password")
                .sendTo((Player) sender);

        return true;
    }
}

```
**Event listener:**
```java
package com.denzelcode.test;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import com.denzelcode.form.FormAPI;
import com.denzelcode.form.element.Button;
import com.denzelcode.form.element.Input;
import com.denzelcode.form.event.PlayerCustomFormSubmit;
import com.denzelcode.form.event.PlayerModalFormSubmit;
import com.denzelcode.form.event.PlayerSimpleFormButtonClick;
import com.denzelcode.form.window.CustomWindowForm;
import com.denzelcode.form.window.ModalWindowForm;
import com.denzelcode.form.window.SimpleWindowForm;

public class EventListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onLoginFormSubmit(PlayerCustomFormSubmit event) {
        CustomWindowForm form = event.getForm();
        Player player = event.getPlayer();

        if (!form.getName().equals("login")) return;

        Input username = form.getElement("username");
        Input password = form.getElement("password");

        player.sendMessage("Player: " + player.getName());
        player.sendMessage("Form: " + form.getName());
        player.sendMessage("Username: " + username.getValue());
        player.sendMessage("Password: " + password.getValue());

        FormAPI.modalWindowForm(
                "login_remember",
                "Remember",
                "Do you want to remember your account in this device?",
                "Yes",
                "No"
        ).sendTo(player);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onRememberFormSubmit(PlayerModalFormSubmit event) {
        ModalWindowForm form = event.getForm();
        Player player = event.getPlayer();

        if (!form.getName().equals("login_remember")) return;

        boolean accepted = event.isAccepted();

        player.sendMessage("Player: " + player.getName());
        player.sendMessage("Form: " + form.getName());
        player.sendMessage("Accepted: " + (accepted ? "Yes" : "No"));

        FormAPI.simpleWindowForm("minigames", "Minigames", "Select a minigame which you want to play!")
                .addButton("skywars", "SkyWars")
                .addButton("luckyislands", "LuckyIslands")
                .sendTo(player);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onMinigameFormSubmit(PlayerSimpleFormButtonClick event) {
        SimpleWindowForm form = event.getForm();
        Player player = event.getPlayer();
        Button button = event.getButton();

        if (event.isClosed()) return;

        if (!form.getName().equals("minigames")) return;

        player.sendMessage("Player: " + player.getName());
        player.sendMessage("Form: " + form.getName());
        player.sendMessage("Clicked button: " + button.getName());

        player.sendMessage("Successfully joined Minigame: " + button.getText() + "!");
    }
}

```

- Run command /test and you will have this showed in-game:
[Screenshot](https://imgur.com/a/lFqzhYq)

## Form Types
Modal Example
```java
import com.denzelcode.form.FormAPI;

FormAPI.modalWindowForm("modal", "Custom Form", "This is a content", "Accept", "Decline")
    .sendTo(player);
```
Simple Example
```java
FormAPI.simpleWindowForm("simple", "Simple Form", "This is a content")
    .addButton("name", "This is a button")
    .addButton("name1", "Hi, im a button", "https://i.imgur.com/PPvUcoW.png")//ImageType is default URL in this case
    .addButton("name2", "This is other button", ImageType.PATH, "textures/ui/feedIcon.png")
    .sendTo(player);
```
Custom Example
```java
import com.denzelcode.form.FormAPI;

List<String> optionsDropdown = new ArrayList<String>(){{
    add("Option 1");
    add("Option 2");
}};

FormAPI.customWindowForm("custom", "Custom Form")
    .addInput("name", "Fill the input", "Hello, im the input")
    .addDropdown("name1", "text", optionsDropdown)
    .addLabel("name2, "This a label")
    .addSlider("name3", "This is a slider", 1f, 10f)
    .addToggle("name4", "This is a toggle", false)
    .sendTo(player);
```

## Licensing information
This project is licensed under LGPL-3.0. Please see the [LICENSE](/LICENSE) file for details.

## Donations
* [PayPal](https://paypal.me/DenzelGiraldo)
