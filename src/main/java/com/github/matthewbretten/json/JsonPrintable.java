package com.github.matthewbretten.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;

public interface JsonPrintable {
    default String toJson(){
        return toJson(false);
    }

    default String toJson(Class<?> jsonViewClass){
        return toJson(false, jsonViewClass);
    }

    default String toJson(boolean pretty){
        ObjectWriter writer = SystemObjectMapper.getInstance().writer();
        if(pretty){
            writer = writer.withDefaultPrettyPrinter();
        }
        try {
            return writer.writeValueAsString(this);
        } catch (JsonProcessingException e){
            return String.format("{error: \"%s.toString()\", message: \"%s.\"}",getClass().getName(), e.getMessage());
        }
    }

    default String toJson(boolean pretty, Class<?> jsonViewClass){
        ObjectWriter writer = SystemObjectMapper.getInstance().writerWithView(jsonViewClass);
        if(pretty){
            writer = writer.withDefaultPrettyPrinter();
        }
        try {
            return writer.writeValueAsString(this);
        } catch (JsonProcessingException e){
            return String.format("{error: \"%s.toString()\", message: \"%s.\"}",getClass().getName(), e.getMessage());
        }
    }
}