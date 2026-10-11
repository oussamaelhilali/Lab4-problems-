package problem6;

public class Square extends Forme {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getSurface() {
        // Area = side * side
        return Math.round((side * side) * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Square (side " + side + " cm):";
    }
}