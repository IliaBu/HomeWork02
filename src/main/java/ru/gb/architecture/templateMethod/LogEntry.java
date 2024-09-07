package ru.gb.architecture.templateMethod;

/**
 * Запись лога
 */
public class LogEntry {

    private final String text;

    public LogEntry(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
