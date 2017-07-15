package ru.gothmog.core.model;

import ru.gothmog.core.interfaces.Light;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Реализация Светофора
 */
public class TrafficLightImpl implements Light {
    private Color currentColor;
    private int currentTime;

    public TrafficLightImpl() {
        currentTime = 0;
        currentColor = Color.Green;//Первые две минуты горит зеленый свет.
    }

    @Override
    public void drawColorByMinute() {
        Scanner reader = new Scanner(System.in);
        try {
            String exit = "нет";
            while (!exit.equals("да")) {
                System.out.println("Введите минуту: ");
                try {
                    int minute = reader.nextInt();
                    System.out.println("В " + minute + " минуту цвет будет: " + getColorByTime(minute));
                    System.out.println("----------------------");
                    System.out.println("Выход: да/нет ");
                    exit = reader.next();
                } catch (InputMismatchException e) {
                    System.out.println("Минута должна быть цифрой.");
                    System.out.println("Минута должна быть положительной");
                    System.out.println("Время свечения всех цветов не должно быть равно нулю.");
                    exit = reader.next();
                }
            }
        } finally {
            reader.close();
        }
    }

    @Override
    public Color getColorByTime(int time) {
        return defineColor(time);
    }

    @Override
    public Color getCurrentColor() {
        return currentColor;
    }

    @Override
    public int getCurrentTime() {
        return currentTime;
    }

    @Override
    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
        currentColor = getColorByTime(currentTime);
    }

    @Override
    public void drawColorByMinuteTwo() {
        Scanner reader = new Scanner(System.in);
        try {
            String exit = "нет";
            while (!exit.equals("да")) {
                try {
                    System.out.println("Введите время свечения для зеленого цвета: ");
                    Color.Green.setGlowTime(reader.nextInt());
                    System.out.println("Введите время свечения для желтого цвета: ");
                    Color.Yellow.setGlowTime(reader.nextInt());
                    System.out.println("Введите время свечения для красного цвета: ");
                    Color.Red.setGlowTime(reader.nextInt());
                    System.out.println("Введите минуту: ");
                    int minute = reader.nextInt();
                    System.out.println("В " + minute + " минуту цвет будет: " + getColorByTime(minute));
                    System.out.println("----------------------");
                    System.out.println("Выход: да/нет ");
                    exit = reader.next();
                } catch (InputMismatchException e) {
                    System.out.println("Минута должна быть цифрой.");
                    System.out.println("Минута должна быть положительной");
                    System.out.println("Время свечения всех цветов не должно быть равно нулю.");
                    exit = reader.next();
                }
            }
        } finally {
            reader.close();
        }
    }

    /**
     * Определяет цвет в указанное время. 
     * @param time При которой необходимо вычислить цвет.
     * @return Color цвет который будет отображаться в это время.
     */
    private Color defineColor(int time) {
        checkTimeOnValid(time);
        checkGlowTimeOnValid();
        int minutes = convertTime(time);
        int greenGlowMinute = Color.Green.getGlowTime();
        int yellowGlowMinute = Color.Yellow.getGlowTime();
        int redGlowMinute = Color.Red.getGlowTime();
        if (minutes <= greenGlowMinute) {
            return Color.Green;
        }
        if (minutes <= yellowGlowMinute) {
            return Color.Yellow;
        } else {
            minutes -= greenGlowMinute;
        }
        if (minutes >= redGlowMinute) {
            return Color.Red;
        } else {
            return Color.Red;
        }
    }

    /**
     * @param time преобразуем
     * @return time
     */
    private int convertTime(int time) {
        int glowSum = getSumGlow();
        if (time > glowSum) {
            time %= glowSum;
        }
        return time;
    }

    /**
     * Время должно быть положительным числом.
     *
     * @param time проверка на валидацию
     */
    private void checkTimeOnValid(int time) {
        if (time < 0) {
            System.out.println("Значение определенного времени: " + time + " является недействительным. Значение должно быть положительным.");
        }
    }

    /**
     * Время свечения всех цветов не должно быть равно нулю.
     */
    private void checkGlowTimeOnValid() {
        if (getSumGlow() == 0) {
            System.out.println("Время свечения всех цветов равно нулю. Светящееся время для зеленого цвета: "
                    + Color.Green.getGlowTime() + ", Для желтого цвета: "
                    + Color.Yellow.getGlowTime() + ", Для красного цвета: "
                    + Color.Red.getGlowTime());
        }
    }

    /**
     * Вычисляет сумму всех минут свечения из трех цветов (зеленый, желтый, красный).
     *
     * @return сумма всех минут свечения.
     */
    private int getSumGlow() {
        return Color.Green.getGlowTime() + Color.Yellow.getGlowTime() + Color.Red.getGlowTime();
    }
}
