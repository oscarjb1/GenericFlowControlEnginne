package com.pr.gfce.core.runtime;

import com.pr.gfce.config.FlowControl;
import com.pr.gfce.config.FlowControls;
import com.pr.gfce.controls.DefaultFlowControlProcess;
import com.pr.gfce.exception.GeneralException;
import com.pr.gfce.exception.InvalidFlowException;
import com.pr.gfce.exception.ValidateException;
import com.pr.gfce.util.FileUtil;
import com.pr.gfce.util.JsonConverter;
import com.pr.gfce.util.XMLConverter;
import java.io.InputStream;

/**
 *
 * @author Oscar Blancarte
 */
public class GenericControlEngineExecutor {

    private static GenericControlEngineExecutor ejecutor;
    private static final String CONFIG_FLOW_PATH = "META-INF/FlowControls.xml";
    private static FlowControls flows;
    
    private GenericControlEngineExecutor() {
        try {
            String config = FileUtil.loadResource(CONFIG_FLOW_PATH);
            flows = XMLConverter.toObject(config, FlowControls.class);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No fue posible validar la configuración");
            System.exit(0);
        }
    }
    
    
    public synchronized static GenericControlEngineExecutor getInstance(){
        if(ejecutor == null){
            ejecutor = new GenericControlEngineExecutor();
        }
        return ejecutor;
    }
    
    
    public String ejecute(String input)throws InvalidFlowException,ValidateException, GeneralException{
        String type = null;
        String root = null;
        if(input.startsWith("<")){
            type = "xml";
            root = XMLConverter.getRootNameElement(input);
        }else if(input.startsWith("{")){
            type="json";
            root = JsonConverter.getRootNameElement(input);
        }else{
            throw new ValidateException("Tipo de documento inválido");
        }
        
        System.out.println("root ==> " + root);
        System.out.println("type ==> " + type);
        
        for (FlowControl flow : flows.getFlowControl()) {
            if(flow.getInputType().toLowerCase().equals(type) && flow.getDiscriminator().equals(root)){
                System.out.println("Flow match ==> " + flow.getName());
                return new DefaultFlowControlProcess(flow,input).process().toString();
            }
        }
        throw new InvalidFlowException("Flow not match ==> ");
    }
}
