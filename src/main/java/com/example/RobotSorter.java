package com.example;

public class RobotSorter {
    public enum STACK_TYPE {
        STANDARD,
        SPECIAL,
        REJECTED
    }

    private static int BULKY_VOLUME_THRESHOLD = 1000000;
    private static int BULKY_DIMENSION_THRESHOLD = 150;
    private static int HEAVY_THRESHOLD = 20;

    public RobotSorter() {
    }

    public String sort(double width, double height, double length, double mass) {

        boolean isBulky = false;
        boolean isHeavy = false;

        double volume = width * height * length;
        if (volume > BULKY_VOLUME_THRESHOLD || width > BULKY_DIMENSION_THRESHOLD
                || height > BULKY_DIMENSION_THRESHOLD || length > BULKY_DIMENSION_THRESHOLD) {
            isBulky = true;
        }
        if (mass > HEAVY_THRESHOLD) {
            isHeavy = true;
        }

        if (isBulky && isHeavy) {
            return STACK_TYPE.REJECTED.name();
        } else if (isBulky || isHeavy) {
            return STACK_TYPE.SPECIAL.name();
        } else {
            return STACK_TYPE.STANDARD.name();
        }
    }
}