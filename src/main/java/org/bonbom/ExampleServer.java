package org.bonbom;

import org.bonbom.commands.Command;
import org.bonbom.commands.CommandImpl;

public class ExampleServer extends Server {

    public ExampleServer(int port) {
        super(port);
        this.registerMethods(this);
    }

    @Override
    public String getName() {
        return "server";
    }

    public static void main(String[] args) throws Exception {
        Server server = new ExampleServer(0);
        server.start();
        Thread.sleep(1000);
        System.out.println(server.getPort());
        server.registerMethods(Command.class, CommandImpl.class);
    }
}
