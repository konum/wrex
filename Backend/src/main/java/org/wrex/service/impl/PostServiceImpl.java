package org.wrex.service.impl;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wrex.api.domain.PostDTO;
import org.wrex.dao.PostRepository;
import org.wrex.entities.Post;
import org.wrex.generic.ListMapper;
import org.wrex.service.PostService;

@Service("postService")
@Transactional
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postDao;
	

	private Mapper mapper = new DozerBeanMapper();
	
	/**
	 * Creates a new Warning
	 * @param warn
	 */
	public void save(PostDTO warn) {
		postDao.save(mapper.map(warn, Post.class));
	}
	@Override
	public List<PostDTO> getAllPost() {
		return ListMapper.mapList(mapper, postDao.findAll(), PostDTO.class);
	}
}
