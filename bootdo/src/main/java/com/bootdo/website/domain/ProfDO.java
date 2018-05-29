package com.bootdo.website.domain;

import java.io.Serializable;



/**
 * 
 * 
 * @author zmy
 * @email 260173295@qq.com
 * @date 2018-04-28 12:50:21
 */
public class ProfDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自考专业id
	private String profId;
	//自考专业名称
	private String profName;
	//类别,1:本科，2：专科
	private Integer profType;
	private String  profTypeName;
	
	private String opertor;//操作：1：新增，2删除，校验唯一性时使用

	/**
	 * 设置：自考专业id
	 */
	public void setProfId(String profId) {
		this.profId = profId;
	}
	/**
	 * 获取：自考专业id
	 */
	public String getProfId() {
		return profId;
	}
	/**
	 * 设置：自考专业名称
	 */
	public void setProfName(String profName) {
		this.profName = profName;
	}
	/**
	 * 获取：自考专业名称
	 */
	public String getProfName() {
		return profName;
	}
	/**
	 * 设置：类别,1:本科，2：专科
	 */
	public void setProfType(Integer profType) {
		this.profType = profType;
	}
	/**
	 * 获取：类别,1:本科，2：专科
	 */
	public Integer getProfType() {
		return profType;
	}
	public String getProfTypeName() {
		return profTypeName;
	}
	public void setProfTypeName(String profTypeName) {
		this.profTypeName = profTypeName;
	}
	public String getOpertor() {
		return opertor;
	}
	public void setOpertor(String opertor) {
		this.opertor = opertor;
	}
	
	
}
