// Interface Drawable
interface Drawable {
    void draw();
}

// Interface Resizable
interface Resizable {
    void resize(double factor);
}

// Circle class implementing both Drawable and Resizable interfaces
class Circle implements Drawable, Resizable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius: " + radius);
    }

    @Override
    public void resize(double factor) {
        radius *= factor;
        System.out.println("Resized the circle to radius: " + radius);
    }

    public double getRadius() {
        return radius;
    }
}

// Rectangle class implementing only Drawable interface
class Rectangle implements Drawable {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle with length: " + length + " and width: " + width);
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}

// Main class to demonstrate the shape hierarchy
public class Main_7 {
    public static void main(String[] args) {
        // Creating instances of Circle and Rectangle
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(10.0, 5.0);

        // Drawing the shapes
        circle.draw();
        rectangle.draw();

        // Resizing the circle
        circle.resize(2.0);
        circle.draw();
    }
}
