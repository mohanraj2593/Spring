package com.tap.main;
import java.util.ArrayList;

import com.tap.dao.UserDAO;
import com.tap.daoimpl.UserDAOImpl;
import com.tap.model.User;

public class Main {

	public static void main(String[] args) {
//		User u =new User("akil","123","akil@gmail.com","btm,bangalore","customer");
		UserDAO dao = new UserDAOImpl();
		int status=dao.updateUserById(1, "Thiruvnmiyur,Chennai");
		System.out.println(status);
		
//		int status=dao.deleteUserByI(2);
//		System.out.println(status);
//		User user=dao.getUserById(1);
//		System.out.println(user);
//		int status=dao.insertUser(u);
//		System.out.println(status);
//		ArrayList<User> users=(ArrayList<User>) dao.getAllUsers();
//for(User a:users) {
//	System.out.println(a);
//}
	}

}
