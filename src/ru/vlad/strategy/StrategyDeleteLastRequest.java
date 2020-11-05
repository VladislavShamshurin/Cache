package ru.vlad.strategy;

import ru.vlad.utils.CashGeneral;
import ru.vlad.utils.Command;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class StrategyDeleteLastRequest implements DeleteStrategy {
    @Override
    public boolean delete() {
        Command command = null;
        Date date = new Date(2200, Calendar.DECEMBER, 30);
        for (Map.Entry<String, Command> pair : CashGeneral.cashMap.entrySet()) {
            Command buffCommand = pair.getValue();
            if (buffCommand.getDate().before(date)) {
                if (!buffCommand.getKey().equals(CashGeneral.lastCommand)) {
                    date = buffCommand.getDate();
                    command = buffCommand;
                }
            }
        }
        assert command != null;
        return CashGeneral.cashMap.remove(command.getKey()) != null;
    }
}
