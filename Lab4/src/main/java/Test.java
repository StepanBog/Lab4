public class Test {
    private String testName;
    private String expResult;
    private int[] params;

    public Test(String testName,String expResult, int[] params){
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
