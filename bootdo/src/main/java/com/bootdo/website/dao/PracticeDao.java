package com.bootdo.website.dao;

import com.bootdo.website.domain.PracticeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author zmy
 * @email 260173295@qq.com
 * @date 2018-05-15 15:44:43
 */
@Mapper
public interface PracticeDao {

	PracticeDO get(Integer id);
	
	List<PracticeDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(PracticeDO practice);
	
	int update(PracticeDO practice);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
