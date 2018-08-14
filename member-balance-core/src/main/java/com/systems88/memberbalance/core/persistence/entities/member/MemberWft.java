package com.systems88.memberbalance.core.persistence.entities.member;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_member_wft")
public class MemberWft implements java.io.Serializable, Member {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7069148323210322603L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx", unique = true, nullable = false)
	private Long idx;

	@Column(name = "merch_id")
	private int merchId;

	@Column(name = "member_id")
	private String memberId;

	@Column(name = "request_ip")
	private String requestIp;

	@Column(name = "birth_day")
	private String birthDay;

	@Column(name = "language")
	private String language;

	@Column(name = "currency")
	private String currency;

	@Column(name = "country_code")
	private String countryCode;

	@Column(name = "reg_date")
	private Date regDate;

}
