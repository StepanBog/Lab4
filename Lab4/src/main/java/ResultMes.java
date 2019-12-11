public class ResultMes {
    private Integer packageID;
    private ResultTest resTest;

    public ResultMes( ResultTest resTest, Integer packageID){
        this.packageID = packageID;
        this.resTest = resTest;
    }

    public Integer getPackageID() {
        return packageID;
    }

    public ResultTest getResTest() {
        return resTest;
    }
}
