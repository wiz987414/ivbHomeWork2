import ru.sbt.model.Gender;
import ru.sbt.model.Person;

public class Family {
    public static void main(String[] args) {
        Person husband = new Person();
        Person wife = new Person(Gender.FEEMALE, "Mary");
        Person husband2 = new Person(Gender.MALE, "Peter");
        Person wife2 = new Person(Gender.FEEMALE, "Chloe");
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
        wife.divorce();

        System.out.println("\nFour year:");
        husband.personBio();
        wife.personBio();
        husband2.personBio();
        wife2.personBio();
    }
}
