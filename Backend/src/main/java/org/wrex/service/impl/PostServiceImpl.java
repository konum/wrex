package org.wrex.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wrex.dao.PostDao;
import org.wrex.domain.Post;
import org.wrex.service.PostService;

@Service("postService")
@Transactional
public class PostServiceImpl implements PostService{

	@Autowired
	private PostDao postDao;
	/**
	 * Creates a new Warning
	 * @param warn
	 */
	public void create(Post warn) {
		postDao.insert(warn);
	}
	@Override
	public List<Post> getAllPost() {
		return new ArrayList<Post>(postDao.getAll());
	}
}
