package com.bootdo.website.domain;

import java.io.Serializable;



/**
 * 
 * 
 * @author zmy
 * @email 260173295@qq.com
 * @date 2018-05-06 12:39:36
 */
public class ExercisesDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private String id;
	//名称
	private String name;
	//科目代码
	private String sbcode;
	//排序
	private Integer sort;

	/**
	 * 设置：主键
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：科目代码
	 */
	public void setSbcode(String sbcode) {
		this.sbcode = sbcode;
	}
	/**
	 * 获取：科目代码
	 */
	public String getSbcode() {
		return sbcode;
	}
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
}
