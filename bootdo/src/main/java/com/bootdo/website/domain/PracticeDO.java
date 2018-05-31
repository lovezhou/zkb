package com.bootdo.website.domain;

import java.io.Serializable;



/**
 * 
 * 
 * @author zmy
 * @email 260173295@qq.com
 * @date 2018-05-15 15:44:43
 */
public class PracticeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//序列号
	private Integer id;
	//题目编号
	private Integer num;
	//类型：1.选择题
	private String type;
	//题目
	private String question;
	//选项A
	private String a;
	//选项B
	private String b;
	//选项C
	private String c;
	//选项D
	private String d;
	//选项E
	private String e;
	//答案
	private String answer;
	//website_exercises表id
	private String exeId;
	private String exeName;
	private String remark;
	private String typeName;//题目类型
	private String subject;//题目 比如：选择题（共20题）
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getExeName() {
		return exeName;
	}
	public void setExeName(String exeName) {
		this.exeName = exeName;
	}
	/**
	 * 设置：序列号
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：序列号
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：题目编号
	 */
	public void setNum(Integer num) {
		this.num = num;
	}
	/**
	 * 获取：题目编号
	 */
	public Integer getNum() {
		return num;
	}
	/**
	 * 设置：类型：1.选择题
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型：1.选择题
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：题目
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * 获取：题目
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * 设置：选项A
	 */
	public void setA(String a) {
		this.a = a;
	}
	/**
	 * 获取：选项A
	 */
	public String getA() {
		return a;
	}
	/**
	 * 设置：选项B
	 */
	public void setB(String b) {
		this.b = b;
	}
	/**
	 * 获取：选项B
	 */
	public String getB() {
		return b;
	}
	/**
	 * 设置：选项C
	 */
	public void setC(String c) {
		this.c = c;
	}
	/**
	 * 获取：选项C
	 */
	public String getC() {
		return c;
	}
	/**
	 * 设置：选项D
	 */
	public void setD(String d) {
		this.d = d;
	}
	/**
	 * 获取：选项D
	 */
	public String getD() {
		return d;
	}
	/**
	 * 设置：选项E
	 */
	public void setE(String e) {
		this.e = e;
	}
	/**
	 * 获取：选项E
	 */
	public String getE() {
		return e;
	}
	/**
	 * 设置：答案
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * 获取：答案
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * 设置：website_exercises表id
	 */
	public void setExeId(String exeId) {
		this.exeId = exeId;
	}
	/**
	 * 获取：website_exercises表id
	 */
	public String getExeId() {
		return exeId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
