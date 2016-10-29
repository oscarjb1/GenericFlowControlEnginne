package com.pr.gfce.controls;

import com.pr.gfce.config.Converter;
import com.pr.gfce.config.FlowControl;
import com.pr.gfce.config.FlowControls;
import com.pr.gfce.config.Response;
import com.pr.gfce.config.RestCall;
import com.pr.gfce.converter.IConverter;
import com.pr.gfce.exception.GeneralException;
import com.pr.gfce.exception.ValidateException;
import java.util.HashMap;

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
            for(Object obj : flowControls.getConverterOrRestCallOrResponse()){
                if(obj instanceof Converter){
                    Converter flowConverter = (Converter)obj;
                    IConverter converter =(IConverter) Class.forName(flowConverter.getClazz()).newInstance();
                    Object response = converter.converte(getVar(flowConverter.getInputVar()));
                    setVar(flowConverter.getOutputVar(), response);
                }else if(obj instanceof RestCall){
                    RestCall restCall = (RestCall) obj;
                    Object response = new RestCallControlProcess(restCall,getVar(restCall.getInput())).process();
                    setVar(restCall.getOutput(), response);
                }else if(obj instanceof Response){
                    Response response = (Response)obj;
                    return vars.get(response.getResponseVar());
                }else{
                    throw new GeneralException("Activity not found");
                }
            }
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
}
