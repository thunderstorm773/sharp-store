package sharpStore.services.api;

import sharpStore.models.bindingModels.AddUser;
import sharpStore.models.viewModels.ShowUser;

public interface UserService {

    boolean addUser(AddUser addUser);

    ShowUser findUserByUsernameAndPassword(String username, String password);
}
