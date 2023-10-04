package org.functions;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ApiCalls {
    public ApiCalls() {};

    public Map<String, List<String>> getApiCalls() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, List<String>> resultMap = objectMapper.readValue(new File("src/main/java/org/functions/json.json"), new TypeReference<Map<String, List<String>>>() {
        });
        return resultMap;
    }
    public ApiCalls parsingApiCalls() throws IOException {
        for(Map.Entry<String, List<String>> elements : getApiCalls().entrySet()){
            System.out.println(elements.getKey());
            System.out.println(elements.getValue());
            System.out.println("___");
        }
        return this;
    }


}

