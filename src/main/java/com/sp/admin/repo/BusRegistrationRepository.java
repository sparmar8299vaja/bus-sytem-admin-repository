package com.sp.admin.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.admin.entity.BusRegistrationEntity;

public interface BusRegistrationRepository extends JpaRepository<BusRegistrationEntity, Object>{
     
	public List<BusRegistrationEntity> findByFromLocationAndToLocationAndBusIdDateOfLeave(final String fromLocation, final String toLocation, final String dateOfLeave);
	public boolean existsByBusIdBusNoAndBusIdDateOfLeave(final String busNo, final String dateOfLeave);
	public Optional<BusRegistrationEntity> findByBusIdBusNo(final String busNo);
}
