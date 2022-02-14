package com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.services.Deletable;
import com.services.Insertable;
import com.services.Updatable;
import com.services.Readtable;

public class Test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		try {
			Connection connection =JDBCConnection.getOracleConnection();	//Connection object
			Insertable insertable = new StudentUtility() ;					//Interface object
			Updatable updatable = new StudentUtility();
			Deletable deletable = new StudentUtility();
			Readtable readtable = new StudentUtility();
			
			Scanner scanner = new Scanner(System.in);					//Scanner class object
			System.out.println("1.Insert student data into Student table");
			System.out.println("2.Update student data into Student table");
			System.out.println("3.Delete student data into Student table");
			System.out.println("4.Get a list of all sudents");
			System.out.println("5.Get one student information depending on the stuednt id filter");
			System.out.println("Enter your choice");					
			
			int i = scanner.nextInt();									//Taking input from user
			
			switch (i) {
			case 1:														//To insert data into table
				System.out.println("Enter Student Id ");					
				int id = scanner.nextInt();
				System.out.println("Enter Student Name ");
				String name = scanner.next();
				System.out.println("Enter Student Date of Birth in yyyy-mm-dd fomat");
				String dob = scanner.next();
				java.util.Date dateofB = new SimpleDateFormat("dd-MM-yyyy").parse(dob);
				java.sql.Date dofb = new java.sql.Date(dateofB.getTime());
				System.out.println("Enter Student Date of join in dd-mm-yyyy fomat");
				String doj = scanner.next();
				java.util.Date dateofJ = new SimpleDateFormat("dd-MM-yyyy").parse(doj);
				java.sql.Date dofj = new java.sql.Date(dateofJ.getTime());
				
				int j = insertable.Insert(id,name,dofb,dofj,connection);			//calling Insert() method
				
				if(j==1) {
					System.out.println("Student data inserted successfully!");
				}else {
					System.out.println("Fail!");
				}
				break;
			case 2:																	//To update data in table
				System.out.println("Enter student id ");
				int upd_id = scanner.nextInt();
				System.out.println("1.Update Name");
				System.out.println("2.Update date of birth");
				System.out.println("3.Update date of join");
				boolean y = false;
				do {
					System.out.println("Enter your choice:");
					int k = scanner.nextInt();
					if(k==1) {
						System.out.println("Enter student updated name");
						String upd_name = scanner.next();
						updatable.Update(upd_id,upd_name,connection);
					}else if (k==2) {
						System.out.println("Enter Student updated Date of Birth in yyyy-mm-dd fomat");
						String upd_dob = scanner.next();
						java.util.Date upd_dateofB = new SimpleDateFormat("dd-MM-yyyy").parse(upd_dob);
						java.sql.Date upd_dofb = new java.sql.Date(upd_dateofB.getTime());
						updatable.Update(upd_id,upd_dofb, connection);
					}else if (k==3) {
						System.out.println("Enter Student updated Date of join in yyyy-mm-dd fomat");
						String upd_doj = scanner.next();
						java.util.Date upd_dateofJ = new SimpleDateFormat("dd-MM-yyyy").parse(upd_doj);
						java.sql.Date upd_dofj = new java.sql.Date(upd_dateofJ.getTime());
						updatable.Update(upd_id,connection, upd_dofj);
					}
					System.out.println("Student data updated successfully!");
					System.out.println("Do you want to update another field y/n");
					String choice = scanner.next();
					if(choice.equalsIgnoreCase("n")) {
						y = false;
						break;
					}else if (choice.equalsIgnoreCase("y")) {
						y = true;
					}else {
						System.out.println("Enter proper choice");
					}
				}while(y);
				break;
			case 3:																//To delete data from table
				System.out.println("Enter student id");
				int del_int = scanner.nextInt();
				if(deletable.Delete(del_int,connection)==1) {
					System.out.println("Student data deleted successfully!");
				}else {
					System.out.println("fail");
				}
				break;
			case 4:																//To read data from table
				ResultSet resultSet = readtable.Select(connection);
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+"	"+resultSet.getDate(3)+" "+resultSet.getDate(4));
				}
				break;
			case 5:																//To read data from table of particular student
				System.out.println("Enter student id");
				int read_id = scanner.nextInt();
				ResultSet resultSet2 = readtable.Select_By_Id(read_id, connection);
				while(resultSet2.next()) {
					System.out.println(resultSet2.getInt(1)+" "+resultSet2.getString(2)+" "+resultSet2.getDate(3)+" "+resultSet2.getDate(4));
				}
				break;
			default:
				System.out.println("Please enter correct choice");
				break;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
