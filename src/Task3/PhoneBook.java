package Task3;

import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<Abonent> abonents;

    public PhoneBook() {
        abonents = new ArrayList<>();
        abonents.add(new Abonent(1234, "Иванов"));
        abonents.add(new Abonent(5678, "Петров"));
        abonents.add(new Abonent(9012, "Сидоров"));
        abonents.add(new Abonent(3579, "Петров"));
        abonents.add(new Abonent(0246, "Королев"));
        abonents.add(new Abonent(8024, "Ленин"));
    }

    public void add(Integer number, String surename) {
        abonents.add(new Abonent(number, surename));
    }

    public void get(String surename) {
        System.out.println("Результаты поиска по фамилии " + surename + ":");
        for (Abonent i : abonents) {
            if (i.getSurename() == surename) {
                System.out.println(i.getSurename() + " " + i.getPhoneNumber());
            }
        }
        System.out.println();
    }
}
