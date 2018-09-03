package org.wrex.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.wrex.dto.DriverDTO;
import org.wrex.entities.Driver;

@Mapper
public interface DriverMapper {
	DriverMapper INSTANCE = Mappers.getMapper( DriverMapper.class );
    
	DriverDTO entityToDTO(Driver driver); 
	Driver dtoToEntity(DriverDTO driver); 
    List<DriverDTO> listToDTOList(List<Driver> source);
}
