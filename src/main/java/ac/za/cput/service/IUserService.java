package ac.za.cput.service;

import ac.za.cput.domain.User;

public interface IUserService extends IService<User, String> {
    User findByEmail(String email);
}
