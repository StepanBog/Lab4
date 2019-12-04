public class ResultTest {
    private String result;
    private Test test;

    public ResultTest(String res, Test test){
        result = res;
        this.test = test;
    }

    public Test getTest() {
        return test;
    }

    public String getResult() {
        return result;
    }
}
