package com.mirea.code.prac2;

import lombok.SneakyThrows;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
* 3. Даны числа S, T. Получить с использованием функции пользователя F(T,-2S,1.17)+F(2.2,T,S-T) где F(A, B, C) = (2A-B-sin(C))/(5+C)
* 6. Составить пpогpамму для pасчета значений гипотенузы тpеугольника, опpеделив функцию, выполняющую этот pасчет.
     Катеты передаются в качестве параметров.
* 9. Найти площадь пятиугольника, кооpдинаты веpшин котоpого заданы.
     Опpеделить пpоцедуpу вычисления pасстояния между двумя точками, заданными своими кооpдинатами,
     и пpоцедуpу вычисления площади тpеугольника по тpем стоpонам. Описать функции с соответствующими формальными параметрами.
  12. Используя подпpогpамму - функцию, составить пpогpамму для печати знаков тpех чисел,
      введенных с клавиатуpы и передаваемых функции в качестве параметра
  15. Задав функцию, вывести на печать сpедние аpифметические двух массивов, введенных с клавиатуpы.
      Массив передается функции в качестве параметра
* */
public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println("Первый ввод - номер задания [1:5], второй - аргументы в одну строку через пробел.");
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