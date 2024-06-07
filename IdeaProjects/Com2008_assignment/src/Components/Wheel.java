package Components;

public class Wheel {

    private double diameter;
    private int wheelStyle;
    private int brakeType;
    private int uniqueKey;

    public Wheel(double a, int b, int c) {
        this.diameter = a;
        this.wheelStyle = b;
        this.brakeType = c;
    }

    public double getDiameter() {
        return diameter;
    }

    public int getWheelStyle() {
        return wheelStyle;
    }

    public int getBrakeType() {
        return brakeType;
    }

}
