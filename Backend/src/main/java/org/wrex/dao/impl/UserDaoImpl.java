package org.wrex.dao.impl;


import org.springframework.stereotype.Repository;
import org.wrex.dao.UserDao;
import org.wrex.domain.QUser;
import org.wrex.domain.User;

import com.querydsl.jpa.impl.JPAQuery;


@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao{

	public UserDaoImpl(){
		this.entityClass = User.class;
	}
	@Override
	public int countAll() {
		return super.countAll(QUser.user);
	}

	@Override
	public User getByEmail(String email) {
		QUser user = QUser.user;
		JPAQuery<User> query = newJPA();
		return query.from(user).where(user.email.eq(email)).fetchFirst();
	}
	@Override
	public User getByIdFb(String idFb) {
		QUser user = QUser.user;
		JPAQuery<User> query = newJPA();
		return query.from(user).where(user.idUserFB.eq(idFb)).fetchFirst();
	}

}