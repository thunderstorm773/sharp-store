package sharpStore.services.impl;

import sharpStore.entities.User;
import sharpStore.models.bindingModels.AddUser;
import sharpStore.models.viewModels.ShowUser;
import sharpStore.repositories.impl.UserRepositoryImpl;
import sharpStore.services.api.UserService;
import sharpStore.staticData.EmployeesData;
import sharpStore.utils.MapperUtil;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(UserService.class)
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        this.addUser(EmployeesData.employee1);
        this.addUser(EmployeesData.employee2);
        this.addUser(EmployeesData.employee3);
    }

    @Override
    public boolean addUser(AddUser addUser) {
        boolean isUserAdded = false;
        if (addUser != null) {
            User user = MapperUtil.getInstance().getModelMapper()
                    .map(addUser, User.class);
            isUserAdded = UserRepositoryImpl.getInstance().addUser(user);
        }

        return isUserAdded;
    }

    @Override
    public ShowUser findUserByUsernameAndPassword(String username, String password) {
        ShowUser showUser = null;
        if (username != null && password != null) {
            User user = UserRepositoryImpl.getInstance()
                    .findUserByUsernameAndPassword(username, password);

            if (user != null) {
                showUser = MapperUtil.getInstance().getModelMapper()
                        .map(user, ShowUser.class);
            }
        }

        return showUser;
    }
}
