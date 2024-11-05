package app.ServiceInterface;

import app.dto.UserDto;

public interface LoginService {
    public void Login(UserDto userDto) throws Exception;
    public void Logout();
}
