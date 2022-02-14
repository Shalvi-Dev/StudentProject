package com.services;

import java.sql.Connection;
import java.sql.SQLException;

public interface Deletable {
	int Delete(int del_int, Connection connection) throws SQLException;	
}
