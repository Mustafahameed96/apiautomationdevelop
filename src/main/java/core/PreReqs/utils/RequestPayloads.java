package core.PreReqs.utils;

public class RequestPayloads {
    public RequestPayloads(){}

    public static String createEmployee(){
        String req = "{\n" +
                "    \"name\": \"maaz\",\n" +
                "    \"salary\": \"10\",\n" +
                "    \"age\": \"25\"\n" +
                "}";
        return req;
    }

}
