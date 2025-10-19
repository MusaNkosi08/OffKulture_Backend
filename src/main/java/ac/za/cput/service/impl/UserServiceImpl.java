package ac.za.cput.service.impl;

import ac.za.cput.domain.User;
import ac.za.cput.repository.IUserRepository;
import ac.za.cput.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository repository;

    @Autowired
    public UserServiceImpl(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return this.repository.save(user);
    }

    @Override
    public User read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {
        return this.repository.save(user);
    }

    @Override
    public boolean delete(String id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        return this.repository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return this.repository.findByEmail(email);
    }
}
