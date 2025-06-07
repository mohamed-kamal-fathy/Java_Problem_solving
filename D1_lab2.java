package src.Main;

public class D1_lab2 {

    private double real;
    private double imagin;

    // Constructor
    public D1_lab2(double real, double imagin) {
        this.real = real;
        this.imagin = imagin;
    }

    // Add
    public D1_lab2 add(D1_lab2 n) {
        return new D1_lab2(
                this.real + n.real,
                this.imagin + n.imagin
        );
    }

    // Subtract
    public D1_lab2 subtract(D1_lab2 n) {
        return new D1_lab2(
                this.real - n.real,
                this.imagin - n.imagin
        );
    }

    // Print complex number
    public void print() {
        System.out.println(this);
    }



    public String toString() {
        if (imagin >= 0) {
            return real + " + " + imagin + "i";
        } else {
            return real + " - " + Math.abs(imagin) + "i";
        }
    }


    public static void main(String[] args) {
        // Create complex numbers
        D1_lab2 num1 = new D1_lab2(5, 6);
        D1_lab2 num2 = new D1_lab2(3, -4);
        num1.print();
        num2.print();
        System.out.print("add = "); num1.add(num2).print();
        System.out.print("sub = "); num2.subtract(num1).print();
    }
}