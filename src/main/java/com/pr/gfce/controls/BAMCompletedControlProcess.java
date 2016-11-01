package com.pr.gfce.controls;

import com.pr.gfce.config.Converter;
import com.pr.gfce.config.RestCall;
import com.pr.gfce.config.Step;
import com.pr.gfce.converter.IConverter;
import com.pr.gfce.exception.GeneralException;
import com.pr.gfce.exception.ValidateException;
import com.pr.gfce.step.IStep;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Oscar Blancarte
 */
public class BAMCompletedControlProcess implements IFlowControlProcess {

    private Step step;
    private Map input;

    public BAMCompletedControlProcess() {

    }

    @Override
    public Object process() throws ValidateException, GeneralException {
        try {
            Map<String, String> params = new HashMap<>();
            params.put(RestCallControlProcess.PARAM_ACCEPT, "application/json");
            params.put(RestCallControlProcess.PARAM_METHOD, "POST");
            params.put(RestCallControlProcess.PARAM_URL, "http://prbam.mybluemix.net/transactions");
            params.put(RestCallControlProcess.PARAM_BODY, "{ \"transactionId\": \"5a6d833a-b9f3-4296-a243-f3aa69b5b97e\", \"country\": \"Brazil\", \"version\": \"1.0.0\", \"errorDescription\": \"\", \"interface\": \"purchaseorder\", \"project\": \"Coupa\", \"status\": \"COMPLETED\", \"payload\": \"\" }");
            RestCallControlProcess process =  new RestCallControlProcess();
            process.setInput( params);
            process.setContext(new RestCall());
            return process.process();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setContext(Object step) {
        this.step = (Step)step;
    }

    @Override
    public void setInput(Map input) {
        this.input = input;
    }

}
