package ru.vlad.strategy;

import ru.vlad.utils.CashGeneral;

public class StrategyDeleteLast implements DeleteStrategy {
    @Override
    public boolean delete() {
        return CashGeneral.cashMap.remove(CashGeneral.lastCommand) != null;
    }
}
