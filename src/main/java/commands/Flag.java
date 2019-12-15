package commands;

import org.quteshell.Command;
import org.quteshell.Quteshell;

public class Flag implements Command {
    @Override
    public void execute(Quteshell shell, String arguments) {
        shell.writeln("ʽԼ\u08B5ౄྂ႞ᑦᙠᬶṤ\u1F5E␌╭⒈ⶴㄐ㕓㜲㛙㢤䈳䒪䦕");
    }
}
