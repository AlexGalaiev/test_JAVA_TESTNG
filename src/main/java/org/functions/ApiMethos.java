package org.functions;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApiMethos {

    public ApiMethos() {
    }

    public static void main(String[] args) {} ;

    public List<String> getExpectedListOfResponse(String elementLocator ) throws IOException {
        List<List<String>> apiCallExpected = new ArrayList<>();
        for (Map.Entry<String, List<String>> elementToSearch : getElementsFromJson().entrySet()) {
            if (elementToSearch.getKey().equals(elementLocator)) {
               apiCallExpected.add(elementToSearch.getValue());
            }
        }
        List<String> innerList = new ArrayList<>();
        for(List<String> elementInnerList : apiCallExpected){
            for(String element: elementInnerList) {
                innerList.add(element);
            }
        }
        return innerList;
    };

    public String getSuccessMSGAfterRedirect(String elementLocator ) throws IOException {
        List<String> successMSG = null;
        for(Map.Entry<String, List<String>> elementToSearch : getElementsFromJson().entrySet()){
            if (elementToSearch.getKey().equals(elementLocator)){
                return "Link has responded with staus "+ elementToSearch.getValue().get(0) + " and status text " + elementToSearch.getValue().get(1);
            }
        }
        return null;
    }

    private Map<String, List<String>> getElementsFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, List<String>> resultMap = objectMapper.readValue(new File("src/main/java/org/functions/apicall.json"), new TypeReference<Map<String, List<String>>>() {
        });
        return resultMap;
    }




}

