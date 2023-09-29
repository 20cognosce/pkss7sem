package com.mirea.code.prac3.server;

import com.mirea.code.prac3.route.Port;
import com.mirea.code.prac3.server.task12.Task12Server;
import com.mirea.code.prac3.server.task15.Task15Server;
import com.mirea.code.prac3.server.task3.Task3Server;
import com.mirea.code.prac3.server.task6.Task6Server;
import com.mirea.code.prac3.server.task9.Task9Server;
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
            in.useDelimiter("\n");
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            System.out.println(Thread.currentThread().getId() + "thread started listening requests");
            while (in.hasNext()) {
                System.out.println("Получен запрос на порту: " + this.port.getPort());
                switch (port) {
                    case ONE -> out.println(Task3Server.calculate(in.nextLine()));
                    case TWO -> out.println(Task6Server.calculate(in.nextLine()));
                    case THREE -> {
                        out.println(Task9Server.calculate());
                        in.nextLine();
                    }
                    case FOUR -> {
                        out.println(Task12Server.calculate());
                        in.nextLine();
                    }
                    case FIVE -> out.println(Task15Server.calculate(in.nextLine()));
                    default -> throw new IllegalArgumentException();
                }
            }

            serverSocket.close();
            clientSocket.close();
        }
    }
}