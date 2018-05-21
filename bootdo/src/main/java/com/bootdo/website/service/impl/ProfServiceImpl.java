package com.bootdo.website.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.website.dao.ProfDao;
import com.bootdo.website.domain.ProfDO;
import com.bootdo.website.service.ProfService;



@Service
public class ProfServiceImpl implements ProfService {
	@Autowired
	private ProfDao profDao;
	
	@Override
	public ProfDO get(String profId){
		return profDao.get(profId);
	}
	
	@Override
	public List<ProfDO> list(Map<String, Object> map){
		return profDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return profDao.count(map);
	}
	
	@Override
	public int save(ProfDO prof){
		return profDao.save(prof);
	}
	
	@Override
	public int update(ProfDO prof){
		return profDao.update(prof);
	}
	
	@Override
	public int remove(String profId){
		return profDao.remove(profId);
	}
	
	@Override
	public int batchRemove(String[] profIds){
		return profDao.batchRemove(profIds);
	}

	@Override
	public boolean checkUnique(ProfDO prof) {
		return profDao.checkUnique(prof);
	}
	
	
}
