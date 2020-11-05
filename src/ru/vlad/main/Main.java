package ru.vlad.main;

import ru.vlad.strategy.StrategyDeleteLastRequest;
import ru.vlad.utils.CashGeneral;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO: Передать в конструктор одну из стратегий удаления и проверить работу
        new CashGeneral(new StrategyDeleteLastRequest()).mainMethod();
    }
}
