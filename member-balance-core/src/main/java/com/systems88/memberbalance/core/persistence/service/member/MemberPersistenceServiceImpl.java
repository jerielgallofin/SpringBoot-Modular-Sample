package com.systems88.memberbalance.core.persistence.service.member;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.systems88.memberbalance.core.persistence.dao.member.MemberDAO;
import com.systems88.memberbalance.core.persistence.entities.member.Member;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class MemberPersistenceServiceImpl implements MemberPersistenceService {

	private MemberDAO memberDao;

	public MemberPersistenceServiceImpl(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public <T extends Member> T getMemberBy(String memberId, Class<T> clazz) {
		return memberDao.getMemberBy(memberId, clazz);
	}

	@Override
	public <T extends Member> List<T> getAllMembers(Class<T> clazz) {
		return memberDao.getAllMembers(clazz);
	}

	@Override
	public <T extends Member> List<T> getMemberByCurrency(String currency, Class<T> clazz) {
		return memberDao.getMemberByCurrency(currency, clazz);
	}

}
