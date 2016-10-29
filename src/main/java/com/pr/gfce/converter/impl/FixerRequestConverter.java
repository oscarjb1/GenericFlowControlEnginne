package com.pr.gfce.converter.impl;

import com.pr.gfce.converter.IConverter;
import com.pr.gfce.exception.TransformException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Oscar Blancarte
 */
public class FixerRequestConverter implements IConverter<Map, Map>{

    @Override
    public Map converte(Map object) throws TransformException {
        String queryParam = "symbols="+object.get("base") + ","+object.get("contrapart");
        Map<String,String> response = new HashMap<>();
        response.put("header", null);
        response.put("queryParam", queryParam);
        response.put("body", null);
        response.put("accept", "application/json");
        return response;
    }
}
