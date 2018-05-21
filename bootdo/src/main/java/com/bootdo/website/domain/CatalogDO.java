package com.bootdo.website.domain;

import java.io.Serializable;



/**
 * 
 * 
 * @author zmy
 * @email 951449465@qq.com
 * @date 2018-04-21 23:02:42
 */
public class CatalogDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//目录id
	private Integer catalogId;
	//父目录id,0表示根目录
	private Integer parentId;
	//
	private String name;
	//
	private Integer orderNum;
	//
	private Integer delFlag;
	//目录对应的超链接
	private String url;

	/**
	 * 设置：目录id
	 */
	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}
	/**
	 * 获取：目录id
	 */
	public Integer getCatalogId() {
		return catalogId;
	}
	/**
	 * 设置：父目录id,0表示根目录
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父目录id,0表示根目录
	 */
	public Integer getParentId() {
		return parentId;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：
	 */
	public Integer getOrderNum() {
		return orderNum;
	}
	/**
	 * 设置：
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getDelFlag() {
		return delFlag;
	}
	/**
	 * 设置：目录对应的超链接
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：目录对应的超链接
	 */
	public String getUrl() {
		return url;
	}
}
