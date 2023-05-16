package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c":
                for (int i = 1; i < args.length; i += 3) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date bd = sdf.parse(args[i + 2]);
                    if (args[i + 1].equals("м")) {
                        allPeople.add(Person.createMale(args[i], bd));
                    } else {
                        allPeople.add(Person.createFemale(args[i], bd));
                    }
                    System.out.println(allPeople.size() - 1);
                }
            case "-u":
                for (int i = 1; i < args.length; i += 4) {
                    Person person = allPeople.get(Integer.parseInt(args[i]));
                    person.setName(args[i + 1]);
                    person.setSex(args[i + 2].equals("м") ? Sex.MALE : Sex.FEMALE);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date bd = sdf.parse(args[i + 3]);
                    person.setBirthDate(bd);
                    break;
                }
            case "-d":
                for (int i = 1; i < args.length; i++)
                {
                    Person person = allPeople.get(Integer.parseInt(args[i]));
                    person.setBirthDate(null);
                    person.setSex(null);
                    person.setName(null);
                }
            case "-i":
                for (int i = 1; i < args.length; i++)
                {
                    Person person = allPeople.get(Integer.parseInt(args[i]));
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + sdf.format(person.getBirthDate()));
                }
        }
    }
}