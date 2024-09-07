package ru.gb.architecture.builderMethod;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Класс возвращает объект из пула, если он доступен, или создает новый, если ни один из них недоступен.
 * Метод сначала проверяет разблокированные объекты, чтобы определить, можно ли их использовать повторно.
 * Если найден объект, который не превысил время простоя и действителен, он возвращается.
 * В противном случае создается новый объект, добавляется к заблокированным объектам и возвращается.
 */
public abstract class ObjectPool<T> {
    private final long deadTime;
    private final Hashtable<T, Long> lock;
    private final Hashtable<T, Long> unlock;

    public ObjectPool() {
        deadTime = 50000; // 50 секунд
        lock = new Hashtable<>();
        unlock = new Hashtable<>();
    }

    abstract T create();

    abstract boolean validate(T o);

    abstract void dead(T o);

    public synchronized T takeOut() {
        long now = System.currentTimeMillis();
        T t;
        if (unlock.size() > 0) {
            Enumeration<T> e = unlock.keys();
            while (e.hasMoreElements()) {
                t = e.nextElement();
                if ((now - unlock.get(t)) > deadTime) {
                    unlock.remove(t);
                    dead(t);
                    t = null;
                } else {
                    if (validate(t)) {
                        unlock.remove(t);
                        lock.put(t, now);
                        return t;
                    } else {
                        unlock.remove(t);
                        dead(t);
                        t = null;
                    }
                }
            }
        }
        t = create();
        lock.put(t, now);
        return t;
    }

    public synchronized void takeIn(T t) {
        lock.remove(t);
        unlock.put(t, System.currentTimeMillis());
    }
}