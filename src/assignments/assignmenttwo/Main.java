package assignments.assignmenttwo;

import java.util.*;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Map<Person, List<Animal>> owners_and_their_pets = new HashMap<>();

        Person marc = new Person("Marc");
        List<Animal> marcs_pets = new ArrayList<>();
        marcs_pets.add(new Cat("Zipper"));
        marcs_pets.add(new Cat("Waffles"));
        owners_and_their_pets.put(marc, marcs_pets);

        Person krystal = new Person("Krystal");
        List<Animal> krystal_pets = new ArrayList<>();
        krystal_pets.add(new Cat("Lulu"));
        krystal_pets.add(new Dog("Penny"));
        krystal_pets.add(new Cat("Gus"));
        owners_and_their_pets.put(krystal, krystal_pets);

        Person bob = new Person("Bob");
        List<Animal> bobs_pets = new ArrayList<>();
        owners_and_their_pets.put(bob, bobs_pets);

        Person amy = new Person("Amy");
        List<Animal> amys_pets = new ArrayList<>();
        amys_pets.add(new Cat("Velcro"));
        owners_and_their_pets.put(amy, amys_pets);

        Person matthew = new Person("Matthew");
        List<Animal> matthews_pets = new ArrayList<>();
        matthews_pets.add(new Cat("Umbra"));
        owners_and_their_pets.put(matthew, matthews_pets);

        // part 1 code
        owners_and_their_pets.forEach(
                (person, pets) -> {
                    if (pets.size() > 1) {
                        System.out.println(person.getFirstName() + "'s pets: " + owners_and_their_pets.get(person).toString()
                                .replace("[", "")
                                .replace("]", ""));
                    } else if (pets.size() == 1) {
                        System.out.println(person.getFirstName() + "'s pet: " + owners_and_their_pets.get(person).toString()
                                .replace("[", "")
                                .replace("]", ""));
                    } else {
                        System.out.println(person.getFirstName() + " has no pets.");
                    }
                }
        );

        System.out.println();

        processData(owners_and_their_pets);
        System.out.println();
        printReport();

    }

    static Map<String, Integer> counter = new HashMap<>();

    public static void processData(Map<Person, List<Animal>> map) {
        map.forEach(
                (person, pets) -> {
                    for (Animal pet : pets) {
                        if(counter.containsKey(pet.getClass().getSimpleName())) {
                            int count = counter.get(pet.getClass().getSimpleName());
                            counter.replace(pet.getClass().getSimpleName(), count + 1);
                        } else {
                            counter.put(pet.getClass().getSimpleName(), 1);
                        }
                    }
                }
        );
    }


    public static void printReport() {
        System.out.println("--- Animals Report ---");
        for (String key: counter.keySet()){
            System.out.println("Type: "+ key + "    Count: " + counter.get(key));
        }
    }
}