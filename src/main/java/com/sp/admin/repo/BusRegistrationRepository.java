package com.sp.admin.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.admin.entity.BusRegistrationEntity;

public interface BusRegistrationRepository extends JpaRepository<BusRegistrationEntity, String>{
     
	public List<BusRegistrationEntity> findByFromLocationAndToLocationAndDateOfLeave(final String fromLocation, final String toLocation, final String dateOfLeave);
	public List<BusRegistrationEntity> findByFromLocationAndToLocationAndDateOfLeaveAndLeaveTimeGreaterThan(final String fromLocation, final String toLocation, final String dateOfLeave, final String leaveTime);
}
