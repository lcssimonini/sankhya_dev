package br.com.simonini.utils;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class SimoUtils {
	
	public static String getKeyByValue(Map<String, Integer> map, Integer value) {
	    String key = null;
		
	    for (Entry<String, Integer> entry : map.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            key =  entry.getKey();
	        }
	    }
	    return key;
	}
}
