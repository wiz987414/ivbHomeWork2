import ru.sbt.model.Gender;
import ru.sbt.model.Person;

import java.util.ArrayList;

public class Family {
    public static void main(String[] args) {
        ArrayList<Person> group = new ArrayList<>();
        group.add(new Person());
        group.add(new Person(Gender.FEEMALE, "Mary"));
        group.add(new Person(Gender.MALE, "Peter"));
        group.add(new Person(Gender.FEEMALE, "Chloe"));

        System.out.println("\nFirst year:");
        group.add(0, group.get(0).identification("Michael"));
        group = group.get(0).updateList(group);
        for(Person human : group)
            human.personBio();

        System.out.println("\nSecond year:");
        group.addAll(group.get(0).marry(group.get(1)));
        group = group.get(0).updateList(group);
        for(Person human : group)
            human.personBio();

        System.out.println("\nThird year:");
        group.addAll(group.get(0).marry(group.get(2)));
        group = group.get(0).updateList(group);
        for(Person human : group)
            human.personBio();

        System.out.println("\nFourth year:");
        group.addAll(group.get(1).divorce());
        group = group.get(0).updateList(group);
        for(Person human : group)
            human.personBio();
    }
}
