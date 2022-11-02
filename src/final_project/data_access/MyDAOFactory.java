package final_project.data_access;

import assignments.assignmenttwo.Person;
import final_project.data_access.MyDAO;

public class MyDAOFactory {

    public static MyDAO getMyDAO(String dao_source) {
        MyDAO<Person> dao = null;
        switch(dao_source.toUpperCase()) {
            case "CSV":
                dao = new PersonDAO_CSV();
                break;
            case "XML":
                dao = new PersonDAO_XML();
                break;
            case "MYSQL":
                dao = new PersonDAO_MySQL();
                break;
        }
        return dao;
    }
}
