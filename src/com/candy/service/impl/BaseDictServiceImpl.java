package com.candy.service.impl;

import java.util.List;

import com.candy.dao.BaseDictDao;
import com.candy.domain.BaseDict;
import com.candy.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {
	private BaseDictDao bdd;
	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}
	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		return bdd.getListByTypeCode(dict_type_code);
	}

}
