package ru.gothmog.core.interfaces;

import ru.gothmog.core.model.Color;

/**
 * Расширяет базовый интерфейс TrafficLight. Добавляет методы для get/set текущего времени, текущего цвета.
 */
public interface Light extends TrafficLight {
    /**
     * Вычисляет цвет, который будет светить в указанное время.
     *
     * @param time, когда нужно вычислить цвет.
     * @return Color который будет установлен в это время.
     */
    Color getColorByTime(int time);

    /**
     * @return Color устанавливаемый в светофоре.
     */
    Color getCurrentColor();

    /**
     * @return Текущее время, установленное в светофоре.
     */
    int getCurrentTime();

    void setCurrentTime(int currentTime);

    /**
     * Пользователь записывает время свечения для каждого цвета и минуту «TrafficLight» отдает цвет, который будет подсвечен в эту минуту.
     */
    void drawColorByMinuteTwo();
}
