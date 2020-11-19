package lab;

public class EX01 {
    public static void main(String[] args) {
        //학생 클래스를 이용하여 객체 생성.
        Student kim = new Student();
        //생성자 초기값 데이터(기본생성자)가 김태희 에 관한 정보이므로 공란으로 둔다.
        Student song = new Student("송혜교","1988.9.17",201250006,"컴퓨터","504");
        Student jun = new Student("전지현","1986.4.30",201252110,"의상디자인","445");
        Student soo = new Student("수지","1988.7.13",201351010,"식품영양","556");
        Student aiy = new Student("아이유","1987.2.25",201353011,"철학","504");
        //변수 값만 입력하면 자동으로 이전에 일일히 다 적었던 대로 만들어진다.
        //변수 값 순서를 모르겠다면 ""로 일단 답하고 , 찍고 넘어가면 순서가 나오니 참고.


        //학과 클래스를 이용하여 객체 생성.
        Subject com = new Subject();

        //과목 클래스를 이용하여 객체 생성.
        Major prog = new Major();

        //교수 클래스를 이용하여 객체 생성.
        Professor profLee = new Professor();

        //각 객체에 대해 변수 입력.
        //블록 선택 모드 ALT + 영역 드래그

        //객체에 저장된 값 출력.
        System.out.println("======학생 신상정보======");
        System.out.printf("\n이름 : %s\n\n생년 : %s\n\n학번 : %s\n\n학과 : %s\n\n교수 : %s\n\n===========================\n",
                kim.name, kim.birth, kim.stNo, kim.sbj, kim.prof);
        System.out.printf("\n이름 : %s\n\n생년 : %s\n\n학번 : %s\n\n학과 : %s\n\n교수 : %s\n\n===========================\n",
                song.name, song.birth, song.stNo, song.sbj, song.prof);
        System.out.printf("\n이름 : %s\n\n생년 : %s\n\n학번 : %s\n\n학과 : %s\n\n교수 : %s\n\n===========================\n",
                jun.name, jun.birth, jun.stNo, jun.sbj, jun.prof);
        System.out.printf("\n이름 : %s\n\n생년 : %s\n\n학번 : %s\n\n학과 : %s\n\n교수 : %s\n\n===========================\n",
                soo.name, soo.birth, soo.stNo, soo.sbj, soo.prof);
        System.out.printf("\n이름 : %s\n\n생년 : %s\n\n학번 : %s\n\n학과 : %s\n\n교수 : %s\n\n===========================\n",
                aiy.name, aiy.birth, aiy.stNo, aiy.sbj, aiy.prof);
        System.out.printf("\n========학과 정보========\n\n학과명 : %s\n\n전화 : %s\n\n위치 : %s\n\n학과장 : %s\n",
                com.sbjName, com.sbjLocate, com.sbjPhone, com.sbjHead);
        System.out.printf("\n=========과목 정보==========\n\n과목번호 : %s\n\n과목명 : %s\n\n개요 : %s\n\n담당교수 : %s\n",
                prog.majNo, prog.majName, prog.majIn, prog.majProf);
        System.out.printf("\n=========교수 정보=========\n\n교수번호 : %s\n\n이름 : %s\n\n전공 : %s\n",
                profLee.profNo, profLee.profName, profLee.profMaj);

        System.out.println("\n=========출력 종료=========");

    }

}
