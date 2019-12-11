public class ResultTest {
    private String result;
    private Test test;

    public ResultTest(Test test,String res){
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
