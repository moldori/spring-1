package hu.flow.demo;

public class HullData {

    private double volume;
    private double surface;

    public HullData() {};

    public HullData(double volume, double surface) {
        this.volume = volume;
        this.surface = surface;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    @Override
    public String toString() {
        return "HullData{" +
                "volume=" + volume +
                ", surface=" + surface +
                '}';
    }
}
