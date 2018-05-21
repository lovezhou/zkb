package com.bootdo.website.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.website.dao.PracticeDao;
import com.bootdo.website.domain.PracticeDO;
import com.bootdo.website.service.PracticeService;



@Service
public class PracticeServiceImpl implements PracticeService {
	@Autowired
	private PracticeDao practiceDao;
	
	@Override
	public PracticeDO get(Integer id){
		return practiceDao.get(id);
	}
	
	@Override
	public List<PracticeDO> list(Map<String, Object> map){
		return practiceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return practiceDao.count(map);
	}
	
	@Override
	public int save(PracticeDO practice){
		return practiceDao.save(practice);
	}
	
	@Override
	public int update(PracticeDO practice){
		return practiceDao.update(practice);
	}
	
	@Override
	public int remove(Integer id){
		return practiceDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return practiceDao.batchRemove(ids);
	}
	
}
