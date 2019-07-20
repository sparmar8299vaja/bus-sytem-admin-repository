package com.sp.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sp.admin.dtos.DroppingPointDto;

@Entity
@Table(name = "DROPPING_POINT")
public class DroppingPointEntity {

	@Id
	@Column(name = "dr_id")
	@GenericGenerator(name = "DR_GEN", strategy = "increment")
	@GeneratedValue(generator = "DR_GEN")
	private int id;
	@Column(name = "dr_name")
	private String name;

	public DroppingPointEntity() {
		super();
	}

	public DroppingPointEntity(final DroppingPointEntityBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static class DroppingPointEntityBuilder {
		private int id;
		private String name;

		public DroppingPointEntityBuilder setId(final int id) {
			this.id = id;
			return this;
		}

		public DroppingPointEntityBuilder setName(final String name) {
			this.name = name;
			return this;
		}

		public DroppingPointEntity build() {
			return new DroppingPointEntity(this);
		}
	}

	public DroppingPointEntity convertDtoToEntity(final DroppingPointDto dto) {
        return new DroppingPointEntity
               .DroppingPointEntityBuilder()
               .setName(dto.getName())
               .build();
	}

	public DroppingPointDto convertEntityToDto(final DroppingPointEntity entity) {
        return new DroppingPointDto
        		.DroppingPointDtoBuilder()
        		.setName(entity.getName())
        		.build();
	}
}
