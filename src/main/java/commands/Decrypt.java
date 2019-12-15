package commands;

import hypocrypt.SECrypto;
import org.quteshell.Command;
import org.quteshell.Elevation;
import org.quteshell.Quteshell;
import org.quteshell.commands.Help;

@Elevation(1)
@Help.Description("Decrypts the parameter")
public class Decrypt implements Command {
    @Override
    public void execute(Quteshell shell, String arguments) {
        if (arguments != null) {
            for (Command command : shell.getCommands()) {
                if (command instanceof Key) {
                    String key = ((Key) command).key;
                    shell.writeln(SECrypto.decrypt(arguments, key));
                }
            }
        }else{
            shell.writeln("Does not accept empty strings.");
        }
    }
}
