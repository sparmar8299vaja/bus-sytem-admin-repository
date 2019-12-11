package com.sp.admin.service.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

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
import com.sp.admin.dtos.SeatDto;
import com.sp.admin.entity.BoardingPointEntity;
import com.sp.admin.entity.BusRegistrationEntity;
import com.sp.admin.entity.BusRegistrationEntityId;
import com.sp.admin.entity.DroppingPointEntity;
import com.sp.admin.entity.SeatEntity;
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
	private static final String RESPONSE_MSG = "Bus Added Successfully Having No "+BUS_NO;
	private static final Boolean BUSALREADY_EXIST = true;
	private static final String DATE_OF_LEAVE = "10-10-2019";
	private static final String SEAT_TYPE = "LOWER";
	private static final boolean AVAILABILITY = true;
	private static final int SEAT_NO = 1; 
	
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
		when(busRegistrationRepository.existsByBusIdBusNoAndBusIdDateOfLeave(Mockito.anyString(), Mockito.anyString())).thenReturn(BUSALREADY_EXIST);
		busRegistrationService.addBusInfo(getBusRegDto());
		verify(busRegistrationRepository,times(0)).save(getBusRegEntity());
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
				.setBusId(getBusRegDtoId())
				.setBoardingPointEntity(new HashSet<BoardingPointEntity>(Arrays.asList(getBoardingPointEntity())))
				.setDroppingPointEntity(new HashSet<DroppingPointEntity>(Arrays.asList(getDroppingPointEntity())))
				.setSeatEntity(new HashSet<SeatEntity>(Arrays.asList(getSeatEntity())))
				.build();
	}
	
	private BusRegistrationEntityId getBusRegDtoId() {
		return new BusRegistrationEntityId.BusRegistrationEntityIdBuilder()
				.setBusNo(BUS_NO)
				.setDateOfLeave(DATE_OF_LEAVE)
				.build();
	}
	
	private BusRegistrationDto getBusRegDto() {
		return new BusRegistrationDto.BusRegistrationDtoBuilder()
				 .setBusNo(BUS_NO)
				 .setDateOfLeave(DATE_OF_LEAVE)
				 .setDriverMobileNo(DRIVER_MO_NO)
				 .setBrandMobileNo(BRAND_MO_NO)
				 .setBoardingPointDtos(new HashSet<BoardingPointDto>(Arrays.asList(getBoardingPointDto())))
				 .setDroppingPointDtos(new HashSet<DroppingPointDto>(Arrays.asList(getDroppingPointDto())))
				 .setSeatDto(new HashSet<SeatDto>(Arrays.asList(getSeatDto())))
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
	
	private SeatEntity getSeatEntity() {
		return new SeatEntity
				.SeatEntityBuilder()
				.setSeatType(SEAT_TYPE)
				.setSeatNo(SEAT_NO)
				.setAvailable(AVAILABILITY)
				.build();
	}
	
	private SeatDto getSeatDto() {
		return new SeatDto
				.SeatDtoBuilder()
				.setSeatType(SEAT_TYPE)
				.setSeatNo(SEAT_NO)
				.setAvailable(AVAILABILITY)
				.build();
	}
	
}
