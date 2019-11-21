package com.sp.admin.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.admin.entity.AdminRegistrationEntity;

public interface AdminRegistrationRepository extends JpaRepository<AdminRegistrationEntity, Integer>{
     
	public Optional<AdminRegistrationEntity> findByName(final String name);
}
