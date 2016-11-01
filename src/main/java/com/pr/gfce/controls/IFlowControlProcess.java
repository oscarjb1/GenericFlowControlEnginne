package com.pr.gfce.controls;

import com.pr.gfce.config.Step;
import com.pr.gfce.exception.GeneralException;
import com.pr.gfce.exception.ValidateException;
import java.util.Map;

/**
 * @author Oscar Blancarte
 */
public interface IFlowControlProcess {
    
    public Object process() throws ValidateException, GeneralException;
    
    public void setContext(Object context);
    public void setInput(Map input);
}