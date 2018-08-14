package com.systems88.memberbalance.core.persistence.dao.member;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.systems88.memberbalance.core.persistence.entities.member.Member;

@Repository
public class MemberDAO {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Get member by memberId
	 * 
	 * @param memberId
	 * @param clazz
	 * @return
	 */
	public <T extends Member> T getMemberBy(String memberId, Class<T> clazz) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(clazz);
		Root<T> from = cq.from(clazz);
		Predicate id = cb.equal(from.get("memberId"), memberId);
		cq.where(id);
		CriteriaQuery<T> select = cq.select(from);
		TypedQuery<T> typedQuery = entityManager.createQuery(select);
		return typedQuery.getResultList().isEmpty() ? null : typedQuery.getSingleResult();
	}

	/**
	 * Get member by currency
	 * 
	 * @param currency
	 * @param clazz
	 * @return
	 */
	public <T extends Member> List<T> getMemberByCurrency(String currency, Class<T> clazz) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(clazz);
		Root<T> from = cq.from(clazz);
		Predicate id = cb.equal(from.get("currency"), currency);
		cq.where(id);
		CriteriaQuery<T> select = cq.select(from);
		TypedQuery<T> typedQuery = entityManager.createQuery(select);
		return typedQuery.getResultList();
	}

	/**
	 * Get all members
	 * 
	 * @param clazz
	 * @return
	 */
	public <T extends Member> List<T> getAllMembers(Class<T> clazz) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(clazz);
		Root<T> rootEntry = cq.from(clazz);
		CriteriaQuery<T> all = cq.select(rootEntry);
		TypedQuery<T> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}

}
