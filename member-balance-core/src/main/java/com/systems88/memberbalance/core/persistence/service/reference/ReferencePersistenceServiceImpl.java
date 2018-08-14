package com.systems88.memberbalance.core.persistence.service.reference;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.systems88.memberbalance.core.persistence.dao.reference.OperatorDAO;
import com.systems88.memberbalance.core.persistence.entities.reference.Operator;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ReferencePersistenceServiceImpl implements ReferencePersistenceService {

	private OperatorDAO operatorDAO;

	public ReferencePersistenceServiceImpl(OperatorDAO operatorDAO) {
		this.operatorDAO = operatorDAO;
	}

	@Override
	public Operator findOperatorByOpCode(String opCode) {
		return operatorDAO.findOperatorByOpCode(opCode);
	}

}
