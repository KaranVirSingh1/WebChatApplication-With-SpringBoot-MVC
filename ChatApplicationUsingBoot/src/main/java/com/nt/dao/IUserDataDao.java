/* 
 * developing dao interface for loose coupling it can implemets 
 * other classes as per db change and proving potability in dbs
 *
 */

package com.nt.dao;

import com.nt.websocket.model.UserData;

public interface IUserDataDao {
	public int insert(UserData user) throws Exception;
}
