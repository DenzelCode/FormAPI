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
        FormAPI.customWindowForm("custom", "Custom Form")
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
import com.denzelcode.form.element.Input;
import com.denzelcode.form.event.PlayerCustomFormSubmit;
import com.denzelcode.form.window.CustomWindowForm;

public class EventListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onSubmit(PlayerCustomFormSubmit event) {
        CustomWindowForm form = event.getForm();
        Player player = event.getPlayer();

        if (!form.getName().equals("custom")) return;

        Input username = form.getElement("username");
        Input password = form.getElement("password");

        player.sendMessage("Player: " + player.getName());
        player.sendMessage("Form: " + form.getName());
        player.sendMessage("Username: " + username.getValue());
        player.sendMessage("Password: " + password.getValue());
    }
}

```

- Run command /test and you will have this showed in-game:
[Screenshot](https://i.imgur.com/PPvUcoW.png)

If you submit the form you are going to have receive a message like this:
[Screenshot](https://i.imgur.com/kOLXmet.png)

## Licensing information
This project is licensed under LGPL-3.0. Please see the [LICENSE](/LICENSE) file for details.

## Donations
* [PayPal](https://paypal.me/DenzelGiraldo)
