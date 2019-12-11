public class ResultMes {
    private String result;
    private Test Test;

    public ResultMes( Test  test,String result){
        this.result = result;
        this.Test = test;
    }

    public String getResult() {
        return result;
    }

    public Test getTest() {
        return Test;
    }
}
