public class ObjectList {
    private int numElements = 0;
    private Object[] list;

    /**
     * No-arg constructor that initializes the Object array to 0 elements
     */
    public ObjectList() {
        list = new Object[0];
    }

    public int getNumElements() {
        return numElements;
    }

    public int length() {
        return list.length;
    }

    /**
     * Takes in an object and expands the existing ObjectList to make
     * room for the new object. Appends the new object to the last index.
     * @param input
     */
    public void add(Object input) {
        expandList();
        list[numElements++] = input;
    }

    /**
     * Returns a FractionCounter type-casted object from the ObjectList
     * at the specified index.
     * @param index
     * @return
     */
    public FractionCounter get(int index) {
        return (FractionCounter)list[index];
    }

    @Override
    public String toString() {
        String retVal = "";
        for(int i = 0; i < numElements; i++) {

            retVal = retVal + list[i] + ", ";
        }
        return retVal;
    }

    /**
     * Helper method to expand the ObjectList by 1 element. A temporary
     * Object array is created and the original contents of the
     * ObjectList are transferred into the expanded array. Sets the
     * original array to the expanded array.
     */
    private void expandList() {
        Object[] expandedList = new Object[numElements + 1];

        System.arraycopy(list, 0, expandedList, 0, list.length);

        list = expandedList;
    }

}

