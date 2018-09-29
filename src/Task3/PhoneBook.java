package Task3;

import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<Abonent> abonent;

    public PhoneBook() {
        abonent = new ArrayList<>();
        abonent.add(new Abonent(1234, "Иванов"));
        abonent.add(new Abonent(5678, "Петров"));
        abonent.add(new Abonent(9012, "Сидоров"));
        abonent.add(new Abonent(3579, "Петров"));
        abonent.add(new Abonent(0246, "Королев"));
        abonent.add(new Abonent(8024, "Ленин"));
    }

    public void add(Integer number, String surename) {
        abonent.add(new Abonent(number, surename));
    }

    public void get(String surename) {
        System.out.println("Результаты поиска по фамилии " + surename + ":");
        for (Abonent i : abonent) {
            if (i.getSurename() == surename) {
                System.out.println(i.getSurename() + " " + i.getPhoneNumber());
            }
        }
        System.out.println();
    }
}
