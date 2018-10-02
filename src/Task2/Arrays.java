package Task2;

public abstract class Arrays {

    public static int sumStringArray(String[][] mas) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (mas == null || mas.length != 4) {
            throw new MyArraySizeException();
        }
        try {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    sum += Integer.parseInt(mas[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException(" Ошибка конвертирования в число");
        }
        return sum;
    }

    public static String[][] toGenSquareMas(int size) {
        String[][] squareMas = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int a = (int) (Math.random() * 10);
                squareMas[i][j] = String.valueOf(a);
            }
        }
        return squareMas;
    }

    public static void toPrintMas(String[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
