public class ResultMes {
    private Integer packegeID;
    private ResultTest resTest;

    public ResultMes(Integer packegeID, String result, Test test){
        this.packegeID = packegeID;
        this.result = result;
        this.test = test;
    }
}
