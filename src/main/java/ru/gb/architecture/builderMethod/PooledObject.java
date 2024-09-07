package ru.gb.architecture.builderMethod;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Класс представляет собой объекты, создание которых требует больших затрат или имеют ограниченную доступность.
 */
public class PooledObject {
    private final Connection connection;

    public PooledObject(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isClosed() {
        try {
            return connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }
}