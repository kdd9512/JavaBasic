package lab;

public class Major {
    String majNo;
    String majName;
    String majIn;
    String majProf;

    public Major() {
        majNo = "0205";
        majName = "프로그래밍";
        majIn = "자바 프로그래밍";
        majProf = "3";
    }
    public Major(String majNo, String majName, String majIn, String majProf){
        this.majNo = majNo;
        this.majName = majName;
        this.majIn = majIn;
        this.majProf = majProf;
    }

}
