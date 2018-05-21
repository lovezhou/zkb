package com.bootdo.website.dao;

import com.bootdo.website.domain.CatalogDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author zmy
 * @email 951449465@qq.com
 * @date 2018-04-21 23:02:42
 */
@Mapper
public interface CatalogDao {

	CatalogDO get(Integer catalogId);
	
	List<CatalogDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(CatalogDO catalog);
	
	int update(CatalogDO catalog);
	
	int remove(Integer catalog_id);
	
	int batchRemove(Integer[] catalogIds);

	boolean checkUnique(CatalogDO catalog);
}
