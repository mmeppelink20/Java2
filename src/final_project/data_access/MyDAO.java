package final_project.data_access;

import final_project.MyException;

import java.time.LocalDate;
import java.util.List;

public interface MyDAO<T> {
    void readInData() throws MyException;
    void add(T obj) throws MyException;
    T get(int id) throws MyException;
    List<T> get(String str) throws MyException;
    List<T> get(LocalDate date) throws MyException;
    List<T> getAll() throws MyException;
    void set(int id, T obj) throws MyException;
    T remove(int id) throws MyException;
    T remove(T obj) throws MyException;
}
