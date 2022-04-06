/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author maindesktop
 */
public class Properties {
        public static java.util.Properties getConfigParameters() {
        java.util.Properties config = new java.util.Properties();
        try {
            InputStream myConfig = new FileInputStream(new File("config.properties")); //config file location
            config.load(myConfig); //load config
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }
}
