package ru.sbt.model;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private final Gender personGender;
    private final String personName;
    private final Person spouse;

    private Person(Gender gender, String name, Person spouse) {
        this.personGender = gender;
        this.personName = name;
        this.spouse = spouse;
    }

    public Person(Gender gender, String name) {
        this.personGender = gender;
        this.personName = name;
        this.spouse = null;
    }

    public Person() {
        this.personGender = Gender.MALE;
        this.personName = "Anonymous";
        this.spouse = null;
    }

    /**
     * This method sets person name after creating object
     *
     * @param name - real person name
     * @return - returns new Person object with changed name field
     */
    public Person identification(String name) {
        return new Person(this.getPersonGender(), name, this.getSpouse());
    }

    /**
     * This method show short information about person in formatted type:
     * Bio: [person name] ([person gender (M\F)]) Married on [spouse name], or Not married
     */
    public void personBio() {
        StringBuilder bio = new StringBuilder();
        bio.append("Bio: ").append(this.getPersonName()).append(" (");
        char genderID = (this.getPersonGender() == Gender.MALE) ? 'M' : 'F';
        String status = (this.getSpouse() != null ? "married on " + this.getSpouse().getPersonName() : "not married");
        bio.append(genderID).append(") ").append(status);
        System.out.println(bio.toString());
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns list of persons with updates statuses
     */
    public ArrayList<Person> marry(Person person) {
        ArrayList<Person> marriage = new ArrayList<>();
        if (this.getPersonGender() != person.getPersonGender()) {
            if ((this.getSpouse() == null) && (person.getSpouse() == null)) {
                marriage.add(new Person(this.getPersonGender(), this.getPersonName(), person));
                marriage.add(new Person(person.getPersonGender(), person.getPersonName(), this));
                marriage = this.updateList(marriage);
            } else if ((this.getSpouse() != null) || (person.getSpouse() != null)) {
                marriage.addAll(this.divorce());
                marriage.addAll(person.divorce());
                marriage.add(new Person(this.getPersonGender(), this.getPersonName(), person));
                marriage.add(new Person(person.getPersonGender(), person.getPersonName(), this));
                marriage = this.updateList(marriage);
            }
        }
        return marriage;
    }

    /**
     * Sets spouse = null if spouse is not null
     *
     * @return ArrayList<Person> - list of persons whose status has been changed
     */
    public ArrayList<Person> divorce() {
        ArrayList<Person> divorces = new ArrayList<>();
        if ((this.getSpouse() != null)) {
            divorces.add(new Person(this.getSpouse().getPersonGender(), this.getSpouse().getPersonName()));
            divorces.add(new Person(this.getPersonGender(), this.getPersonName()));
            divorces = this.updateList(divorces);
        }
        return divorces;
    }

    /**
     * This method removes duplicates in person list
     *
     * @return ArrayList<Person> - list of persons without duplicates
     */
    public ArrayList<Person> updateList(ArrayList<Person> checkList) {
        ArrayList<Person> result = new ArrayList<>();
        boolean exists = false;
        for (int i = checkList.size() - 1; i >= 0; i--) {
            if ((result.size() == 0) && (!Objects.equals(checkList.get(i).getPersonName(), "Anonymous"))) {
                result.add(checkList.get(i));
            } else {
                for (Person comparing : result) {
                    if (Objects.equals(comparing.getPersonName(), checkList.get(i).getPersonName())) {
                        exists = true;
                    }
                }
                if ((!exists) && (!Objects.equals(checkList.get(i).getPersonName(), "Anonymous"))) {
                    result.add(checkList.get(i));
                } else exists = false;
            }
        }
        return result;
    }

    public Gender getPersonGender() {
        return personGender;
    }

    public String getPersonName() {
        return personName;
    }

    public Person getSpouse() {
        return spouse;
    }
}
