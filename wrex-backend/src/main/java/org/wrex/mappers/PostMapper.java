package org.wrex.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.wrex.api.domain.PostDTO;
import org.wrex.entities.Post;

@Mapper
public interface PostMapper {

	PostMapper INSTANCE = Mappers.getMapper( PostMapper.class );

	PostDTO postToDTO(Post post);
	Post dtoToPost(PostDTO post);

	List<PostDTO> listToPostDTO(List<Post> post);
}
