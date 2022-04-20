package main;


import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 8980;
        JavaPythonProxyServer server = new JavaPythonProxyServer(port);
        server.start();
        server.blockUntilShutdown();
    }
}
