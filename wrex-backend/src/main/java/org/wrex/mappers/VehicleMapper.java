package org.wrex.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.wrex.dto.VehicleDTO;
import org.wrex.entities.Vehicle;

@Mapper(uses=DateMapper.class)
public interface VehicleMapper {
	VehicleMapper INSTANCE = Mappers.getMapper( VehicleMapper.class );
    
	VehicleDTO entityToDTO(Vehicle user); 
	Vehicle dtoToEntity(VehicleDTO user); 
    List<VehicleDTO> listToDTOList(List<Vehicle> source);
}
