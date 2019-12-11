import java.util.List;

public class TestAnswer {
    private  Integer packageID;
    private  List<ResultTest> resultTests;
    public TestAnswer(Integer packageID, List<ResultTest> resultTests) {
        this.packageID = packageID;
        this.resultTests = resultTests;
    }

    public Integer getPackageID() {
        return packageID;
    }

    public List<ResultTest> getResultTests() {
        return resultTests;
    }
}
