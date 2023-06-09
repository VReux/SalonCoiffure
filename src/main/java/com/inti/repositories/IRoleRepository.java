package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

}
