package com.pr.gfce.controls;

import com.pr.gfce.config.RestCall;
import com.pr.gfce.exception.GeneralException;
import com.pr.gfce.exception.ValidateException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * @author Oscar Blancarte
 */
public class RestCallControlProcess implements IFlowControlProcess {

    private RestCall restCall;
    private Map input;

    public RestCallControlProcess(RestCall restCall, Object input) {
        this.restCall = restCall;
        this.input = (Map)input;
    }

    @Override
    public Object process() throws ValidateException, GeneralException {
        try {
            URL url = new URL(restCall.getUrl() + (input.get("queryParam")!=null?"?"+input.get("queryParam"):""));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(restCall.getMethod().toUpperCase());
            conn.setRequestProperty("Accept", input.get("accept").toString());

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String response = "";
            String output;
            while ((output = br.readLine()) != null) {
                response += output;
            }

            conn.disconnect();
            return response;
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new GeneralException(e.getMessage(),e);
        } 
    }

}
