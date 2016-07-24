package ru.sbt.model;

public class Person {
    private final Gender personGender;
    private final String personName;
    private Person spouse;

    public Person (Gender gender, String name) {
        this.personGender = gender;
        this.personName = name;
    }

    public Person () {
        this.personGender = Gender.MALE;
        this.personName = "Anonymous";
    }

    public Person identification (String name) {
        return new Person(this.personGender, name);
    }

    public void personBio () {
        StringBuilder bio = new StringBuilder();
        bio.append("Bio: ").append(this.personName).append(" (");
        char genderID = (this.personGender == Gender.MALE) ? 'M' : 'F';
        String status = (this.spouse != null ? "Married on " + this.spouse.getPersonName() : "Not married");
        bio.append(genderID).append(") ").append(status);
        System.out.println(bio.toString());
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
