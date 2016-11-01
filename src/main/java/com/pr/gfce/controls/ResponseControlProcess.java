package com.pr.gfce.controls;

import com.pr.gfce.config.Step;
import com.pr.gfce.converter.IConverter;
import com.pr.gfce.converter.impl.FirexResponseConverter;
import com.pr.gfce.exception.GeneralException;
import com.pr.gfce.exception.ValidateException;
import com.pr.gfce.exchange.fixer.FixerResponse;
import java.util.Map;

/**
 * @author Oscar Blancarte
 */
public class ResponseControlProcess implements IFlowControlProcess{

    private Map map;
    private Step step;
    
    @Override
    public Object process() throws ValidateException, GeneralException {
        try {
            FirexResponseConverter converter = new FirexResponseConverter();
            return converter.converte(map.get(step.getInputVar()).toString());
        } catch (Exception e) {
            throw new GeneralException(e.getMessage(),e);
        }
    }

    @Override
    public void setContext(Object context) {
        this.step = (Step)context;
    }

    @Override
    public void setInput(Map input) {
        this.map = input;
    }
    
}
