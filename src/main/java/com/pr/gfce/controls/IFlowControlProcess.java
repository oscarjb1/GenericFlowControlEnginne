package com.pr.gfce.controls;

import com.pr.gfce.exception.GeneralException;
import com.pr.gfce.exception.ValidateException;

/**
 * @author Oscar Blancarte
 */
public interface IFlowControlProcess {
    
    public Object process() throws ValidateException, GeneralException;
}