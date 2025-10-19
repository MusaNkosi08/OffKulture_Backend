package ac.za.cput.service.impl;

import ac.za.cput.domain.Role;
import ac.za.cput.repository.IRoleRepository;
import ac.za.cput.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    private final IRoleRepository repository;

    @Autowired
    public RoleServiceImpl(IRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role create(Role role) {
        return this.repository.save(role);
    }

    @Override
    public Role read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Role update(Role role) {
        return this.repository.save(role);
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
    public List<Role> getAll() {
        return this.repository.findAll();
    }
}
