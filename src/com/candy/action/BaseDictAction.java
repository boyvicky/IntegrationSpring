package com.candy.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.candy.domain.BaseDict;
import com.candy.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport{
	
	private String dict_type_code;
	private BaseDictService baseDictService;
	
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

	@Override
	public String execute() throws Exception {

		
		//1. 调用service,根据typecode获取数据字典对象list
		List<BaseDict> list = baseDictService.getListByTypeCode(dict_type_code);
		//2. 将list转化为json格式
		String json = JSONArray.fromObject(list).toString();
		//3. 将json发送给浏览器
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		System.out.println(json);
		ServletActionContext.getResponse().getWriter().write(json);
		return null; //告诉struts2不需要进行结果处理
	}

	public String getDict_type_code() {
		return dict_type_code;
	}
	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
}
