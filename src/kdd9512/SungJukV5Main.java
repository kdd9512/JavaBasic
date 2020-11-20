package kdd9512;

public class SungJukV5Main {
    public static void main(String[] args) {
        SungJukService sjsrv = new SungJukService();
        //새로운 생성자를 생성(캡슐화)하여 Service에 있는 Scanner문을 끌어온다.
        //이하 공식은  SungJukVO kim = new SungJukVO("태희",99,98,99);와 같음
        //캡슐화로 간단히 아래문구만 써서 값을 끌어오게끔 하는 것.
        SungJukV0 sj = sjsrv.readSungJuk();

        //변수의 유효범위 scope
        //변수가 생성된 위치와 사용하는 위치가 다른 경우,
        //그 결과가 예상과 다를 수 있음.
        //변수의 유효범위는 블록이라 하고 {} 로 표현하는데,
        //기본자료형 변수 : call by value
        //참조자료형 변수 : call by reference
        sjsrv.computeSungJuk(sj);
        sjsrv.printSungJuk(sj);
    }

}
