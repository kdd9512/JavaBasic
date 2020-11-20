package student;

public class Student {
   private String name; //이름
   private int grade; //학년
   private int bgt; //가진돈

    public Student() {
    }

    public Student(String name, int grade, int bgt) {
        this.name = name;
        this.grade = grade;
        this.bgt = bgt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setBgt(int bgt) {
        this.bgt = bgt;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int getBgt() {
        return bgt;
    }
    public void takeBus(Bus bus){
        bus.take(1000);
        this.bgt -= 1000;//버스요금 1000원
    }
    public void takeSub(Subway sub){
        sub.take(1500);
        this.bgt -= 1500;//지하철요금 1500원
    }
    public void showInfo() {
        System.out.printf("\n학생명 : %2s, 학년 : %2d, 소지금 : %2d\n", name, grade, bgt);
    }
}
