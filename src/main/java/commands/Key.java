package commands;

import org.quteshell.Command;
import org.quteshell.Elevation;
import org.quteshell.Quteshell;
import org.quteshell.commands.Help;

@Elevation(1)
@Help.Description("Sets the parameter as the key or shows the key")
public class Key implements Command {

    public String key = "1234";

    @Override
    public void execute(Quteshell shell, String arguments) {
        if (arguments == null) {
            shell.writeln("Key is: " + key);
        }else{
            key = arguments;
        }
    }
}
