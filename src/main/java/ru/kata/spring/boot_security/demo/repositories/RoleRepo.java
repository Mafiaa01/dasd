package ru.kata.spring.boot_security.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    Role getRoleByName(String name);

    Role getRoleById(Long id);

    @Query("SELECT r FROM Role r")
    List<Role> allRoles();
}
