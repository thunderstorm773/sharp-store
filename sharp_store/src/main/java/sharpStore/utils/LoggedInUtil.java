package sharpStore.utils;

import sharpStore.enums.Role;
import sharpStore.models.viewModels.ShowUser;
import javax.servlet.http.HttpSession;

public class LoggedInUtil {

    public static boolean isUserLoggedIn(HttpSession httpSession) {
        return httpSession.getAttribute("loginModel") != null;
    }

    public static boolean isUserAdmin(HttpSession httpSession) {
        if (isUserLoggedIn(httpSession)) {
            ShowUser loginModel = (ShowUser) httpSession.getAttribute("loginModel");
            if (loginModel.getRole() == Role.ADMIN) {
                return true;
            }
        }

        return false;
    }
}
