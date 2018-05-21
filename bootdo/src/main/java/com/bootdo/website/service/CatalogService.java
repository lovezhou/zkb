package com.bootdo.website.service;

import com.bootdo.website.domain.CatalogDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zmy
 * @email 951449465@qq.com
 * @date 2018-04-21 23:02:42
 */
public interface CatalogService {
	
	CatalogDO get(Integer catalogId);
	
	List<CatalogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CatalogDO catalog);
	
	int update(CatalogDO catalog);
	
	int remove(Integer catalogId);
	
	int batchRemove(Integer[] catalogIds);

	boolean checkUnique(CatalogDO catalog);
}
