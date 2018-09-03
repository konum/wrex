package org.wrex.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.wrex.dto.DriverDTO;
import org.wrex.dto.UsersDTO;
import org.wrex.entities.Driver;
import org.wrex.entities.Users;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    
	UsersDTO entityToDTO(Users driver); 
	Users dtoToEntity(UsersDTO driver); 
    List<UsersDTO> listToDTOList(List<Users> source);
}
