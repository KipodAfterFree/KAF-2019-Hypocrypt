package commands;

import org.quteshell.Command;
import org.quteshell.Elevation;
import org.quteshell.Quteshell;
import org.quteshell.commands.Help;

@Elevation(1)
@Help.Description("DecryptFlagWithKey, decrypts the flag's raw cyphertext with the key.")
public class DFWK implements Command {
    @Override
    public void execute(Quteshell shell, String arguments) {
        shell.execute("decrypt "+Flag.FLAG);
    }
}
