package com.java.util.map;

import com.java.util.log.MyLogger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by chad on 2019/3/7.
 */

public class MapUtil {
    private static final MyLogger myLogger = MyLogger.getLogger(MapUtil.class);

    public static void main(String args[]) {

        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);

        myLogger.info("-----------分割线----------------");

        Iterator<Map.Entry<String, Integer>> entries = map.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry<String, Integer> entry = entries.next();
            if ("three".equals(entry.getKey())){//删除three的key对应的value
                entries.remove();
            }
            myLogger.info("T entrySet" + "key is:" + entry.getKey() + "; value is:" + entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            myLogger.info("entrySet" + "key is:" + key + "; value is:" + value);
        }


        for (String s : map.keySet()){//只获取key
            myLogger.info("key is:" + s);
        }

        for (Integer i : map.values()){//只获取values
            myLogger.info("value is:" + i);
        }
    }
}
