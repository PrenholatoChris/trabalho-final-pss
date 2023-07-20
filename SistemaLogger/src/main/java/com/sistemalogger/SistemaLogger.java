/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sistemalogger;


import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.config.Configurator;

/**
 *
 * @author chris
 */
public class SistemaLogger{
    private static final Logger logger =  LogManager.getLogger(SistemaLogger.class);
    
    public static final String jsonLog = "config-json";
    public static final String xmlLog = "config-xml";
    public static final String csvLog = "config-csv";
    

    public static void makeInfoLog(TipoOperacao operacao, String nome, String usuario){
        ThreadContext.put("operacao", operacao.getDescricao());
        ThreadContext.put("nome", nome);
        ThreadContext.put("usuario", usuario);
        logger.info("");
        ThreadContext.clearAll();
    }
    

    public static void makeErrorLog(TipoOperacao operacao, String nome, String usuario, Exception e){
        ThreadContext.put("operacao", operacao.getDescricao());
        ThreadContext.put("nome", nome);
        ThreadContext.put("usuario", usuario);
        logger.error(String.format("Ocorreu a falha %s ao realizar ",e.getMessage()));
        ThreadContext.clearAll();
    }
    
    public static void trocarLog(String configFolder){
        String url = "src/main/resources/"+configFolder+"/log4j2.xml";
        File file = new File(url);
        if (!file.exists() || file.isDirectory()) {
            System.out.println("Arquivo de configuração não encontrado: " + configFolder);
            return;
        }
        System.setProperty("log4j.configurationFile", url);
        Configurator.reconfigure();
    }
}

