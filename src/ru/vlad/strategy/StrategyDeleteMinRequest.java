package ru.vlad.strategy;

import ru.vlad.utils.CashGeneral;
import ru.vlad.utils.Command;

import java.util.Map;

public class StrategyDeleteMinRequest implements DeleteStrategy {
    @Override
    public boolean delete() {
        Command command = null;
        int min = Integer.MAX_VALUE;
        for (Map.Entry<String, Command> pair : CashGeneral.cashMap.entrySet()) {
            Command buffCommand = pair.getValue();
            if (buffCommand.getCountRequests() < min) {
                if (!buffCommand.getKey().equals(CashGeneral.lastCommand)) {
                    min = buffCommand.getCountRequests();
                    command = buffCommand;
                }
            }
        }
        assert command != null;
        return CashGeneral.cashMap.remove(command.getKey()) != null;
    }
}
