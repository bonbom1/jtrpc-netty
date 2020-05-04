import commands.Command2;
import org.bonbom.Server;


public class ExampleServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.start();
        System.setProperty("source", "server");
        server.registerMethods(Command2.class);
    }
}


