import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    
    //Static variables so all methods have access
    static String currFracString = "";
    static boolean foundFraction = false;

    static int[] currFractionArray = new int[2];
    static ObjectList fracHolder = new ObjectList();

    public static void main(String[] args) {

        Scanner input = null;

        //try-catch for inputting fractions.txt
        try {
            input = new Scanner(new FileInputStream("fractions.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File \"fractions.txt\" not found.");
            System.out.println("Exiting program...");
            System.exit(0);
        }
        
        /**
         * Main while loop to ingest a fraction, check for zero denominators,
         * check against ObjectList, and input unique fractions into the
         * ObjectList.
         */
        while (input.hasNextLine()) {
            foundFraction = false;
            currFracString = input.nextLine();
            currFractionArray = parseFraction(currFracString);
            Fraction currFracObj = new Fraction(currFractionArray[0], currFractionArray[1]);

            //Checks for zero denominators and skips any
            if (Fraction.hasZeroDenom(currFracObj)) {
                continue;
            }
            
            //for loop to iterate over the ObjectList
            for (int i = 0; i < fracHolder.getNumElements(); i++) {
                if (fracHolder.get(i).compareAndIncrement(currFracObj)) {
                    foundFraction = true;
                    continue;
                }
            }

            //Adds the current fraction if it hasn't been found in the ObjectList
            if (!(foundFraction)) {
                FractionCounter currFracCountObj = new FractionCounter(currFracObj);
                currFracCountObj.increment();
                fracHolder.add(currFracCountObj);
                
            }
        }

        //Copies numElements into a static variable so that printResults can access it
        printResults(fracHolder.getNumElements());
    }

    /**
     * Takes in a fraction in String form, "num/denom", and splits its
     * numerator and denominator into a 2 element int array, in the form
     * of [num, denom].
     * @param fracString
     * @return
     */
    public static int[] parseFraction(String fracString) {
        String[] fracStringArray = fracString.split("/", 2);
        int[] retArray = new int[2];

        for (int i = 0; i < 2; i++) {
            retArray[i] = Integer.parseInt(fracStringArray[i]);
        }

        return retArray;
    }

    /**
     * Takes in the number of elements in the ObjectList and uses a for loop
     * to iterate over each element in the list, printing each FractionCounter
     * object.
     * @param numElements
     */
    public static void printResults(int numElements) {
        System.out.println("Printing results...");
        System.out.println();

        for (int i = 0; i < numElements; i++) {
            System.out.println(fracHolder.get(i));
        }
    }

}
