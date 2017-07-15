package ru.gothmog.core.model;

/**
 * Каждый цвет имеет значение «glowTime», в котором хранится время за которое горит свет
 */
public enum Color {
    Green(2),
    Yellow(3),
    Red(5);

    /**
     * Поле glowing-time.
     */
    private int glowTime;

    Color(int glowTime) {
        this.glowTime = glowTime;
    }

    public int getGlowTime() {
        return glowTime;
    }

    public void setGlowTime(int glowTime) {
        this.glowTime = glowTime;
    }
}
