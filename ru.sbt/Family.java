import ru.sbt.model.Gender;
import ru.sbt.model.Person;

public class Family {
    public static void main(String[] args) {
        Person husband = new Person();
        Person wife = new Person(Gender.FEEMALE, "Mary");
        Person husband2 = new Person(Gender.MALE, "Peter", new Person(Gender.FEEMALE, "Chloe"));
        Person wife2 = husband2.getSpouse();
        husband = husband.identification("Michael");

        System.out.println("\nFirst year:");
        husband.personBio();
        wife.personBio();
        husband2.personBio();
        wife2.personBio();
        husband.marry(wife);

        System.out.println("\nSecond year:");
        husband.personBio();
        wife.personBio();
        husband2.personBio();
        wife2.personBio();
        husband2.marry(wife);

        System.out.println("\nThird year:");
        husband.personBio();
        wife.personBio();
        husband2.personBio();
        wife2.personBio();
    }
}
