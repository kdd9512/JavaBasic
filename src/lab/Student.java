package lab;

public class Student {
    //학생명 학과 과목 교수
    String name;
    String birth;
    int stNo;
    String sbj;
    String prof;

    public Student(){
        name = "김태희";
        birth = "1985.3.22";
        stNo = 201350050;
        sbj = "컴퓨터";
        prof = "504";
    }
    public Student(String name, String birth,int stNo,String sbj, String prof){
        this.name = name;
        this.birth = birth;
        this.stNo = stNo;
        this.sbj = sbj;
        this.prof = prof;
    }
// 이 구조 자체를 외워야 한다.
}
