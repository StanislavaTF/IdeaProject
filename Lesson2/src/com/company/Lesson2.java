package com.company;

public class Lesson2 {

    public static void main(String[] args) throws MyArrayDataException {
        positiveTestSizeAndData();
        negativeTestSizeArray();
        negativeTestDataArray();
    }

    public static void positiveTestSizeAndData() throws MyArrayDataException {
        String[][] correctArray = new String[][]{{"1", "2", "4", "5"}, {"0", "1", "1", "1"}, {"2", "3", "4", "4"}, {"4", "4", "4", "4"}};
        try {
            arrayProcessor(correctArray);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
        System.out.println("1-Array of correct size");
    }

    public static void negativeTestSizeArray() throws MyArrayDataException {
        String[][] wrongSizeArray = new String[][]{{"1", "1"}, {"2", "2"}};
        try {
            arrayProcessor(wrongSizeArray);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
        System.out.println("2-Array of incorrect size");
    }
    public static void negativeTestDataArray() throws MyArrayDataException {
        String[][] textData = new String[][]{{"1", "Text", "4", "5"}, {"0", "1", "1", "1"}, {"2", "3", "4", "4"}, {"4", "4", "4", "4"}};
        try {
            arrayProcessor(textData);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("3-Element is not a digit!");
        }

    }
    public static void arrayProcessor(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length == 4 && array[0].length == 4) {
            System.out.println(getSum(array));
        } else {
            throw new MyArraySizeException();
        }
        
    }

    public static int getSum(String[][] array) throws NumberFormatException, MyArrayDataException {
        int sum = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException();
                }
            }

        }
        return sum;
    }

}