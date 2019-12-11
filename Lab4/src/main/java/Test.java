import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Test {
    private String testName;
    private String expResult;
    private Object[] params;
    @JsonCreator
    public Test(@JsonProperty("testName")String testName,@JsonProperty("expectedResult") String expResult, @JsonProperty("params")Object[] params){
        this.expResult = expResult;
        this.params = params;
        this.testName = testName;
    }

    public Object[] getParams() {
        return params;
    }

    public String getExpResult() {
        return expResult;
    }

    public String getTestName() {
        return testName;
    }

}
