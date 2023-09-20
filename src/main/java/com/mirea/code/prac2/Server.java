package com.mirea.code.prac2;

import lombok.SneakyThrows;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        new Thread(new ListenTask(Port.ONE)).start();
        new Thread(new ListenTask(Port.TWO)).start();
        new Thread(new ListenTask(Port.THREE)).start();
        new Thread(new ListenTask(Port.FOUR)).start();
        new Thread(new ListenTask(Port.FIVE)).start();
    }

    private record ListenTask(Port port) implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            var serverSocket = new ServerSocket(port.getPort());
            var clientSocket = serverSocket.accept();

            Scanner in = new Scanner(clientSocket.getInputStream());
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            System.out.println(Thread.currentThread().getId() + "thread started listening requests");
            while (in.hasNext()) {
                System.out.println("Получен запрос на порту: " + this.port.getPort());
                switch (port) {
                    case ONE -> out.println(task1(in.nextLine()));
                    case TWO, FIVE, FOUR, THREE -> {
                        return;
                    }
                    default -> throw new IllegalArgumentException();
                }
            }

            serverSocket.close();
            clientSocket.close();
        }
    }

    private static String task1(String args) {
        return args + " processed by the server";
    }
}