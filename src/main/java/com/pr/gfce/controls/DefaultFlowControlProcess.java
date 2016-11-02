package com.pr.gfce.controls;

import com.pr.gfce.config.Converter;
import com.pr.gfce.config.FlowControl;
import com.pr.gfce.config.FlowControls;
import com.pr.gfce.config.Response;
import com.pr.gfce.config.RestCall;
import com.pr.gfce.config.Step;
import com.pr.gfce.converter.IConverter;
import com.pr.gfce.exception.GeneralException;
import com.pr.gfce.exception.ValidateException;
import com.pr.gfce.step.IStep;
import com.pr.gfce.util.ReflectionUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Oscar Blancarte
 */
public class DefaultFlowControlProcess implements IFlowControlProcess{
    private HashMap<String, Object> vars = new HashMap<String, Object>();
    private FlowControl flowControls;
    
    public DefaultFlowControlProcess (FlowControl flowControl,Object input){
        this.flowControls = flowControl;
        vars.put("payload", input);
    }

    @Override
    public final Object process() throws ValidateException, GeneralException {
        try {
            if(flowControls.getCannonicalConverterClass()!=null){
                IConverter converter = (IConverter)Class.forName(flowControls.getCannonicalConverterClass()).newInstance();
                Object payload = converter.converte(vars.get("payload"));
                setVar("payload",payload);
            }
            
            Object returns = null;
            for(Object obj : flowControls.getConverterOrRestCallOrResponse()){
                if (obj instanceof Step){
                    Step step = (Step)obj;
                    IFlowControlProcess process = (IFlowControlProcess)Class.forName(step.getClazz()).newInstance();
                    Object response = process.process();
                    if(response!=null){
                        setVar(step.getName(), response);
                    }
                }else{
                    throw new GeneralException("Activity not found");
                }
            }
            return getVar("payload");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private Object getVar(String name)throws ValidateException{
        if(!vars.containsKey(name)){
            throw new ValidateException("No existe la variable " + name);
        }
        return vars.get(name);
    }
    
    private void setVar(String name,Object var)throws ValidateException{
        if(vars.containsKey(name)){
            System.out.println("Var update > " + name);
        }
        vars.put(name, var);
    }

    @Override
    public void setContext(Object step) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setInput(Map input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
