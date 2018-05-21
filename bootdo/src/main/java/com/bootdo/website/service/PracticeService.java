package com.bootdo.website.service;

import com.bootdo.website.domain.PracticeDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zmy
 * @email 260173295@qq.com
 * @date 2018-05-15 15:44:43
 */
public interface PracticeService {
	
	PracticeDO get(Integer id);
	
	List<PracticeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PracticeDO practice);
	
	int update(PracticeDO practice);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
