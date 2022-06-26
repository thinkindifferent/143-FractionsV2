public class Fraction {
    private int numerator;
    private int denominator;

    //no-arg constructor
    public Fraction() {

    }

    /**
     * Constructor with two parameters for the Fraction's numerator and
     * denominator, respectively. The fraction is later reduced if the
     * denominator is nonzero.
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        
        reduceFraction();
    }

    public int getNumerator() {
        return this.numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    //Source: https://www.geeksforgeeks.org/euclidean-algorithms-basic-and-extended/
    private int gcd(int a, int b)
    {
        if (a == 0)
            return b;
          
        return gcd(b%a, a);
    }

    /**
     * Reduces fraction by dividing the numerator and denominator by their
     * greatest common denominator.
     */
    public void reduceFraction() {

        if (denominator != 0) { //Separate check from hasZeroDenom()
            int commonDenom = gcd(numerator, denominator);

            numerator = numerator / commonDenom;
            denominator = denominator / commonDenom;
        }
    }

    /**
     * Checks if the current Fraction and another Fraction are equal in
     * numerical value to each other.
     * @param other
     * @return
     */
    public boolean equals(Fraction other) {
        int outerProduct = this.numerator * other.denominator;
        int innerProduct = this.denominator * other.numerator;

        if (outerProduct == innerProduct) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return (numerator + "/" + denominator);
    }

    /**
     * Static method to check if any Fraction object has a zero denominator
     * and prints error messages, if necessary.
     * @param currFrac
     * @return
     */
    public static boolean hasZeroDenom(Fraction currFrac) {
        boolean retBool = false;

        if (currFrac.denominator == 0) {
            System.out.println("Error: " + currFrac + " has a zero denominator");
            System.out.println("Skipping fraction...");
            retBool = true;
        }

        return retBool;
    }

}