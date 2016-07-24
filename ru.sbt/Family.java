import ru.sbt.model.Gender;
import ru.sbt.model.Person;

public class Family {
    public static void main(String[] args) {
        Person husband = new Person();
        Person wife = new Person(Gender.FEEMALE, "Mary");
        husband = husband.identification("Michael");
        husband.personBio();
        wife.personBio();
    }
}
