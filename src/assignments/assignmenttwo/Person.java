package assignments.assignmenttwo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDateTime;

public class Person {
    private String firstName;
    private String lastName;
    private int heightInInches;
    private double weightInPounds;
    private LocalDateTime dateOfBirth;
    private int id;
    public static final String DEFAULT_FIRST_NAME = "John";
    public static final String DEFAULT_LAST_NAME = "Doe";
    public static final int DEFAULT_HEIGHT = 0;
    public static final double DEFAULT_WEIGHT = 0;
    public static final LocalDateTime DEFAULT_DOB = LocalDateTime.now();
    public static final LocalDateTime MIDNIGHT_TONIGHT = LocalDateTime.of(
            LocalDate.now(ZoneId.of("America/Chicago")), LocalTime.MIDNIGHT).plusDays(1);
    public static final String FIRST_NAME_NO_NUMBER_ERR = "First name cannot contain numbers";
    public static final String FIRST_NAME_EMPTY_ERR = "First name is required.";

    public Person(String firstName) {
        setFirstName(firstName);
        lastName = DEFAULT_LAST_NAME;
        heightInInches = DEFAULT_HEIGHT;
        weightInPounds = DEFAULT_WEIGHT;
        dateOfBirth = DEFAULT_DOB;
    }

    public static final int DEFAULT_ID = 0;

    public Person() {
        this(DEFAULT_ID, DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_HEIGHT, DEFAULT_WEIGHT, DEFAULT_DOB);
    }

    public Person(String firstName, String lastName) {
        this(DEFAULT_ID, firstName, lastName, DEFAULT_HEIGHT, DEFAULT_WEIGHT, DEFAULT_DOB);
    }

    public Person(int id, String firstName, String lastName, int heightInInches, double weightInPounds, LocalDateTime dateOfBirth) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setHeightInInches(heightInInches);
        setWeightInPounds(weightInPounds);
        setDateOfBirth(dateOfBirth);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.equals("")) {
            throw new IllegalArgumentException("First name required");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.equals("")) {
            throw new IllegalArgumentException("Last name required");
        }
        this.lastName = lastName;
    }

    public int getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(int heightInInches) {
        if(heightInInches < 0) {
            throw new IllegalArgumentException("Height must be 0 or greater");
        }
        this.heightInInches = heightInInches;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0) {
            throw new IllegalArgumentException("id must be 0 or higher");
        }
        this.id = id;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
        if(weightInPounds < 0) {
            throw new IllegalArgumentException("Weight must be 0 or greater");
        }
        this.weightInPounds = weightInPounds;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

//    @Override
//    public int compareTo(Person o) {
//        int result = this.lastName.compareTo(o.lastName);
//        if(result == 0) {
//            result = this.firstName.compareTo(o.firstName);
//        }
//        return result;
//    }
}

