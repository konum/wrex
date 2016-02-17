package org.wrex.dao.impl;


import org.springframework.stereotype.Repository;
import org.wrex.dao.PostDao;
import org.wrex.domain.Post;


@Repository("postDao")
public class PostDaoImpl extends GenericDaoImpl<Post,Integer> implements PostDao{

	public PostDaoImpl(){
		this.entityClass = Post.class;
	}

}
