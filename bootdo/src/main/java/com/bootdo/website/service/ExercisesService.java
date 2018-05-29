package com.bootdo.website.service;

import com.bootdo.website.domain.ExercisesDO;
import com.bootdo.website.domain.SbDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zmy
 * @email 260173295@qq.com
 * @date 2018-05-06 12:39:36
 */
public interface ExercisesService {
	
	ExercisesDO get(String id);
	
	List<ExercisesDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ExercisesDO exercises);
	
	int update(ExercisesDO exercises);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	/**
	 * 按照习题分组
	 * @param object
	 * @return
	 */
	List<ExercisesDO> listDistinct(Map<String, Object> map);

	boolean checkUnique(ExercisesDO exercises);
}
