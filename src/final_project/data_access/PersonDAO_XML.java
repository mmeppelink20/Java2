package final_project.data_access;

import assignments.assignmenttwo.Person;
import final_project.MyException;

import java.time.LocalDate;
import java.util.*;

public class PersonDAO_XML implements MyDAO<Person> {
    private static final String FILE_NAME = "person.xml";
    private List<Person> list;

    @Override
    public void readInData() throws MyException {

    }

    @Override
    public void add(Person obj) throws MyException {

    }

    @Override
    public Person get(int id) throws MyException {
        return null;
    }

    @Override
    public List<Person> get(String str) throws MyException {
        return null;
    }

    @Override
    public List<Person> get(LocalDate date) throws MyException {
        return null;
    }

    @Override
    public List<Person> getAll() throws MyException {
        return null;
    }

    @Override
    public void set(int id, Person obj) throws MyException {

    }

    @Override
    public Person remove(int id) throws MyException {
        return null;
    }

    @Override
    public Person remove(Person obj) throws MyException {
        return null;
    }
}
