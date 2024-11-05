package app.app.dao;


import app.dao.Interfaces.UserDao;
import app.dao.repositories.UserRepository;
import app.dto.UserDto;
import app.helpers.Helpers;
import app.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Getter
@Setter
public  class UserDaoImplementation implements UserDao {
    
    @Autowired    
    UserRepository userRepository;
    @Override
         public UserDto findByID(UserDto userDto) throws Exception {
		User user = userRepository.findByUsername(userDto.getUserName());
                return Helpers.parse(user);

	}
    @Override
    public boolean existsByUserName(UserDto userDto) throws Exception {
		return userRepository.existsByUsername(userDto.getUserName());
		}
    @Override
    public void createUser(UserDto userDto) throws Exception {
		User user = Helpers.parse(userDto);
		userRepository.save(user);
		}
}

