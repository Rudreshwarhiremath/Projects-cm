package com.xworkz.pro.repositery;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.pro.entity.UserEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserRepositeryImpli implements UserRepositery {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public UserRepositeryImpli() {
		log.info("" + this.getClass().getSimpleName());
	}

	@Override
	public boolean save(UserEntity userEntity) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(userEntity);
			et.commit();
			return true;
		} finally {
			em.close();
		}

	}

	@Override
	public UserEntity userSignIn(String userId) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("user");
			query.setParameter("ui", userId);
			Object object = query.getSingleResult();
			UserEntity entity = (UserEntity) object;
			log.info("" + entity);
			return entity;
		} finally {
			em.close();
		}

	}

	@Override
	public List<UserEntity> findAll() {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("find");
			List<UserEntity> list = query.getResultList();
			log.info("Total list size found in repo" + list.size());
			return list;
		} finally {
			em.close();
		}
	}

	@Override
	public Long findByEmail(String email) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("emailId");
			query.setParameter("emailBy", email);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			System.out.println(value);
			return value;

		} finally {
			em.close();
		}

	}

	@Override
	public Long findByUser(String user) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("userId");
			query.setParameter("userBy", user);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			System.out.println(value);
			return value;

		} finally {
			em.close();
		}
	}

	@Override
	public Long findByMobile(Long number) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("mobileId");
			query.setParameter("mobileBy", number);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			System.out.println(value);
			return value;

		} finally {
			em.close();
		}
	}

	@Override
	public boolean logincount(String userID, int count) {
		log.info("count:"+count);
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			Query query = em.createNamedQuery("updateLoginCount");
			query.setParameter("userID", userID);
			query.setParameter("count", count);
			query.executeUpdate();
			et.commit();
			return true;
		} finally {
			em.close();
		}
	}
	@Override
	public UserEntity reSetPassword(String email) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("emailid");
			query.setParameter("ei", email);
			Object object = query.getSingleResult();
			UserEntity entity = (UserEntity) object;
			log.info("" + entity);
			return entity;
		} finally {
			em.close();
		}
	}
	@Override
	public boolean update(UserEntity userEntity) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.merge(userEntity);
			et.commit();
			return true;
		} finally {
			em.close();
		}
	}
	@Override
	public boolean updatePassword(String userId, String password,Boolean resetPassword,LocalTime passwordChangedTime ) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			Query query = em.createNamedQuery("updatePassword");
			query.setParameter("uu", userId);
			query.setParameter("up", password);
			query.setParameter("urp", resetPassword);
			query.setParameter("pct", passwordChangedTime);
			query.executeUpdate();
			et.commit();
			return true;
		} finally {
			em.close();
		}
	}
}
