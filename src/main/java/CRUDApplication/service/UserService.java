package CRUDApplication.service;

import CRUDApplication.models.User;

import CRUDApplication.models.Role;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Long id);
    void saveUser(User user);
    void editUser(User user);
    void delete(Long id);
    User getUserByName(String login);
    void setRole(User user, String role);

}
