abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {
    double x;
    double y;
    double z;

    public Triangle(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    double getPerimeter() {
        return x + y + z;
    }

    @Override
    double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - x) * (s - y) * (s - z));
    }
}

class Rectangle extends Shape {
    double x;
    double y;

    public Rectangle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    double getPerimeter() {
        return 2 * (x + y);
    }

    @Override
    double getArea() {
        return x * y;
    }
}

class Circle extends Shape {

    double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * this.r;
    }

    @Override
    double getArea() {
        return Math.PI * Math.pow(this.r, 2);
    }
}


