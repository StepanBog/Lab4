import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import scala.Int;

public class TestPackage {
    private Integer packageID;
    private String jsScript;
    private String funcName;
    private Test[] tests;
    @JsonCreator
    public TestPackage(@JsonProperty("packageId")Integer packageID, @JsonProperty("jsScript")String jsScript,@JsonProperty("functionName") String funcName, @JsonProperty("tests")Test[] tests){
       this.packageID = packageID;
       this.jsScript = jsScript;
       this.funcName = funcName;
       this.tests = tests;
    }

    public Integer getPackageID() {
        return packageID;
    }

    public String getFuncName() {
        return funcName;
    }

    public String getJsScript() {
        return jsScript;
    }

    public Test[] getTests() {
        return tests;
    }
}
