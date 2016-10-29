package com.pr.gfce.converter.impl;

import com.pr.gfce.converter.IConverter;
import com.pr.gfce.exception.TransformException;
import com.pr.gfce.exchange.xml.CurrenciRequest;
import com.pr.gfce.util.XMLConverter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Oscar Blancarte
 */
public class XMLExchangeCannonical implements IConverter<String, Map>{

    @Override
    public Map converte(String object)throws TransformException {
        CurrenciRequest request = XMLConverter.toObject(object, CurrenciRequest.class);
        Map<String,String> response = new HashMap<String, String>();
        response.put("base", request.getPrimarySimbol());
        response.put("contrapart", request.getSecundarySimbol());
        return response;
    }
    
}
