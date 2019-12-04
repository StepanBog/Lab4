public class TestMes {
    private Integer packageID;
    private String jsScript;
    private String function;
    private Test test;

    public TestMes(Integer ID, String script,String func,Test test){
        packageID = ID;
        jsScript = script;
        function = func;
        this.test = test;
    }

    public Integer getPackageID() {
        return packageID;
    }
    public String getJsScript(){
        return  jsScript;
    }

    public String getFunction() {
        return function;
    }

    public Test getTest() {
        return test;
    }
}
