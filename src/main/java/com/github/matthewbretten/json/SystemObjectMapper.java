package com.github.matthewbretten.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;

import java.util.SimpleTimeZone;

public final class SystemObjectMapper{
    private static ObjectMapper instance = null;

    private SystemObjectMapper(){}

    public static synchronized ObjectMapper getInstance(){
        if (instance == null) {
            instance = new ObjectMapper();
        }
        return instance;
    }
}