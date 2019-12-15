import commands.*;
import org.quteshell.Quteshell;
import org.quteshell.commands.Clear;
import org.quteshell.commands.Echo;
import org.quteshell.commands.History;
import org.quteshell.commands.Welcome;

import java.net.ServerSocket;
import java.util.ArrayList;

public class Main {
    private static final int PORT = 8000;
    private static final ArrayList<Quteshell> quteshells = new ArrayList<>();

    private static boolean listening = true;

    public static void main(String[] args) {
        Quteshell.Configuration.setName("hycr");
        Quteshell.Configuration.setOnConnect(shell -> {
            shell.write("┏━━━━━━━━━━━━━━━━<");
            shell.write("Hypocrypt", Quteshell.Color.LightRed);
            shell.write(">━━━━━━━━━━━━━━━━┓");
            shell.writeln();
            for (String line : new String[]{
                    " Welcome to the SEcret crypto interface. ",
                    "Usage: type 'key', 'encrypt' or 'decrypt'",
                    "Note that the algorithm is opensource and",
                    "  May have faults that make it insecure  "
            }) {
                shell.write("┃ ");
                shell.write(line, Quteshell.Color.LightBlue);
                shell.write(" ┃");
                shell.writeln();
            }
            shell.write("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            shell.writeln();
//                shell.writeln("┏━━━━━━━━━━━━━━━━━Hypocrypt━━━━━━━━━━━━━━━━━┓");
//                shell.writeln("┃  Welcome to the SEcret crypto interface.  ┃");
//                shell.writeln("┃ Usage: type 'key', 'encrypt' or 'decrypt' ┃");
//                shell.writeln("┃ Note that the algorithm is opensource and ┃");
//                shell.writeln("┃   May have faults that make it insecure   ┃");
//                shell.writeln("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        });
        Quteshell.Configuration.Commands.add(Key.class);
        Quteshell.Configuration.Commands.add(Encrypt.class);
        Quteshell.Configuration.Commands.add(Decrypt.class);
        Quteshell.Configuration.Commands.add(Flag.class);
        Quteshell.Configuration.Commands.add(EFWK.class);
        Quteshell.Configuration.Commands.add(DFWK.class);

        Quteshell.Configuration.Commands.remove(Welcome.class);
        Quteshell.Configuration.Commands.remove(Echo.class);
        Quteshell.Configuration.Commands.remove(History.class);
        Quteshell.Configuration.Commands.remove(Clear.class);
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (listening) {
                quteshells.add(new Quteshell(serverSocket.accept()));
            }
        } catch (Exception e) {
            System.out.println("Host - " + e.getMessage());
        }
    }
}
