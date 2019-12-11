public class ResultMes {
    private Integer packegeID;
    private Test resTest;

    public ResultMes( Test  test,Integer packegeID){
        this.packegeID = packegeID;
        this.resTest = test;
    }

    public Integer getPackegeID(){
        return packegeID;
    }

    public Test getResTest() {
        return resTest;
    }
}
