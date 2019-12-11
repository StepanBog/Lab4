public class TestMes {
    private Integer packageID;
    private String funcName;
    private  String jsScript;
    private Test test;
    public TestMes(Integer packageID, String funcName, String jsScript, Test test) {
        this.test = test;
        this.jsScript = jsScript;
        this.packageID = packageID;
        this.funcName = funcName;
    }
}
