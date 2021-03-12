/* 
 * this is service interface implements service class , generally haing b.logic
 *
 */

package com.nt.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IUserDataDao;
import com.nt.websocket.model.UserData;

@Service("userService")
public class UserDataServiceImpl implements IUserDataService {

	public UserDataServiceImpl() {
		System.out.println("UserDataServiceImpl.UserDataServiceImpl() :: ");
	}

	@Autowired
	private IUserDataDao dao;

	@Override
	public String register(UserData cust) throws Exception {

		try {

			System.out.println("In service class "+ cust.getUname()+"  "+cust.getUpass());
			//creating Model Class obj and passing data in dao class
			UserData data = new UserData();
			data.setUname(cust.getUname());
			data.setUpass(cust.getUpass());

			//using dao class obj ,passing succes or failing login msg to enduser 
			int count=dao.insert(data);
			return (count==0)?"Customer Login Failed":"Customer Login succeded";
		}
		catch(SQLException se)
		{	
			se.printStackTrace();
			return "Customer Login failed";
		}
		catch(Exception e){
			e.printStackTrace();
			return "Customer Login Failed ";
		}
	}//method
}//class
