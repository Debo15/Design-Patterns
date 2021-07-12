package Structural;

class Cylinder {
    private double radius;
    private double height;
    public Cylinder(){}
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }
}
class Cubic{
    private double width;
    private double height;
    Cubic(){}
    Cubic(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth(){ return width; }

    public double getHeight() { return height; }
}

class Hole{
    final private double radius;
    final private double height;

    Hole(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }
    public boolean fits(Cylinder cylinder){
        return (this.radius >= cylinder.getRadius() && this.height >= cylinder.getHeight());
    }
}

// now Hole.fits works only with Cylinder.
// But, what if you want to check whether a cubic can fit in the hole?
// and we can't edit the Hole class :) .

class CubicAdapter extends Cylinder{
    private Cubic cubic;
    public CubicAdapter(Cubic cubic) {
        this.cubic = cubic;
    }
    public double getRadius(){
        return cubic.getWidth() * Math.sqrt(2)/2;
    }
}

class AdapterDemo{
    public static void main(String[] args) {
        Hole hole = new Hole(5, 10);

        Cylinder cylinder = new Cylinder(5, 10);
        Cylinder cylinder1 = new Cylinder(6, 9);
        System.out.print("cylinder[1] can");
        if (!hole.fits(cylinder)) System.out.print("'t");
        System.out.println(" fit inside the hole");

        System.out.print("cylinder[2] can");
        if (!hole.fits(cylinder1)) System.out.print("'t");
        System.out.println(" fit inside the hole");



        Cubic cubic = new Cubic(5, 9);
        Cubic cubic1 = new Cubic(10, 5);

        CubicAdapter cubicAdapter = new CubicAdapter(cubic);
        CubicAdapter cubicAdapter1 = new CubicAdapter(cubic1);

        System.out.print("Cubic[1] can");
        if (!hole.fits(cubicAdapter)) System.out.print("'t");
        System.out.println(" fit inside the hole");

        System.out.print("Cubic[2] can");
        if (!hole.fits(cubicAdapter1)) System.out.print("'t");
        System.out.println(" fit inside the hole");
    }
}


