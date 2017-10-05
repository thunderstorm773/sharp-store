package sharpStore.staticData;

import sharpStore.enums.Role;
import sharpStore.models.bindingModels.AddUser;

public class EmployeesData {

    public static AddUser employee1;

    public static AddUser employee2;

    public static AddUser employee3;

    static {
        employee1 = new AddUser("vasil", "123", Role.ADMIN);
        employee2 = new AddUser("machina", "1", Role.ADMIN);
        employee3 = new AddUser("thunder", "1", Role.ADMIN);
    }
}
