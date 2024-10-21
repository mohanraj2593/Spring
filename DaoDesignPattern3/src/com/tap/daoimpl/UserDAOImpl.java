package com.tap.daoimpl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.UserDAO;
import com.tap.model.User;

public class UserDAOImpl implements UserDAO {
	int x=-1;
	User user;
	static Connection con;
	static ArrayList<User> userList =new ArrayList<User>();
	static PreparedStatement pstmt;
	static Statement stmt;
	static ResultSet result;
	static String INSERT="insert into User(username,password,email,address,role) values(?,?,?,?,?)";
	static String GET_ALL_USER="select*from User";
	static String GET_USER_BY_ID="select * from User where user_id=?";
	static String DELETE_USER_BY_ID="delete from User where user_id=?";
	static String UPDATE_ADDRESS_BY_ID="update User set address=? where user_id=?";
static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/daodesign", "root", "mohanraj@123");
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

	@Override
	public int insertUser(User user) {
		
try {
	pstmt= con.prepareStatement(INSERT);
	pstmt.setString(1,user.getUsername());
	pstmt.setString(2,user.getPassword());
	pstmt.setString(3,user.getEmail());
	pstmt.setString(4,user.getAddress());
	pstmt.setString(5,user.getRole());
	x=pstmt.executeUpdate();
	
}
catch(Exception e){
	e.printStackTrace();
}
		
		
		return x;
	}

	@Override
	public  List<User> getAllUsers() {
		try {
			stmt=con.createStatement();
			result=stmt.executeQuery(GET_ALL_USER);
			userList=(ArrayList<User>)extractUserListFromResultSet( result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User getUserById(int id) {
	try {
		pstmt=con.prepareStatement(GET_USER_BY_ID);
		pstmt.setInt(1,id);
		result=pstmt.executeQuery();
		userList=(ArrayList<User>) extractUserListFromResultSet(result);
		user=userList.get(0);
			
	}
	catch(Exception e)

	{
		e.printStackTrace();
	}
	return user;
	}

	@Override
	public int deleteUserByI(int id) {
		try {
			pstmt=con.prepareStatement(DELETE_USER_BY_ID);
			pstmt.setInt(1, id);
			x=pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			
		}
		return x;
	}

	@Override
	public int updateUserById(int id, String address) {
		try {
			pstmt=con.prepareStatement(UPDATE_ADDRESS_BY_ID);
			pstmt.setString(1, address);
			pstmt.setInt(2, id);
			x=pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	 List<User> extractUserListFromResultSet(ResultSet result){
		try {
			while(result.next())
			{
				userList.add(new User(
						result.getInt(1),
				result.getString(2),
				result.getString(3),
				result.getString(4),
				result.getString(5),
				result.getString(6)));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

}
