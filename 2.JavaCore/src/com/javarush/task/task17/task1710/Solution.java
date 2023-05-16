package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        crud(args);
    }
    public static void crud(String[] args) throws ParseException {
        String[] param = args;

        switch (param[0]) {
            case "-c":
                SimpleDateFormat currentSimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = currentSimpleDateFormat.parse(param[3]);
                if (param[2].equals("м")) {
                    allPeople.add(Person.createMale(param[1], date));
                } else {
                    allPeople.add(Person.createFemale(param[1], date));
                }
                System.out.println(allPeople.size() - 1);
                break;
            case "-u":
                currentSimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                date = currentSimpleDateFormat.parse(args[4]);
                if (args[3].equals("м")) {
                    allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                    allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
                    allPeople.get(Integer.parseInt(args[1])).setBirthDate(date);
                } else if (args[3].equals("ж")) {
                    allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                    allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
                    allPeople.get(Integer.parseInt(args[1])).setBirthDate(date);
                }
                break;
            case "-d":
                Person person = allPeople.get(Integer.parseInt(param[1]));
                person.setBirthDate(null);
                person.setSex(null);
                person.setName(null);
                break;
            case "-r":
                person = allPeople.get(Integer.parseInt(param[1]));
                currentSimpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " +
                        currentSimpleDateFormat.format(person.getBirthDate()));
                        break;
                        }
                    }
                }





