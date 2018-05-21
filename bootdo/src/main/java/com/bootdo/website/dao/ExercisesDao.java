package com.bootdo.website.dao;

import com.bootdo.website.domain.ExercisesDO;
import com.bootdo.website.domain.SbDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author zmy
 * @email 260173295@qq.com
 * @date 2018-05-06 12:39:36
 */
@Mapper
public interface ExercisesDao {

	ExercisesDO get(String id);
	
	List<ExercisesDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ExercisesDO exercises);
	
	int update(ExercisesDO exercises);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	List<ExercisesDO> listDistinct(Map<String, Object> map);
}
