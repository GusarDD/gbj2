package Task3;

import java.util.HashMap;

public class Task3 {

    static String[] masStr = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "zero", "zero", "two", "three", "three"};

    static HashMap<String, Integer> hmWord = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Part 1");
        createWords();
        System.out.println(hmWord.toString());
        System.out.println();

        System.out.println("Part 2");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(7531, "Гагарин");
        phoneBook.add(7851, "Петров");
        phoneBook.add(1111, "Сидоров");

        phoneBook.get("Гагарин");
        phoneBook.get("Петров");
        phoneBook.get("Сидоров");
    }

    public static void createWords() {
        for (String i : masStr) {
            int val = ((hmWord.get(i) == null) ? 1 : hmWord.get(i) + 1);
            hmWord.put(i, val);
        }
    }
}
