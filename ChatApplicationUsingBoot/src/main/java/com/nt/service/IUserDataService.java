/* 
 * this is service interface implements providing loos coupling in service classes
 *
 */

package com.nt.service;

import com.nt.websocket.model.UserData;

public interface IUserDataService {
	
	  public  String  register(UserData cust)throws Exception;	
}
