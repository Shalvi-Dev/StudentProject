package com.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Readtable {
	ResultSet Select(Connection connection) throws SQLException;
	ResultSet Select_By_Id(int read_id, Connection connection) throws SQLException;
}
