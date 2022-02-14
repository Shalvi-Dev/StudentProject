package com.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.services.Deletable;
import com.services.Insertable;
import com.services.Readtable;
import com.services.Updatable;

public class StudentUtility implements Insertable,Updatable,Deletable,Readtable {//concrete class implements interfaces

	@Override
	public ResultSet Select(Connection connection) throws SQLException {//read data of all students
		// TODO Auto-generated method stub
		String querry = "select * from student";
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		return statement.executeQuery(querry);
	}

	@Override
	public int Insert(int id, String name, Date dofb, Date dofj, Connection connection) throws SQLException {//insert student data into table
		// TODO Auto-generated method stub
		String querry = "insert into student(student_no,student_name,student_dob,student_doj) values(?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(querry);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setDate(3,dofb);
		preparedStatement.setDate(4, dofj);
		return preparedStatement.executeUpdate();
	}

	@Override
	public void Update(int upd_id, String upd_name, Connection connection) throws SQLException {//update student name in table
		// TODO Auto-generated method stub
		String querry = "update student set student_name = ? where student_no = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(querry);
		preparedStatement.setInt(1, upd_id);
		preparedStatement.setString(2, upd_name);
		preparedStatement.execute();
	}

	@Override
	public void Update(int upd_id, Connection connection, Date upd_dofJ) throws SQLException {//update student doj in table
		// TODO Auto-generated method stub
		String querry = "update student set student_doj = ? where student_no = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(querry);
		preparedStatement.setDate(1, upd_dofJ);
		preparedStatement.setInt(2, upd_id);
		preparedStatement.execute();
	}

	@Override
	public void Update(int upd_id, Date upd_dofB, Connection connection) throws SQLException {//update dob data in table
		// TODO Auto-generated method stub
		String querry = "update student set student_dob = ? where student_no = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(querry);
		preparedStatement.setDate(1, upd_dofB);
		preparedStatement.setInt(2, upd_id);
		preparedStatement.execute();
	}

	@Override
	public ResultSet Select_By_Id(int read_id, Connection connection) throws SQLException {//read data of particular student
		// TODO Auto-generated method stub
		String querry = "select * from student where student_no = ?";
		CallableStatement cstmt = connection.prepareCall(querry);
		cstmt.setInt(1, read_id);
		return cstmt.executeQuery();
	}

	@Override
	public int Delete(int del_int, Connection connection) throws SQLException {//delete data of particular student
		// TODO Auto-generated method stub
		String querry = "delete from student where student_no = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(querry);
		preparedStatement.setInt(1,del_int);
		return preparedStatement.executeUpdate();
	}

}
