package com.systems88.memberbalance.core.persistence.entities.reference;

import java.math.BigDecimal;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_op")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Operator implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7361942206019965535L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx", unique = true, nullable = false)
	private Long idx;

	@Column(name = "merch_id")
	private String merchId;

	@Column(name = "merch_pwd")
	private String merchPwd;

	@Column(name = "op_code")
	private String opCode;

	@Column(name = "status")
	private String status;

	@Column(name = "amount")
	private BigDecimal amount;

	@Column(name = "\"limit\"")
	private String limit;

}
