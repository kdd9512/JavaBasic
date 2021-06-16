package kdd9512;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 스트림 stream
 * 데이터를 비트 등의 단위로 조각내어 일련의 연속성을
 * 갖도록 만든 데이터의 열
 * 일반적으로 스트림이라 하면 이러한 데이터의 열과
 * 이것을 활용하기 위해 사용하는 모듈을 합친 것을 말함.
 *
 * 이걸 왜 써야하나 - > if/for 문으로 구구절절 경읊듯 할 필요가 없어지므로
 * 코드가 매우 간결해지고 가독성이 향상되어 해독하기가 좋아진다.
 *
 * 스트림은 데이터를 읽고 쓰기 위한 공통된 방법을 제공.
 * 자바에서 스트림 처리방식은 모든 데이터를 바이트로 보는
 * 1.바이트 단위 스트림
 *   과 문자데이터 만을 위한
 * 2.문자 단위 스트림 등이 있음
 *
 * 문자 스트림을 다루는 클래스 : java.io 패키지에 포함
 * Reader / Writer - > FileReader / FileWriter
 */

public class FileReaderWriter {
    public static void main(String[] args)
            throws IOException {
        //이름 키 나이를 파일에 저장

        String name = "지현";
        int height = 175;
        int age = 30;

        // 파일에 기록
        // 데이터를 저장할 위치와 파일명 지정(임의).
        String fpath = "c:/Java/info.txt";

        //파일쓰기(문자 출력스트림) 객체 생성. ALT + ENTER 후 예외처리(첫번쨰 선택지).
        FileWriter fw = new FileWriter(fpath);

        // 파일에 내용 쓰기
        fw.write(name + "\n");
        fw.write(height + "\n");
        fw.write(age + "\n");

        // 파일쓰기 끝을 내고 작업 마무리.
        fw.close();

        /*
          파일에 저장된 데이터를화면에 출력하기 1
          한문자씩 읽어와서 출력
         */

        //읽어올 파일명과 위치 작성
        FileReader fr = new FileReader(fpath);

        /*
         * 파일로부터 문자 하나를 읽어 화면에 출력
         * 이러한 작업을 더 이상 읽을 문자가 없을 때 까지 반복
         * 아스키코드는 문자 하나에 할당된 숫자코드.
         */

        int ch = 0;
        while((ch = fr.read()) !=-1 ){
            //System.out.println(ch); 이건 아스키코드로만 나온다.
            System.out.println(ch + " / " + (char)ch);
        }
        // 파일읽기를 끝내고 작업을 마무리.
        fr.close();

        // 파일에 저장된 데이터를 화면에 출력하기 2
        // 한 행씩 읽어와서 출력
        // BufferedReader 를 이용하여 처리. 입력속도를 높일 수 있음.

        // FileReader 재생성하여 자료 fpath 호출.
        // **스트림은 재사용이 불가능하다**
        fr = new FileReader(fpath);
        BufferedReader br = new BufferedReader(fr); // 새 객체 : BufferReader 를 br로 선언.

        //읽어올 데이터의 유무 확인.
        while(br.ready()){//조건이 참인 경우
            // 한 행씩 읽어서 화면에 출력
            System.out.println(br.readLine());
        }

        // 파일읽기를 끝내고 작업을 마무리.
        // **닫을 때에는 실행 순서의 반대로 닫아야 한다**
        // 즉, BufferReader 부터 close(); 하고 그 다음 FileReader 를 close();
        br.close();
        fr.close();


    }
}
