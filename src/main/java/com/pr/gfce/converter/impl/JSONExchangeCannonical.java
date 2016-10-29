package com.pr.gfce.converter.impl;

import com.pr.gfce.converter.IConverter;
import com.pr.gfce.exception.TransformException;
import com.pr.gfce.exchange.json.JSONRequest;
import com.pr.gfce.util.JsonConverter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Oscar Blancarte
 */
public class JSONExchangeCannonical implements IConverter<String, Map>{

    @Override
    public Map converte(String object) throws TransformException {
        JSONRequest request = JsonConverter.toObject(object, JSONRequest.class);
        Map<String, String> response = new HashMap<String,String>();
        response.put("base", request.getPair().getPrimarySimbol());
        response.put("contrapart", request.getPair().getSecundarySymbol());
        return response;
    }
    
}
