package Task2;

import java.util.ArrayList;

import static Task2.Arrays.*;

public class Task_2 {
    public static void main(String[] args) {

        ArrayList<String[][]> testMas = new ArrayList<>();

        testMas.add(toGenSquareMas(4));
        testMas.add(toGenSquareMas(3));
        testMas.add(toGenSquareMas(4));
        testMas.get(2)[1][1] = "Y";

        for (String[][] i : testMas) {
            try {
                toPrintMas(i);
                System.out.println("Сумма переменных массива " + (testMas.indexOf(i) + 1) + " : " + sumStringArray(i));
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.out.println("Перехвачено исключение " + e);
//				e.printStackTrace();
            } finally {
                System.out.println("Конец обработки массива " + (testMas.indexOf(i) + 1));
                System.out.println();
            }
        }
    }
}
