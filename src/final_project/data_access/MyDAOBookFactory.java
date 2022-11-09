package final_project.data_access;

import final_project.Book;
import final_project.data_access.MyDAO;

public class MyDAOBookFactory {

    public static MyDAO getMyDAO(String dao_source) {
        MyDAO<Book> dao = null;
        switch(dao_source.toUpperCase()) {
            case "CSV":
                dao = new BookDAO_CSV();
                break;
        }
        return dao;
    }
}
