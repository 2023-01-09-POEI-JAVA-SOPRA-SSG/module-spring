package com.example.tpsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.tpsecurity.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	@Query("SELECT r FROM Role r JOIN r.users u WHERE u.email = ?1 AND r.type = ?2")
	Optional<Role> findRoleByEmailAndType(String email, String type);
}
