public class FractionCounter {
    private Fraction currFraction;
    private int counter;

    //no-arg constructor
    public FractionCounter() {

    }

    //Constructor that inputs a Fraction and sets counter to 0
    public FractionCounter(Fraction theFraction) {
        currFraction = theFraction;
        counter = 0;
    }

    public Fraction getFraction() {
        return currFraction;
    }

    //Increments counter, for later use in Driver
    public void increment() {
        counter++;
    }

    /**
     * Compares the existing Fraction within the current FractionCounter object
     * with a different Fraction object. If they are the same, counter is
     * incremented for the FractionCounter object.
     * @param newFraction
     * @return
     */
    public boolean compareAndIncrement(Fraction newFraction) {
        
        if (currFraction.equals(newFraction)) {
            counter++;
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        return (currFraction + " has a count of: " + counter);
    }
}
