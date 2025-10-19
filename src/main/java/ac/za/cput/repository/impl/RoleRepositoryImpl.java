package ac.za.cput.repository.impl;

import ac.za.cput.domain.Role;
import ac.za.cput.repository.IRoleRepository;

import java.util.ArrayList;
import java.util.List;

public class RoleRepositoryImpl implements IRoleRepository {

    private static RoleRepositoryImpl repository = null;
    private List<Role> roleList;

    private RoleRepositoryImpl() {
        roleList = new ArrayList<>();
    }

    public static RoleRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new RoleRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Role create(Role role) {
        this.roleList.add(role);
        return role;
    }

    @Override
    public Role read(String id) {
        return this.roleList.stream()
                .filter(role -> role.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Role update(Role role) {
        Role toUpdate = read(role.getId());
        if (toUpdate != null) {
            this.roleList.remove(toUpdate);
            this.roleList.add(role);
            return role;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Role toDelete = read(id);
        if (toDelete != null) {
            this.roleList.remove(toDelete);
            return true;
        }
        return false;
    }

    @Override
    public List<Role> getAll() {
        return this.roleList;
    }
}
