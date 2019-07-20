package com.sp.admin.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.sp.admin.exceptions.IdentityNotGeneratedException;
import com.sp.admin.sql_query.SQLQuery;

public class AdminIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(final SharedSessionContractImplementor session, final Object object){
		Connection connection = null;
		int startId = 567890;
		connection = session.connection();
		try(PreparedStatement prepareStatement = connection.prepareStatement(SQLQuery.ADMIN_REG_ID); ResultSet rs = prepareStatement.executeQuery()) {
			rs.next();
			int id = rs.getInt(1);
			if (id == 0) {
				return startId;
			}
			startId = rs.getInt(1);
		} catch (SQLException e) {
            throw new IdentityNotGeneratedException("Problem While Generating Id Value",e);
		} 
		return ++startId;
	}

}
