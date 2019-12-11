import com.fasterxml.jackson.annotation.JsonProperty;

public class Test {
    private String testName;
    private String expResult;
    private int[] params;

    public Test(@JsonProperty("testName")String testName,@JsonProperty("expectedResult") String expResult, @JsonProperty("params")int[] params){
        this.expResult = expResult;
        this.params = params;
        this.testName = testName;
    }

    public int[] getParams() {
        return params;
    }

    public String getExpResult() {
        return expResult;
    }

    public String getTestName() {
        return testName;
    }

}
