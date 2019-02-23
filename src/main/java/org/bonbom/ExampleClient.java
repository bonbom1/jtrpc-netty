package org.bonbom;

import org.bonbom.commands.Command;
import org.bonbom.commands.Commands;
import org.bonbom.commands.ServerInfo;

public class ExampleClient extends Client {

    public ServerInfo serverInfo;

    public ExampleClient(String host, int port) throws Exception {
        super(host, port);
        this.start();
        serverInfo = Enhancement.createProxy(this, ServerInfo.class, false);
    }

    @Override
    public String getName() {
        return "client1233";
    }

    public static void main(String[] args) throws Exception {
        Client client = new ExampleClient("localhost", 8080);
        System.out.println(((ExampleClient) client).serverInfo.sendBack("test230", "test32"));
    }

    public static void main3(String[] args) throws Exception {
        Client client = new ExampleClient("localhost", 8080);
        client.registerMethods(Commands.class);
        Command command = Enhancement.createProxy(client, Command.class);
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(command.output("test"));
        }
        System.out.println(System.currentTimeMillis() - time);
    }

    public static void main2(String[] args) {
        System.out.println("statistics is null: " + "aa" == null);
    }
}
