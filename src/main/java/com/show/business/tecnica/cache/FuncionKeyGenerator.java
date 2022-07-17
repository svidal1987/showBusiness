package com.show.business.tecnica.cache;

import java.lang.reflect.Method;


import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

@Component
public class FuncionKeyGenerator  implements KeyGenerator {
	@Override
	public Object generate(Object target, Method method, Object... params) {
		String key = "";
		for (Object object : params) {
			key = key +" -- "+ object.toString();
		}
		return key;
	}


}
