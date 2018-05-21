package com.bootdo.website.domain;

import java.io.Serializable;



/**
 * 
 * 
 * @author zmy
 * @email 260173295@qq.com
 * @date 2018-04-28 12:50:21
 */
public class SbDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id=prof_id+sb_code
	private String sbId;
	//科目代码
	private String sbCode;
	//科目名称
	private String sbName;
	//类型：1：必考，2：加考
	private String sbType;
	private String sbTypeName;
	//website_prof表中prof_id
	private String profId;

	/**
	 * 设置：id=prof_id+sb_code
	 */
	public void setSbId(String sbId) {
		this.sbId = sbId;
	}
	/**
	 * 获取：id=prof_id+sb_code
	 */
	public String getSbId() {
		return sbId;
	}
	/**
	 * 设置：科目代码
	 */
	public void setSbCode(String sbCode) {
		this.sbCode = sbCode;
	}
	/**
	 * 获取：科目代码
	 */
	public String getSbCode() {
		return sbCode;
	}
	/**
	 * 设置：科目名称
	 */
	public void setSbName(String sbName) {
		this.sbName = sbName;
	}
	/**
	 * 获取：科目名称
	 */
	public String getSbName() {
		return sbName;
	}
	/**
	 * 设置：类型：1：必考，2：加考
	 */
	public void setSbType(String sbType) {
		this.sbType = sbType;
	}
	/**
	 * 获取：类型：1：必考，2：加考
	 */
	public String getSbType() {
		return sbType;
	}
	/**
	 * 设置：website_prof表中prof_id
	 */
	public void setProfId(String profId) {
		this.profId = profId;
	}
	/**
	 * 获取：website_prof表中prof_id
	 */
	public String getProfId() {
		return profId;
	}
	public String getSbTypeName() {
		return sbTypeName;
	}
	public void setSbTypeName(String sbTypeName) {
		this.sbTypeName = sbTypeName;
	}
	
	
	
}
