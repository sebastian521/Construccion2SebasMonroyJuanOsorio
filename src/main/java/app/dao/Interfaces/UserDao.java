package app.dao.Interfaces;

import app.dto.UserDto;
public interface UserDao {

public UserDto findByID(UserDto userDto) throws Exception;

	public boolean existsByUserName(UserDto userDto) throws Exception;
	
	public void createUser(UserDto userDto) throws Exception;
    
}
