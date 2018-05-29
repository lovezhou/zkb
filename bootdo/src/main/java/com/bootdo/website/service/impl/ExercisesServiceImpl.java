package com.bootdo.website.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.bootdo.common.utils.RandomString;
import com.bootdo.website.dao.ExercisesDao;
import com.bootdo.website.domain.ExercisesDO;
import com.bootdo.website.domain.SbDO;
import com.bootdo.website.service.ExercisesService;



@Service
public class ExercisesServiceImpl implements ExercisesService {
	@Autowired
	private ExercisesDao exercisesDao;
	
	@Override
	public ExercisesDO get(String id){
		return exercisesDao.get(id);
	}
	
	@Override
	public List<ExercisesDO> list(Map<String, Object> map){
		return exercisesDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return exercisesDao.count(map);
	}
	
	@Override
	public int save(ExercisesDO exercises){
		exercises.setId(RandomString.generateRandomString(32));
		return exercisesDao.save(exercises);
	}
	
	@Override
	public int update(ExercisesDO exercises){
		return exercisesDao.update(exercises);
	}
	
	@Override
	public int remove(String id){
		return exercisesDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return exercisesDao.batchRemove(ids);
	}

	@Override
	public List<ExercisesDO> listDistinct(Map<String, Object> map) {
		return exercisesDao.listDistinct(map);
	}

	@Override
	public boolean checkUnique(ExercisesDO exercises) {
		return exercisesDao.checkUnique(exercises);
	}
	
}
