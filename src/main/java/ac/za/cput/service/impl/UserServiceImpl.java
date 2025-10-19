package ac.za.cput.service.impl;

import ac.za.cput.domain.User;
import ac.za.cput.repository.IUserRepository;
import ac.za.cput.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(IUserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        User userToSave = new User.Builder()
                .copy(user)
                .setPassword(hashedPassword)
                .build();
        return this.repository.save(userToSave);
    }

    @Override
    public User read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {
        User existingUser = this.repository.findById(user.getId()).orElse(null);
        if (existingUser == null) {
            return null; // Or throw an exception
        }

        User.Builder userBuilder = new User.Builder().copy(user);

        // If a new password is provided, hash it. Otherwise, keep the old one.
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            String hashedPassword = passwordEncoder.encode(user.getPassword());
            userBuilder.setPassword(hashedPassword);
        } else {
            userBuilder.setPassword(existingUser.getPassword());
        }

        User userToUpdate = userBuilder.build();
        return this.repository.save(userToUpdate);
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
