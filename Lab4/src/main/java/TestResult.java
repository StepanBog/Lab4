public class TestResult {
    private String result;
    private Test Test;

    public TestResult( Test  test,String result){
        this.result = result;
        this.Test = test;
    }

    public String getResult() {
        return result;
    }

    public Test getResTest() {
        return Test;
    }
}
