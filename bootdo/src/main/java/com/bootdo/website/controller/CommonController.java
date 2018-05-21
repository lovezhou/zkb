package com.bootdo.website.controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.domain.DictDO;
import com.bootdo.website.domain.ExercisesDO;
import com.bootdo.website.domain.ProfDO;
import com.bootdo.website.domain.SbDO;
import com.bootdo.website.service.ExercisesService;
import com.bootdo.website.service.ProfService;
import com.bootdo.website.service.SbService;

/**
 * 网站 下拉框数据字典
 * 类CommonController.java的实现描述：公共组件下拉框
 * @author ZMY 2018年5月5日 上午11:28:49
 */
@RequestMapping("/common")
@Controller
public class CommonController {
	

	@Autowired
	ProfService profService;
	
	@Autowired
	SbService sbService;
	
	@Autowired
	ExercisesService exeService;
	
	/**
	 * 自考专业下拉框
	 * @return
	 */
	@ResponseBody
	@GetMapping("/prof")
	List<DictDO> prof() {
		List<ProfDO> list =profService.list(null);
		return convertDict1(list,"getProfId","getProfName");
	}

	/**
	 * 科目代码下拉框
	 * @return
	 */
	@ResponseBody
	@GetMapping("/sbCode")
	List<DictDO> sbCode() {
		List<SbDO> list =sbService.listDistinct(null);
		return convertDict1(list,"getSbCode","getSbName");
	}
	
	/**
	 * 科目系统管理下拉框
	 * @return
	 */
	@ResponseBody
	@GetMapping("/exeId")
	List<DictDO> exeId() {
		List<ExercisesDO> list =exeService.listDistinct(null);
		return convertDict1(list,"getId","getName");
	}

	/**
	 * 用convertDict1 方法替代
	 * @param list
	 * @return
	 */
	@Deprecated
	private List<DictDO> convertDict(List<ProfDO> list){
		 List<DictDO> arr = new ArrayList<DictDO>();
		 if(list!=null){
			 for (ProfDO profDo : list) {
				 DictDO dict = new DictDO();
				 dict.setName(profDo.getProfName()+"("+profDo.getProfId()+")");
				 dict.setValue(profDo.getProfId());
				 arr.add(dict);
			}
		 }
		return arr;
	}
	
	/**
	 * 泛型转换
	 * @param list
	 * @param valueMethodName 值的方法名
	 * @param nameMethod    名称的方法名 有多个
	 * @return
	 */
	private <T> List<DictDO> convertDict1(List<T> list,String valueMethodName,String ... nameMethod){
		 List<DictDO> arr = new ArrayList<DictDO>();
		 if(list!=null){
			 for (T t : list) {
				 DictDO dict = new DictDO();
				 Class<?> clazz= t.getClass();
				 try {
					 String names="";
					 if(nameMethod!=null&& nameMethod.length>0){
						 for(String  name :  nameMethod){
							 Method method=clazz.getMethod(name);
							 names+=method.invoke(t)+"";
						 }
						 dict.setName(names);
					 }
					 Method method=clazz.getMethod(valueMethodName);
					 dict.setValue(method.invoke(t)+"");
				 }catch (Exception e) {
					e.printStackTrace();
				 }
				 arr.add(dict);
			}
		 }
		return arr;
	}
	
}
