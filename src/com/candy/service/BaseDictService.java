package com.candy.service;

import java.util.List;

import com.candy.domain.BaseDict;

public interface BaseDictService {
	//根据数据字典类型获得数据字典对象
	List<BaseDict> getListByTypeCode(String dict_type_code);

}
