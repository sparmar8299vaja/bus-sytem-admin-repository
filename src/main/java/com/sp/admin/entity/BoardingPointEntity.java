package com.sp.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sp.admin.dtos.BoardingPointDto;

@Entity
@Table(name = "BOARDING_POINT")
public class BoardingPointEntity {

	@Id
	@Column(name = "bo_id")
	@GenericGenerator(name = "BO_GEN", strategy = "increment")
	@GeneratedValue(generator = "BO_GEN")
	private int id;
	@Column(name = "bo_name")
	private String name;

	public BoardingPointEntity() {
		super();
	}

	public BoardingPointEntity(final BoardingPointEntityBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static class BoardingPointEntityBuilder {
		private int id;
		private String name;

		public BoardingPointEntityBuilder setId(final int id) {
			this.id = id;
			return this;
		}

		public BoardingPointEntityBuilder setName(final String name) {
			this.name = name;
			return this;
		}

		public BoardingPointEntity build() {
			return new BoardingPointEntity(this);
		}
	}

	public BoardingPointEntity converDtoToEntity(final BoardingPointDto dto) {
       return new BoardingPointEntity
              .BoardingPointEntityBuilder()
              .setName(dto.getName())
              .build();
	}

	public BoardingPointDto converEntityToDto(final BoardingPointEntity entity) {
        return new BoardingPointDto
        		.BoardingPointDtoBuilder()
        		.setName(entity.getName())
        		.build();
	}
}
