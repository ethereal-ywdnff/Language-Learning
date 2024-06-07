package core;

public class Wheel extends Component  {

    private double diameter;
    private WheelStyle wheelStyle;
    private BrakeType brakeType;
    private int uniqueKey;

    public Wheel(double a, WheelStyle b, BrakeType c) {
        this.diameter = a;
        this.wheelStyle = b;
        this.brakeType = c;
    }

    public double getDiameter() {
        return diameter;
    }

    public WheelStyle getWheelStyle() {
        return wheelStyle;
    }

    public BrakeType getBrakeType() {
        return brakeType;
    }

}
