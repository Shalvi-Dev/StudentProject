package com.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;

public interface Updatable {
	void Update(int upd_id, String upd_name, Connection connection) throws SQLException;
	void Update(int upd_id, Connection connection,Date upd_dofJ) throws SQLException;
	void Update(int upd_id, Date upd_dofB, Connection connection) throws SQLException;
}
