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

    /**
     * Sort packages based on dimensions and mass. A "bulky" package is when volume (cm^3) > BULKY_VOLUME_THRESHOLD or
     * any dimension (cm) is > BULKY_DIMENSION_THRESHOLD. A "heavy" package is when mass (kg) > HEAVY_THRESHOLD.
     * @param width in centimeters
     * @param height in centimeters
     * @param length in centimeters
     * @param mass in kilograms
     * @return stack type based on the following criteria:
     *  "STANDARD": neither bulky nor heavy
     *  "SPECIAL": either bulky or heavy
     *  "REJECTED": both bulky and heavy
     */
    public String sort(double width, double height, double length, double mass) {
        this.validateInput(width, height, length, mass);
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

    private void validateInput(double width, double height, double length, double mass) {
        if (width <= 0 || height <= 0 || length <= 0 || mass <= 0) {
            throw new IllegalArgumentException("All dimensions and mass must be > 0");
        }
    }
}