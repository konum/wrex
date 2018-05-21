package org.wrex.service.impl;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wrex.api.domain.PostDTO;
import org.wrex.dao.PostRepository;
import org.wrex.mappers.PostMapper;
import org.wrex.service.PostService;

@Service("postService")
@Transactional
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postDao;
	

	/**
	 * Creates a new Warning
	 * @param post
	 */
	public void save(PostDTO post) {
		postDao.save(PostMapper.INSTANCE.dtoToPost(post));
	}
	@Override
	public List<PostDTO> getAllPost() {
		return PostMapper.INSTANCE.listToPostDTO(IterableUtils.toList(postDao.findAll()));
	}
}
