package com.bootdo.website.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.website.domain.ExercisesDO;
import com.bootdo.website.service.ExercisesService;

/**
 * 
 * 
 * @author zmy
 * @email 260173295@qq.com
 * @date 2018-05-06 12:39:36
 */
 
@Controller
@RequestMapping("/website/exercises")
public class ExercisesController {
	@Autowired
	private ExercisesService exercisesService;
	
	@GetMapping()
	@RequiresPermissions("website:exercises:exercises")
	String Exercises(){
	    return "website/exercises/exercises";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("website:exercises:exercises")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ExercisesDO> exercisesList = exercisesService.list(query);
		int total = exercisesService.count(query);
		PageUtils pageUtils = new PageUtils(exercisesList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("website:exercises:add")
	String add(){
	    return "website/exercises/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("website:exercises:edit")
	String edit(@PathVariable("id") String id,Model model){
		ExercisesDO exercises = exercisesService.get(id);
		model.addAttribute("exercises", exercises);
	    return "website/exercises/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("website:exercises:add")
	public R save( ExercisesDO exercises){
		boolean flag = exercisesService.checkUnique(exercises);
		if(flag){
			return R.error("名称["+exercises.getName()+"]已存在系统");
		}
		if(exercisesService.save(exercises)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("website:exercises:edit")
	public R update( ExercisesDO exercises){
		boolean flag = exercisesService.checkUnique(exercises);
		if(flag){
			return R.error("名称["+exercises.getName()+"]已存在系统");
		}
		exercisesService.update(exercises);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("website:exercises:remove")
	public R remove( String id){
		if(exercisesService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("website:exercises:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		exercisesService.batchRemove(ids);
		return R.ok();
	}
	
}
