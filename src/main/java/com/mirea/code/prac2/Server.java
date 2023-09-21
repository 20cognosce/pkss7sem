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
                    case ONE -> out.println(Task3.calculate(in.nextLine()));
                    case TWO -> out.println(Task6.calculate(in.nextLine()));
                    case THREE -> out.println(Task9.calculate(in.nextLine()));
                    case FOUR -> out.println(Task12.calculate(in.nextLine()));
                    case FIVE -> out.println(Task15.calculate(in.nextLine()));
                    default -> throw new IllegalArgumentException();
                }
            }

            serverSocket.close();
            clientSocket.close();
        }
    }
}