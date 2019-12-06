public class ResultMes {
    private Integer packegeID;
    private ResultTest resTest;

    public ResultMes(TestRes packegeID, Integer test){
        this.packegeID = packegeID;
        this.resTest = test;
    }

    public Integer getPackegeID(){
        return packegeID;
    }

    public ResultTest getResTest() {
        return resTest;
    }
}
