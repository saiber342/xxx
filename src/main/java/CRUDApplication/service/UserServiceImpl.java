package CRUDApplication.service;

import CRUDApplication.dao.RoleDAO;
import CRUDApplication.dao.UserDAO;
import CRUDApplication.dao.UserDAOImpl;
import CRUDApplication.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import CRUDApplication.models.Role;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    private final UserDAO userDAO;
    private final RoleDAO roleDAO;



    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);

    }

    @Override
    @Transactional
    public void editUser(User user) {
        userDAO.editUser(user);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        User user = userDAO.getUserById(id);
        userDAO.delete(user);

    }

    @Override
    public void setRole(User user, String userRole) {
        Set<Role> roles = new HashSet<>();
        if (userRole.toUpperCase().contains("ADMIN")) {
            roles.add(roleDAO.showById(2L));
        }
        if (userRole.toUpperCase().contains("USER")) {
            roles.add(roleDAO.showById(1L));
        }
        user.setRoles(roles);
    }

    @Override
    @Transactional
    public User getUserByName(String name) {
        return userDAO.getUserByName(name);
    }

}
