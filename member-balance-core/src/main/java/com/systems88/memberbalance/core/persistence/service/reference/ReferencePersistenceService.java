package com.systems88.memberbalance.core.persistence.service.reference;

import com.systems88.memberbalance.core.persistence.entities.reference.Operator;

public interface ReferencePersistenceService {

	public Operator findOperatorByOpCode(String opCode);

}
