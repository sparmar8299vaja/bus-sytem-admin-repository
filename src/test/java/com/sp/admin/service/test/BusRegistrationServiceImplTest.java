package com.sp.admin.service.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.sp.admin.dtos.BoardingPointDto;
import com.sp.admin.dtos.BusRegistrationDto;
import com.sp.admin.dtos.DroppingPointDto;
import com.sp.admin.entity.BoardingPointEntity;
import com.sp.admin.entity.BusRegistrationEntity;
import com.sp.admin.entity.DroppingPointEntity;
import com.sp.admin.exceptions.ConstraintsVoilationException;
import com.sp.admin.exceptions.DataNotFoundException;
import com.sp.admin.repo.BusRegistrationRepository;
import com.sp.admin.service.BusRegistrationService;
import com.sp.admin.service.BusRegistrationServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class) 
public class BusRegistrationServiceImplTest {
	
	private static final String BUS_NO = "mp098765";
	private static final String DRIVER_MO_NO = "8839511184";
	private static final String BRAND_MO_NO = "8839511184";
	private static final String BOARDING_POINT_NAME = "VIJAYNAGER";
	private static final String DROPPING_POINT_DTO  = "TEEN HATH NAKA";
	private static final String RESPONSE_MSG = "Bus Added Successfully have no "+BUS_NO;
	private static final Boolean BUSALREADY_EXIST = true;
	@InjectMocks
	private BusRegistrationService busRegistrationService = new BusRegistrationServiceImpl();
	
	@Mock
	private BusRegistrationRepository busRegistrationRepository;
	
	@Test
	public void addBusInfoTest() {
		when(busRegistrationRepository.save(any(BusRegistrationEntity.class))).thenReturn(getBusRegEntity());
		assertEquals(RESPONSE_MSG, busRegistrationService.addBusInfo(getBusRegDto()));
	} 
	
	@Test(expected = ConstraintsVoilationException.class)
	public void addBusInfoThrowExceptionWhenBusNoAlreadyExistTest() {
		when(busRegistrationRepository.existsById(Mockito.anyString())).thenReturn(BUSALREADY_EXIST);
		busRegistrationService.addBusInfo(getBusRegDto());
		verify(busRegistrationRepository,times(0)).save(getBusRegEntity());
	} 
	
	@Test
	public void getBusByIdTest() {
		when(busRegistrationRepository.findById(Mockito.anyString())).thenReturn(Optional.of(getBusRegEntity()));
		busRegistrationService.getBusById(BUS_NO);
		verify(busRegistrationRepository,times(1)).findById(BUS_NO);
	}
	
	@Test(expected = DataNotFoundException.class)
	public void getBusByIdThrowExceptionWhenBusNotExistTest() {
		when(busRegistrationRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());
		busRegistrationService.getBusById(BUS_NO);
		verify(busRegistrationRepository,times(1)).findById(BUS_NO);
	}
	
	@Test
	public void getAllBusInfoTest() {
		when(busRegistrationRepository.findAll()).thenReturn(Arrays.asList(getBusRegEntity()));
		busRegistrationService.getAllBusInfo();
		verify(busRegistrationRepository,times(1)).findAll();
	}
	
	@Test(expected = DataNotFoundException.class)
	public void getAllBusInfoThrowExceptionWhenDataNotFoundTest() {
		when(busRegistrationRepository.findAll()).thenReturn(Collections.emptyList());
		busRegistrationService.getAllBusInfo();
		verify(busRegistrationRepository,times(1)).findAll();
	}
	
	private BusRegistrationEntity getBusRegEntity() {
		return new BusRegistrationEntity.BusRegistrationEntityBuilder()
				.setBusNo(BUS_NO)
				.setBoardingPointEntity(new HashSet<BoardingPointEntity>(Arrays.asList(getBoardingPointEntity())))
				.setDroppingPointEntity(new HashSet<DroppingPointEntity>(Arrays.asList(getDroppingPointEntity())))
				.build();
	}
	
	private BusRegistrationDto getBusRegDto() {
		return new BusRegistrationDto.BusRegistrationDtoBuilder()
				 .setBusNo(BUS_NO)
				 .setDriverMobileNo(DRIVER_MO_NO)
				 .setBrandMobileNo(BRAND_MO_NO)
				 .setBoardingPointDtos(new HashSet<BoardingPointDto>(Arrays.asList(getBoardingPointDto())))
				 .setDroppingPointDtos(new HashSet<DroppingPointDto>(Arrays.asList(getDroppingPointDto())))
				 .build();
	}
	
	private BoardingPointDto getBoardingPointDto() {
		return new BoardingPointDto.BoardingPointDtoBuilder()
				.setName(BOARDING_POINT_NAME)
				.build();
	}
	
	private DroppingPointDto getDroppingPointDto() {
		return new DroppingPointDto.DroppingPointDtoBuilder()
				.setName(DROPPING_POINT_DTO)
				.build();
	}
	
	private BoardingPointEntity getBoardingPointEntity() {
		return new BoardingPointEntity.BoardingPointEntityBuilder()
				.setName(BOARDING_POINT_NAME)
				.build();
	}
	
	private DroppingPointEntity getDroppingPointEntity() {
		return new DroppingPointEntity.DroppingPointEntityBuilder()
				.setName(DROPPING_POINT_DTO)
				.build();
	}
	
}
