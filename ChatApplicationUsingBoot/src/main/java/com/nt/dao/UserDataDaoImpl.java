/* 
 * this class is dao interface implement class , having code related to db connection 
 *
 */

package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.nt.websocket.model.UserData;

@Repository("userDao")
public class UserDataDaoImpl implements IUserDataDao {
	
	// taking a static final Query on the top of class 
	private static final String QUERY ="INSERT INTO CUSTOMER_CHAT_LOGIN(USERNAME,PASSWORD) VALUES(?,?)";

	public UserDataDaoImpl() {
		System.out.println("UserDataDaoImpl.UserDataDaoImpl() :: ");
	}

	@Override
	public int insert(UserData user) throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		int count = 0 ;

		//logic mysql db connection through jdbc and table name 'CUSTOMER_CHAT_LOGIN'
		try {

			System.out.println("In DAO  class "+ user.getUname()+"  "+user.getUpass());

			//register jdbc driver s/w
			Class.forName("com.mysql.cj.jdbc.Driver");

			//establish the connection
			con=DriverManager.getConnection("jdbc:mysql:///ntaj414db1","root","12345");

			// creating prepare statement and pass SQL query
			if(con!=null)
				ps=con.prepareStatement(QUERY);

			//set values to query params(?) by model class obj
			if(ps!=null) {
				ps.setString(1,user.getUname());
				ps.setString(2, user.getUpass());
			}

			//send and execute SQL query in Db s/w
			if(ps!=null)
				count=ps.executeUpdate();

			//process the data
			if(count==0)
				System.out.println("Record not inserted");
			else
				System.out.println("Record inserted ::"+ count);
		}//try
		catch(SQLException se) {
			//if given errors occures then displaying given msg
			if(se.getErrorCode()==12899)
				System.out.println("u can not insert values more than column size");
			else if(se.getErrorCode()>=900 && se.getErrorCode()<=999) 
				System.out.println(" SQL Query Syntax problem");
			else
				System.out.println("unknow jdbc problem");

			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc objs in finally block bcz finally execute always
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}// end of finally
		return count;	
	}//end of method
}//end of class
