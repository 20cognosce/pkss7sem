package com.mirea.code.prac3.client;

import com.mirea.code.prac3.route.Port;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Client implements AutoCloseable {
    private final Map<Port, Scanner> inputStreams;
    private final Map<Port, PrintWriter> outputStreams;
    private final Map<Port, Socket> sockets;

    public Client() throws IOException {
        this.sockets = openSockets();

        this.inputStreams = new HashMap<>() {{
            for (var entry : sockets.entrySet()) {
                put(entry.getKey(), new Scanner(entry.getValue().getInputStream()));
            }
        }};

        this.outputStreams = new HashMap<>() {{
            for (var entry : sockets.entrySet()) {
                put(entry.getKey(), new PrintWriter(entry.getValue().getOutputStream(), true));
            }
        }};
    }

    public String sendRequestToServer(Port port, String payload) {
        outputStreams.get(port).println(payload);
        System.out.printf("Отправлен запрос {%s} на порт [%s] \n", payload, port.getPort());

        Scanner in = inputStreams.get(port);
        while (!in.hasNextLine()) {

        }

        return in.nextLine();
    }

    @Override
    public void close() {
        closeSockets(sockets.values());
    }

    @SneakyThrows
    private Map<Port, Socket> openSockets() {
        Map<Port, Socket> result = new HashMap<>();
        for (Port port : Port.values()) {
            result.put(port, new Socket("localhost", port.getPort()));
        }
        return result;
    }

    @SneakyThrows
    private void closeSockets(Collection<Socket> sockets) {
        for (Socket socket : sockets) {
            socket.close();
        }
    }
}