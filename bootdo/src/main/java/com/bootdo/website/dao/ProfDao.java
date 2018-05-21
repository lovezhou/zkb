package com.bootdo.website.dao;

import com.bootdo.website.domain.ProfDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author zmy
 * @email 260173295@qq.com
 * @date 2018-04-28 12:50:21
 */
@Mapper
public interface ProfDao {

	ProfDO get(String profId);
	
	List<ProfDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ProfDO prof);
	
	int update(ProfDO prof);
	
	int remove(String prof_id);
	
	int batchRemove(String[] profIds);

	boolean checkUnique(ProfDO prof);
}
