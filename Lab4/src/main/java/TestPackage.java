import com.fasterxml.jackson.annotation.JsonProperty;
import scala.Int;

public class TestPackage {
    private Integer packageID;
    private String jsScript;
    private String funcName;
    private Test[] tests;

    public TestPackage(@JsonProperty"" Integer packageID, String jsScript, String funcName, Test[] tests){
       this.funcName = funcName;
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
