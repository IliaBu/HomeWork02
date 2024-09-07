package ru.gb.architecture.factoryMethod;

import ru.gb.architecture.templateMethod.LogReader;
import ru.gb.architecture.templateMethod.PoemReader;

public class ConcreteReaderCreator extends BaseLogReaderCreator {

    @Override
    protected LogReader createLogReaderInstance(LogType logType) {
        return switch (logType) {
            case Poem -> new PoemReader();
            case Text -> new TextFileReader();
            case Database -> new DataBaseReader();
            case System -> new OperationSystemLogEventReader();
            default -> throw new IllegalArgumentException("Неподдерживаемый тип журнала: " + logType);
        };
    }

}
