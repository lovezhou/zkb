package com.bootdo.website.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.RandomString;
import com.bootdo.website.domain.CatalogDO;
import com.bootdo.website.domain.CompareDO;
import com.bootdo.website.domain.ExercisesDO;
import com.bootdo.website.domain.PracticeDO;
import com.bootdo.website.domain.ProfDO;
import com.bootdo.website.domain.ResultDO;
import com.bootdo.website.domain.SbDO;
import com.bootdo.website.service.CatalogService;
import com.bootdo.website.service.ExercisesService;
import com.bootdo.website.service.PracticeService;
import com.bootdo.website.service.ProfService;
import com.bootdo.website.service.SbService;

/**
 * 对应整个自考网站前端页面请求
 * 类WebController.java的实现描述：TODO 类实现描述 
 * @author ZMY 2018年5月5日 上午11:54:51
 */
@RequestMapping("/web")
@Controller
public class WebController {
	
	@Autowired
	CatalogService catalogService;
	@Autowired
	ProfService profService;
	@Autowired
	SbService sbService;
	@Autowired
	private ExercisesService exercisesService;
	@Autowired
	private PracticeService practiceService;
	
	private String prefix="website/index/";
	
	private  Map<String,CompareDO> compareMap = new  HashMap<String,CompareDO>();

	
	@GetMapping("")
	ModelAndView  web() {
		ModelAndView view = new ModelAndView(prefix+"index");
		List<CatalogDO> list =catalogService.list(null);
		view.addObject("catalogs", list);
		return view;
	}
	
	@GetMapping("/prof")
	ModelAndView prof() {
		ModelAndView view = new ModelAndView(prefix+"prof");
		List<ProfDO> list =profService.list(null);
		List<CatalogDO> list1 =catalogService.list(null);
		view.addObject("profs", convertMap(list));
		view.addObject("catalogs", list1);;
		return view;
	}
	
	@GetMapping("/about")
	ModelAndView about() {
		ModelAndView view = new ModelAndView(prefix+"about");
		List<ProfDO> list =profService.list(null);
		List<CatalogDO> list1 =catalogService.list(null);
		view.addObject("profs", convertMap(list));
		view.addObject("catalogs", list1);;
		return view;
	}
	
	@GetMapping("/sb/{profId}")
	ModelAndView subject(@PathVariable("profId") String profId) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("profId", profId);
		ProfDO profDo=profService.get(profId);
		List<SbDO> list =sbService.list(map);
		List<CatalogDO> list1 =catalogService.list(null);
		ModelAndView view = new ModelAndView(prefix+"sb");
		view.addObject("sbs", list);
		view.addObject("catalogs", list1);
		view.addObject("profDo", profDo);
		return view;
	}
	@GetMapping("/exe/{profId}/{sbcode}")
	ModelAndView exercises(@PathVariable("profId") String profId,@PathVariable("sbcode") String sbcode){
	  
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("sbcode", sbcode);
	    List<ExercisesDO> exeList = exercisesService.list(map);
	    SbDO sb =sbService.get(profId+sbcode);
		List<CatalogDO> list1 =catalogService.list(null);
		ModelAndView view = new ModelAndView(prefix+"execrise");
		view.addObject("sb", sb);
		view.addObject("catalogs", list1);
		view.addObject("exes", exeList);
		return view;
	}

	/**
	 * 习题比较
	 * @param exeId
	 * @return
	 */
	@ResponseBody
	@PostMapping("/practice/compare")
	R compare(@RequestBody String param) {
		
		JSONObject obj = JSON.parseObject(param);//TODO fastjon 待测试
		CompareDO domain= new  CompareDO();
		domain.setFlagAll(obj.getBoolean("flagAll"));
		domain.setId(obj.getString("id"));
		domain.setList(JSON.parseArray(obj.getString("arr"), ResultDO.class));
		String uuid=RandomString.generateRandomString(32);
		compareMap.put(uuid,domain);
		return R.ok(uuid);
	}
	
	
	/**
	 * 习题练习
	 * @param exeId
	 * @return
	 */
	@GetMapping("/practice/{exeId}")
	ModelAndView practice(@PathVariable("exeId") String exeId) {
	    ExercisesDO exeDo= exercisesService.get(exeId);
	    Map<String,Object> map=new HashMap<String,Object>();
		map.put("exeId", exeId);
		List<PracticeDO>  list =practiceService.list(map);
		ModelAndView view = new ModelAndView(prefix+"practice_list");
		view.addObject("exeDo", exeDo);
		view.addObject("parcDO", list);
		return view;
	}
	
	/**
	 * 习题练习
	 * @param exeId
	 * @return
	 */
	@GetMapping("/practView/{uuid}")
	ModelAndView practiceView(@PathVariable("uuid") String uuid) {
		CompareDO compareDO=compareMap.get(uuid);
		ModelAndView view = new ModelAndView(prefix+"practice_anw");
		//放在无效请求
		if(compareDO==null){
			return view;
		}
		String exeId=  compareDO.getId();
		ExercisesDO exeDo= exercisesService.get(exeId);
	    Map<String,Object> map=new HashMap<String,Object>();
		map.put("exeId", exeId);
		List<ResultDO>  nums = compareDO.getList();
		map.put("nums", nums);
		List<PracticeDO> 	list =practiceService.list(map);
		
		view.addObject("exeDo", exeDo);
		view.addObject("parcDO", list);
		view.addObject("nums", nums);
		return view;
	}
	
	private Map<String,List<ProfDO>> convertMap(List<ProfDO> list){
		Map<String,List<ProfDO>> map = new  HashMap<String,List<ProfDO>>();
		if(list == null||list.size()==0 ){
			return null;
		}
		for (ProfDO profDO : list) {
			if(!map.containsKey(profDO.getProfTypeName())){
				List<ProfDO> val = new ArrayList<ProfDO>();
				val.add(profDO);
				map.put(profDO.getProfTypeName(), val);
			}else{
				map.get(profDO.getProfTypeName()).add(profDO);
			}
		}
		return  map;
	}
	
}
