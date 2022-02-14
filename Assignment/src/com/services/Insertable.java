package com.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public interface Insertable {

	int Insert(int id, String name, Date dofb, Date dofj, Connection connection) throws SQLException;

}
