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
@Table(name = "tb_member_micro")
public class MemberMicro implements java.io.Serializable, Member {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3857552788818086453L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx", unique = true, nullable = false)
	private Long idx;

	@Column(name = "merch_id")
	private int merchId;

	@Column(name = "micro_id")
	private String memberId;

	@Column(name = "micro_num_id")
	private String microNumId;

	@Column(name = "micro_pwd")
	private String microPwd;

	@Column(name = "token")
	private String token;

	@Column(name = "token_update")
	private Date tokenUpdate;

	@Column(name = "LapisToken")
	private String lapisToken;

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
