package com.systems88.memberbalance.core.persistence.service.member;

import java.util.List;

import com.systems88.memberbalance.core.persistence.entities.member.Member;

public interface MemberPersistenceService {

	public <T extends Member> T getMemberBy(String memberId, Class<T> clazz);

	public <T extends Member> List<T> getMemberByCurrency(String currency, Class<T> clazz);

	public <T extends Member> List<T> getAllMembers(Class<T> clazz);

}
