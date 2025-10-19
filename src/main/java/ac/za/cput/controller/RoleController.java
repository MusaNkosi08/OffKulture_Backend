package ac.za.cput.controller;

import ac.za.cput.domain.Role;
import ac.za.cput.factory.RoleFactory;
import ac.za.cput.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final IRoleService roleService;

    @Autowired
    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/create")
    public Role create(@RequestBody Role role) {
        Role newRole = RoleFactory.createRole(role.getName());
        return roleService.create(newRole);
    }

    @GetMapping("/read/{id}")
    public Role read(@PathVariable String id) {
        return roleService.read(id);
    }

    @PutMapping("/update")
    public Role update(@RequestBody Role role) {
        return roleService.update(role);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return roleService.delete(id);
    }

    @GetMapping("/getall")
    public List<Role> getAll() {
        return roleService.getAll();
    }
}
