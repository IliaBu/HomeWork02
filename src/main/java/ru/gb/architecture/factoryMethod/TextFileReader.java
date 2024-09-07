package ru.gb.architecture.factoryMethod;

import ru.gb.architecture.templateMethod.LogEntry;
import ru.gb.architecture.templateMethod.LogReader;

public class TextFileReader extends LogReader {

    @Override
    public Object getDataSource() {
        throw new UnsupportedOperationException("Unimplemented method 'getDataSource'");
    }

    @Override
    public void setDataSource(Object data) {
        throw new UnsupportedOperationException("Unimplemented method 'setDataSource'");
    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        throw new UnsupportedOperationException("Unimplemented method 'readEntries'");
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        throw new UnsupportedOperationException("Unimplemented method 'parseLogEntry'");
    }

}
