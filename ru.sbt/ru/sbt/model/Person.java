package ru.sbt.model;

public class Person {
    private final Gender personGender;
    private final String personName;
    private Person spouse;

    public Person(Gender gender, String name, Person spouse) {
        this(gender, name);
        this.marry(spouse);
    }

    public Person(Gender gender, String name) {
        this.personGender = gender;
        this.personName = name;
        this.spouse = null;
    }

    public Person() {
        this.personGender = Gender.MALE;
        this.personName = "Anonymous";
    }

    /**
     * This method sets person name after creating object
     *
     * @param name - real person name
     * @return - returns new Person object with changed name field
     */
    public Person identification(String name) {
        return new Person(this.getPersonGender(), name);
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
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        boolean marriage = false;
        if (this.getPersonGender() != person.getPersonGender()) {
            if ((this.getSpouse() == null) && (person.getSpouse() == null)) {
                this.spouse = person;
                person.spouse = this;
                marriage = true;
            } else if ((this.getSpouse() != person) && (person.getSpouse() != this)) {
                this.divorce();
                person.divorce();
                return this.marry(person);
            }
        }
        return marriage;
    }

    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        boolean status = false;
        if ((this.getSpouse() != null) && (this.getSpouse().getSpouse() != null)) {
            this.spouse.spouse = null;
            this.spouse = null;
            status = true;
        }
        return status;
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
