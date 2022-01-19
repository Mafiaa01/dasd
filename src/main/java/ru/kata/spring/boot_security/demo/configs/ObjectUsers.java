package ru.kata.spring.boot_security.demo.configs;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class ObjectUsers {
    private final UserService userService;
    private final RoleService roleService;

    public ObjectUsers(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @PostConstruct
    private void createUsers() {
        Set<Role> rolesadmin = new HashSet<>();
        Set<Role> rolesuser = new HashSet<>();
        roleService.getRoleByName("ROLE_ADMIN");
        roleService.getRoleByName("ROLE_USER");
        rolesadmin.add(roleService.getRoleById(1L));
        rolesuser.add(roleService.getRoleById(2L));

        User admin = new User(1L, "admin", "admin", "1234", Collections.emptySet());
        admin.setRoles(rolesadmin);
        userService.addUser(admin);

        User user = new User(2L, "user", "user", "1234", Collections.emptySet());
        user.setRoles(rolesuser);
        userService.addUser(user);
    }

}
