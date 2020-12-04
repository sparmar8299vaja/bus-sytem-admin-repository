package com.sp.admin.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.admin.entity.CustomerRegistrationEntity;

public interface CustomerRegistrationRepository extends JpaRepository<CustomerRegistrationEntity, Integer>{
    
	public Optional<CustomerRegistrationEntity> findByName(final String name);

}
