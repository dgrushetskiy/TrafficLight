package ru.gothmog.core.interfaces;

/**
 * показывает цвет в указанное время.
 */
public interface TrafficLight {

    /**
     * Пользователь вводит минуту, и «TrafficLight» отдает цвет, который будет подсвечен в эту минуту.
     */
    void drawColorByMinute();
}
