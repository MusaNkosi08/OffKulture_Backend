package ac.za.cput.repository.impl;

import ac.za.cput.domain.User;
import ac.za.cput.repository.IUserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {

    private static UserRepositoryImpl repository = null;
    private List<User> userList;

    private UserRepositoryImpl() {
        userList = new ArrayList<>();
    }

    public static UserRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new UserRepositoryImpl();
        }
        return repository;
    }

    @Override
    public User create(User user) {
        this.userList.add(user);
        return user;
    }

    @Override
    public User read(String id) {
        return this.userList.stream()
                .filter(user -> user.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User update(User user) {
        User toUpdate = read(user.getId());
        if (toUpdate != null) {
            this.userList.remove(toUpdate);
            this.userList.add(user);
            return user;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        User toDelete = read(id);
        if (toDelete != null) {
            this.userList.remove(toDelete);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        return this.userList;
    }

    @Override
    public User findByEmail(String email) {
        return this.userList.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }
}
