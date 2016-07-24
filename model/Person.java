/**
 *
 * Created by Belyakov Ilya on 24.07.2016.
 *
 */
class Person {
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
