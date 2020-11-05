package ru.vlad.utils;

import ru.vlad.strategy.DeleteStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CashGeneral {
    public static int cashSize;
    public static final Map<String, Command> cashMap = new HashMap<>();
    public static String lastCommand;
    private final DeleteStrategy deleteStrategy;

    public CashGeneral(DeleteStrategy deleteStrategy) {
        this.deleteStrategy = deleteStrategy;
    }

    public void mainMethod() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите размер кэша: ");
        cashSize = Integer.parseInt(reader.readLine()) + 1;
        while(true) {
            if (cashMap.size() < cashSize) {
                System.out.print("Введите команду: ");
                String command = reader.readLine();
                if (command.equals("")) break;
                lastCommand = command;
                if (!cashMap.containsKey(command)) {
                    System.out.printf("Результат команды %s " +
                            "не закеширован, введите пожалуйста результат: ", command);
                    String result = reader.readLine();
                    cashMap.put(command, new Command(result, command));
                    System.out.println("Результат сохранён!");
                } else {
                    Command bufferCommand = cashMap.get(command);
                    System.out.printf("Результатом выполнения команды %s является " +
                            "%s\n", command, bufferCommand.getResult());
                    bufferCommand.incrementCounterRequests();
                    bufferCommand.setDate(new Date());
                }
            } else deleteStrategy.delete();
        }
        reader.close();
    }
}
