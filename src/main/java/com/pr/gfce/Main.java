package com.pr.gfce;

import com.pr.gfce.core.runtime.GenericControlEngineExecutor;
import com.pr.gfce.exchange.json.JSONRequest;
import com.pr.gfce.exchange.json.Pair;
import com.pr.gfce.util.FileUtil;
import com.pr.gfce.util.JsonConverter;
import com.sun.org.glassfish.gmbal.util.GenericConstructor;

/**
 * @author Oscar Blancarte
 */
public class Main {
    public static void main(String[] args)throws Exception {
        GenericControlEngineExecutor executor = GenericControlEngineExecutor.getInstance();
        String input = FileUtil.loadResource("META-INF/XMLRequest.xml");
//        String input = FileUtil.loadResource("META-INF/JSONRequest.json");
//        String input = FileUtil.loadResource("META-INF/Invoice.xml");
        System.out.println("INPUT ==> ");
        System.out.println(input);
        
//        String json = JsonConverter.fromXML(input);
//        System.out.println("json ==> " + json);
        
        String response = executor.ejecute(input);
        System.out.println("RESPONSE ==> ");
        System.out.println(response);
    }
}
