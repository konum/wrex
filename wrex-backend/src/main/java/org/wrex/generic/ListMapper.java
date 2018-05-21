package org.wrex.generic;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.wrex.api.domain.UserDTO;
import org.wrex.entities.User;

public class ListMapper {

	@SuppressWarnings("rawtypes")
	public static <T> List<T> mapList(Mapper mapper, Iterable source, Class<T> targetClass){
		List<T> target = new ArrayList<T>();
		for (Object t : source) {
			target.add(mapper.map(t,targetClass));
		}
		return target;
	}

}
