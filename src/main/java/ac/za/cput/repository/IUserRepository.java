package ac.za.cput.repository;

import ac.za.cput.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
