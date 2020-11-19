package lab;

public class EX01 {
    public static void main(String[] args) {
        //학생 클래스를 이용하여 객체 생성.
        //학과 클래스를 이용하여 객체 생성.
        //과목 클래스를 이용하여 객체 생성.
        //교수 클래스를 이용하여 객체 생성.
        Student kim = new Student();
        Student song = new Student();
        Student jun = new Student();
        Student soo = new Student();
        Student aiy = new Student();

        Subject com = new Subject();
        Major prog = new Major();
        Professor lee = new Professor();

        //각 객체에 대해 변수.
        //블록 선택 모드 ALT + 영역 드래그

        kim.name = "김태희";
        kim.birth = "1985.3.22";
        kim.stNum = "201350050";
        kim.sbj = "컴퓨터";
        kim.prof = "504";

        song.name = "송혜교";
        song.birth = "1988.9.17";
        song.stNum = "201250006";
        song.sbj = "컴퓨터";
        song.prof = "301";

        jun.name = "전지현";
        jun.birth = "1986.4.30";
        jun.stNum = "201252110";
        jun.sbj = "의상디자인";
        jun.prof = "445";

        soo.name = "수지";
        soo.birth = "1988.7.13";
        soo.stNum = "201351010";
        soo.sbj = "식품영양";
        soo.prof = "556";

        aiy.name = "아이유";
        aiy.birth = "1987.2.25";
        aiy.stNum = "201353011";
        aiy.sbj = "철학";
        aiy.prof = "504";

        com.sbjName = "컴퓨터공학";
        com.sbjphone = "123-4567-8901";
        com.sbjlocate = "E동 2층";
        com.sjbhead = "504";

        prog.majNum = "0205";
        prog.majName = "프로그래밍";
        prog.majIn = "자바 프로그래밍";
        prog.majProf = "301";

        lee.profNum = "301";
        lee.profName = "이순신";
        lee.profMaj = "프로그래밍";


        //객체에 저장된 값 출력.
        System.out.println("======학생 신상정보======");
        System.out.printf("\n이름 : %s\n\n생년 : %s\n\n학번 : %s\n\n학과 : %s\n\n교수 : %s\n\n===========================\n",
                kim.name, kim.birth, kim.stNum, kim.sbj, kim.prof);
        System.out.printf("\n이름 : %s\n\n생년 : %s\n\n학번 : %s\n\n학과 : %s\n\n교수 : %s\n\n===========================\n",
                song.name, song.birth, song.stNum, song.sbj, song.prof);
        System.out.printf("\n이름 : %s\n\n생년 : %s\n\n학번 : %s\n\n학과 : %s\n\n교수 : %s\n\n===========================\n",
                jun.name, jun.birth, jun.stNum, jun.sbj, jun.prof);
        System.out.printf("\n이름 : %s\n\n생년 : %s\n\n학번 : %s\n\n학과 : %s\n\n교수 : %s\n\n===========================\n",
                soo.name, soo.birth, soo.stNum, soo.sbj, soo.prof);
        System.out.printf("\n이름 : %s\n\n생년 : %s\n\n학번 : %s\n\n학과 : %s\n\n교수 : %s\n\n===========================\n",
                aiy.name, aiy.birth, aiy.stNum, aiy.sbj, aiy.prof);
        System.out.printf("\n학과명 : %s\n\n전화 : %s\n\n위치 : %s\n\n학과장 : %s\n\n===========================\n",
                com.sbjName, com.sbjlocate, com.sbjphone, com.sjbhead);
        System.out.printf("\n과목번호 : %s\n\n과목명 : %s\n\n개요 : %s\n\n담당교수 : %s\n\n===========================\n",
                prog.majNum, prog.majName, prog.majIn, prog.majProf);
        System.out.printf("\n교수번호 : %s\n\n이름 : %s\n\n전공 : %s\n\n===========================\n",
                lee.profNum, lee.profName, lee.profMaj);

    }

}
