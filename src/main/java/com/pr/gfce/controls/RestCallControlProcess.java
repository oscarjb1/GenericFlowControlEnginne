package com.pr.gfce.controls;

import com.pr.gfce.config.RestCall;
import com.pr.gfce.config.Step;
import com.pr.gfce.exception.GeneralException;
import com.pr.gfce.exception.ValidateException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author Oscar Blancarte
 */
public class RestCallControlProcess implements IFlowControlProcess {

    private RestCall restCall;
    private Map input;
    
    public static final String PARAM_QUERY_PARAM = "queryParam";
    public static final String PARAM_ACCEPT = "accept";
    public static final String PARAM_URL = "url";
    public static final String PARAM_METHOD = "method";
    public static final String PARAM_BODY = "body";
            
    public RestCallControlProcess() {
        
    }

    @Override
    public Object process() throws ValidateException, GeneralException {
        try {
            String urlParam = restCall.getUrl() != null ? restCall.getUrl() : String.valueOf(input.get("url"));
            URL url = new URL(urlParam + (input.get("queryParam")!=null?"?"+input.get("queryParam"):""));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String method = restCall.getMethod() != null ? restCall.getMethod() : String.valueOf(input.get("method"));
            conn.setRequestMethod(method.toUpperCase());
            conn.setRequestProperty("Accept", input.get("accept").toString());
            conn.setRequestProperty( "charset", "utf-8");
            conn.setRequestProperty("Acceptcharset", "utf-8");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            if(method.toUpperCase().equals("POST")){
                conn.setRequestProperty("Content-Length",String.valueOf(input.get(PARAM_BODY).toString().length()) );
                conn.setDoInput(true);
                conn.setDoOutput(true);
                try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
                    System.out.println(input.get(PARAM_BODY).toString());
                    wr.write( input.get(PARAM_BODY).toString().getBytes( StandardCharsets.UTF_8 ));
                }
            }
            
            System.out.println("Response code ==> " + conn.getResponseCode());
            
            

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String response = "";
            String output;
            while ((output = br.readLine()) != null) {
                response += output;
            }

            conn.disconnect();
            System.out.println("Response ==> " + response);
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            return response;
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new GeneralException(e.getMessage(),e);
        } 
    }

    @Override
    public void setContext(Object restCall) {
        this.restCall = (RestCall)restCall;
        
    }

    @Override
    public void setInput(Map input) {
        this.input = input;
    }

}
