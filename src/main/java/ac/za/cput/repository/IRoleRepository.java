package ac.za.cput.repository;

import ac.za.cput.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, String> {
    // No custom methods needed for now
}
