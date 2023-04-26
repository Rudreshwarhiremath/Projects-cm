package com.xworkz.pro.repositery;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.pro.entity.Technology;
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
	public UserEntity getByUser(String userId) {
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
		log.info("count:" + count);
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
	public boolean updatePassword(String userId, String password, Boolean resetPassword,
			LocalTime passwordChangedTime) {
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

	@Override
	public boolean saveTechnology(Technology technology) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(technology);
			et.commit();
			return true;
		} finally {
			em.close();
		}
	}

	@Override
	public List<Technology> searchByTechName(String teName, int id) {
		log.info("Running in repo searchByTechName list " + teName + "id--" + id);
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("searchByTechName");
			query.setParameter("techName", teName);
			query.setParameter("tid", id);
			List<Technology> list = query.getResultList();
			log.info("See List in repo  " + list);
			return list;
		} finally {
			em.close();

		}
	}

	@Override
	public List<Technology> searchByTechLanguage(String teLangauge, int id) {
		log.info("Running in repo searchByTechName list " + teLangauge + "  id--" + id);
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("searchByTechLangauge");
			query.setParameter("techLangauge", teLangauge);
			query.setParameter("taid", id);
			List<Technology> list = query.getResultList();
			log.info("See List in repo  " + list);
			return list;
		} finally {
			em.close();

		}
	}

	@Override
	public List<Technology> searchByTechLicense(String teLicense, int id) {
		log.info("Running in repo searchByTechName list " + teLicense + "id--" + id);
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("searchByTechLicense");
			query.setParameter("techLicense", teLicense);
			query.setParameter("tbid", id);
			List<Technology> list = query.getResultList();
			log.info("See List in repo  " + list);
			return list;
		} finally {
			em.close();

		}
	}

	@Override
	public List<Technology> searchByTechOpenSource(String teOpenSource, int id) {
		log.info("Running in repo searchByTechName list " + teOpenSource + "id--" + id);
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("searchByTechOpenSource");
			query.setParameter("techOpenSource", teOpenSource);
			query.setParameter("tcid", id);
			List<Technology> list = query.getResultList();
			log.info("See List in repo  " + list);
			return list;
		} finally {
			em.close();

		}
	}

	@Override
	public List<Technology> searchByTechOsType(String teOsType, int id) {
		log.info("Running in repo searchByTechName list " + teOsType + "id--" + id);
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("searchByTechOsType");
			query.setParameter("techOsType", teOsType);
			query.setParameter("tdid", id);
			List<Technology> list = query.getResultList();
			log.info("See List in repo  " + list);
			return list;
		} finally {
			em.close();

		}
	}

	@Override
	public List<Technology> searchByTechOwner(String teOwner, int id) {
		log.info("Running in repo searchByTechName list " + teOwner + "id--" + id);
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("searchByTechOwner");
			query.setParameter("techOwner", teOwner);
			query.setParameter("teid", id);
			List<Technology> list = query.getResultList();
			log.info("See List in repo  " + list);
			return list;
		} finally {
			em.close();

		}
	}

	@Override
	public List<Technology> searchByTechSupportFrom(String teSupportFrom, int id) {
		log.info("Running in repo searchByTechName list " + teSupportFrom + "id--" + id);
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("searchByTechSupportFrom");
			query.setParameter("techSupportFrom", teSupportFrom);
			query.setParameter("tfid", id);
			List<Technology> list = query.getResultList();
			log.info("See List in repo  " + list);
			return list;
		} finally {
			em.close();

		}
	}

	@Override
	public List<Technology> searchByTechSupportTo(String teSupportTo, int id) {
		log.info("Running in repo searchByTechName list " + teSupportTo + "id--" + id);
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("searchByTechSupportTo");
			query.setParameter("techSupportTo", teSupportTo);
			query.setParameter("tgid", id);
			List<Technology> list = query.getResultList();
			log.info("See List in repo  " + list);
			return list;
		} finally {
			em.close();

		}
	}

	@Override
	public List<Technology> searchByTechVersion(String teVersion, int id) {
		log.info("Running in repo searchByTechName list " + teVersion + "id--" + id);
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			Query query = em.createNamedQuery("searchByTechVersion");
			query.setParameter("techVersion", teVersion);
			query.setParameter("thid", id);
			List<Technology> list = query.getResultList();
			log.info("See List in repo  " + list);
			return list;
		} finally {
			em.close();

		}
	}
}
