package org.wrex.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.wrex.dto.EntryDTO;
import org.wrex.entities.Entry;

@Mapper(uses=DateMapper.class)
public interface EntryMapper {
	EntryMapper INSTANCE = Mappers.getMapper( EntryMapper.class );
    
	EntryDTO entityToDTO(Entry source); 
	Entry dtoToEntity(EntryDTO source); 
    List<EntryDTO> listToDTOList(List<Entry> source);
}
