package org.wrex.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.wrex.api.domain.UserDTO;
import org.wrex.entities.User;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    
    UserDTO userToUserDTO(User user); 
    User userDtoToUser(UserDTO user); 
    List<UserDTO> listToDTOList(List<User> source);
}
