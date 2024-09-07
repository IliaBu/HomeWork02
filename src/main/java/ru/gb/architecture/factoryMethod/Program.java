package ru.gb.architecture.factoryMethod;

import ru.gb.architecture.templateMethod.LogEntry;
import ru.gb.architecture.templateMethod.LogReader;

public class Program {

    public static String data = """
            У лукоморья дуб зеленый;
            Златая цепь на дубе том:
            И днем и ночью кот ученый
            Все ходит по цепи кругом;
            Идет направо - песнь заводит,
            Налево - сказку говорит...""";

    public static void main(String[] args) {
        LogReader logReader = new ConcreteReaderCreator()
                .createLogReader(LogType.Poem, data, 5);

        for (LogEntry log : logReader.readLogEntry()) {
            System.out.println(log.getText());
        }

    }
}
