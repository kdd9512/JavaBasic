package student;

public class Main {
    public static void main(String[] args) {
        Student stA = new Student("학생 A", 1, 5000);
        Student stb = new Student("학생 B", 2, 7500);
        Bus bus = new Bus(100, 1, 0);
        Subway sub = new Subway(3, 100, 0);


        //bus.earn(20000);// 클래스 내 변수값에 private 가 적용되었는지 확인하고자 쓴 코드.
                        // 만약 Bus 클래스 내의 변수값이 public 이었다면 earn 의 내용을 이 문구로 변경 가능했을 것이다.

        stA.takeBus(bus);
        stA.showInfo();
        bus.showInfo();
        stb.takeSub(sub);
        stb.showInfo();
        sub.showInfo();

    }

}
