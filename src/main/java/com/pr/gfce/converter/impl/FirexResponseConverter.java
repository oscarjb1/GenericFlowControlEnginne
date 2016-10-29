package com.pr.gfce.converter.impl;

import com.pr.gfce.converter.IConverter;
import com.pr.gfce.exception.TransformException;
import com.pr.gfce.exchange.fixer.FixerResponse;
import com.pr.gfce.exchange.json.JSONRequest;
import com.pr.gfce.exchange.json.Pair;
import com.pr.gfce.util.JsonConverter;
import java.util.Set;

/**
 * @author Oscar Blancarte
 */
public class FirexResponseConverter implements IConverter<String, String> {

    @Override
    public String converte(String object) throws TransformException {
        FixerResponse input = JsonConverter.toObject(object, FixerResponse.class);
        JSONRequest output = new JSONRequest();
        output.setPair(new Pair());
        Pair p = output.getPair();
        Set<String> set = input.getRates().keySet();
        
        boolean first = true;
        for(String key : set){
            if(first){
                p.setPrimarySimbol(input.getRates().get(key));
                first = false;
            }else{
                p.setSecundarySymbol(input.getRates().get(key));
            }
        }
        
        return JsonConverter.toJson(output,true);
    }
    
}
