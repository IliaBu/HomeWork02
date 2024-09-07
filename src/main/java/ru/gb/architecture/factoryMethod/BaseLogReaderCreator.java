package ru.gb.architecture.factoryMethod;

import ru.gb.architecture.templateMethod.LogReader;

public abstract class BaseLogReaderCreator {

    protected LogReader createLogReader(LogType logType, Object data, int pos) {
        LogReader logReader = createLogReaderInstance(logType);
        logReader.setDataSource(data);
        logReader.setCurrentPosition(pos);
        return logReader;
    }

    protected abstract LogReader createLogReaderInstance(LogType logType);

}
