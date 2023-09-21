package com.mirea.code.prac2;

import lombok.SneakyThrows;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println(
                "Первый ввод - номер задания [1:5]. " +
                "Второй - аргументы в одну строку через пробел. \n" +
                "Элементы массивов передаются через запятую: x1,x2 y1,y2. Так же и координаты точек: 1.0,1.1 2.0,2.1");

        var sockets = openSockets();
        var inputStreams = new HashMap<Port, Scanner>() {{
            for (var entry : sockets.entrySet()) {
                put(entry.getKey(), new Scanner(entry.getValue().getInputStream()));
            }
        }};

        var outputStreams = new HashMap<Port, PrintWriter>() {{
            for (var entry : sockets.entrySet()) {
                put(entry.getKey(), new PrintWriter(entry.getValue().getOutputStream(), true));
            }
        }};

        Scanner scanner = new Scanner(System.in);
        int taskNumber = 0;

        while (taskNumber != -1) {
            switch (taskNumber = Integer.parseInt(scanner.nextLine())) {
                case 1 -> {
                    outputStreams.get(Port.ONE).println(scanner.nextLine());
                    System.out.println("Отправлен запрос на порт: " + Port.ONE.getPort());
                }
                case 2 -> {
                    outputStreams.get(Port.TWO).println(scanner.nextLine());
                    System.out.println("Отправлен запрос на порт: " + Port.TWO.getPort());
                }
                case 3 -> {
                    outputStreams.get(Port.THREE).println(scanner.nextLine());
                    System.out.println("Отправлен запрос на порт: " + Port.THREE.getPort());
                }
                case 4 -> {
                    outputStreams.get(Port.FOUR).println(scanner.nextLine());
                    System.out.println("Отправлен запрос на порт: " + Port.FOUR.getPort());
                }
                case 5 -> {
                    outputStreams.get(Port.FIVE).println(scanner.nextLine());
                    System.out.println("Отправлен запрос на порт: " + Port.FIVE.getPort());
                }
                default -> {
                    System.out.println("Incorrect task number.");
                    continue;
                }
            }

            Scanner in = inputStreams.get(Port.of(5000 + taskNumber));
            while (in.hasNext()) {
                System.out.println(in.nextLine());
                break;
            }
        }

        closeSockets(sockets.values());
    }

    @SneakyThrows
    private static Map<Port, Socket> openSockets() {
        Map<Port, Socket> result = new HashMap<>();
        for (Port port : Port.values()) {
            result.put(port, new Socket("localhost", port.getPort()));
        }
        return result;
    }

    @SneakyThrows
    private static void closeSockets(Collection<Socket> sockets) {
        for (Socket socket : sockets) {
            socket.close();
        }
    }
}