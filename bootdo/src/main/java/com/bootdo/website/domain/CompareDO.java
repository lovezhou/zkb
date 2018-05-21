package com.bootdo.website.domain;

import java.io.Serializable;
import java.util.List;

public class CompareDO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private boolean flagAll;//全部标识
	
    private List<ResultDO> arr;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ResultDO> getList() {
		return arr;
	}

	public void setList(List<ResultDO> arr) {
		this.arr = arr;
	}

	public boolean isFlagAll() {
		return flagAll;
	}

	public void setFlagAll(boolean flagAll) {
		this.flagAll = flagAll;
	}

    
    
}
