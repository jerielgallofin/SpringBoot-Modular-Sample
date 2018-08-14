package com.systems88.memberbalance.core.persistence.dao.reference;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.systems88.memberbalance.core.persistence.entities.reference.Operator;

@Repository
public class OperatorDAO {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Get Op by opCode
	 * 
	 * @param opCode
	 * @return
	 */
	public Operator findOperatorByOpCode(String opCode) {
		List<Operator> result = entityManager
				.createQuery("SELECT op FROM Operator op WHERE op.opCode = :opCode", Operator.class)
				.setParameter("opCode", opCode).setHint("org.hibernate.cacheable", true)
				.setHint("org.hibernate.cacheMode", "NORMAL").getResultList();
		return !result.isEmpty() ? result.get(0) : null;
	}

}
