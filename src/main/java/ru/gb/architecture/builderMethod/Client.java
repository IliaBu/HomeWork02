package ru.gb.architecture.builderMethod;

import java.sql.Connection;

/**
 * Клиентский класс, использующий объект типа PooledObject.
 */
public class Client {
    public static void main(String[] args){
        JDBCConnectionPool pool = new JDBCConnectionPool(
                "org.h2.Driver", "jdbc:h2:mem:mydb",
                "user", "14587585");
        Connection con = pool.takeOut();
        pool.takeIn(con);
    }
}