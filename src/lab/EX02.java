package lab;

public class EX02 {
    public static void main(String[] args) {
        //학생 클래스를 이용하여 객체 생성.
        Student kim = new Student();

        //학과 클래스를 이용하여 객체 생성.
        Subject com = new Subject();

        //과목 클래스를 이용하여 객체 생성.
        Major prog = new Major();

        //교수 클래스를 이용하여 객체 생성.
        Professor profLee = new Professor();

        //각 객체에 대해 변수 입력.
        //블록 선택 모드 ALT + 영역 드래그

        //학생
        kim.name = "김태희";
        kim.birth = "1985.3.22";
        kim.stNo = 201350050;
        //이 경우는 stNo을 int 값으로 잡는게 메모리를 덜 잡아먹음.
        kim.sbj = "컴퓨터";
        kim.prof = "504";


        //학과
        com.sbjName = "컴퓨터공학";
        com.sbjphone = "123-4567-8901";
        com.sbjlocate = "E동 2층";
        com.sjbhead = "504";

        //과목
        prog.majNo = "0205";
        prog.majName = "프로그래밍";
        prog.majIn = "자바 프로그래밍";
        prog.majProf = "301";

        //교수
        profLee.profNo = "301";
        profLee.profName = "이순신";
        profLee.profMaj = "프로그래밍";


        //객체에 저장된 값 출력.

        //학생 출력
        System.out.println("======학생 신상정보======");
        System.out.printf("\n이름 : %s\n\n생년 : %s\n\n학번 : %s\n\n학과 : %s\n\n교수 : %s\n\n",
                kim.name, kim.birth, kim.stNo, kim.sbj, kim.prof);
        //학과 출력
        System.out.printf("\n========학과 정보========\n\n학과명 : %s\n\n전화 : %s\n\n위치 : %s\n\n학과장 : %s\n",
                com.sbjName, com.sbjlocate, com.sbjphone, com.sjbhead);
        //과목 출력
        System.out.printf("\n=========과목 정보==========\n\n과목번호 : %s\n\n과목명 : %s\n\n개요 : %s\n\n담당교수 : %s\n",
                prog.majNo, prog.majName, prog.majIn, prog.majProf);
        //교수 출력
        System.out.printf("\n=========교수 정보=========\n\n교수번호 : %s\n\n이름 : %s\n\n전공 : %s\n",
                profLee.profNo, profLee.profName, profLee.profMaj);
        //출력종료
        System.out.println("\n=========출력 종료=========");

    }

}
