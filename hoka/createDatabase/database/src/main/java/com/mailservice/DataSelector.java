package com.mailservice;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class DataSelector {
	public Object getOld(List<Map<String, Object>> list){
		return list.get(0).get("idtes_table");
	}
}
