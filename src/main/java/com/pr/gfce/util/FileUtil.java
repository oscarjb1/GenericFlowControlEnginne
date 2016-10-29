/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pr.gfce.util;

import com.pr.gfce.config.FlowControls;
import java.io.InputStream;

/**
 *
 * @author LENOVO
 */
public class FileUtil {
    public static String loadResource(String path){
        try {
            InputStream config = FileUtil.class.getClassLoader().getResourceAsStream(path);
            byte[] bytes = new byte[config.available()];
            config.read(bytes);
            return new String(bytes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
