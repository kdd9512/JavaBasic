package kdd9512;

import java.io.*;

//2차원 표형태의 데이터를 파일에 저장하기.
public class FileReaderWriter2 {
    public static void main(String[] args)
            throws IOException {
        // 학번, 이름, 주소, 생년월일, 학과명, 교수 등으로
        // 구성된 2차원 표 형태의 데이터를 student.dat 에 저장.

        // 학생 데이터 기본정보
        int hakbun = 201350050;
        String name = "김태희";
        String addr = "경기도 고양시";
        String birth = "1985.3.22";
        String dname = "컴퓨터";
        int prof = 504;

        // 학생 기본정보를 student.data 에 저장.
        String fpath = "c:/Java/student.dat";
        FileWriter fw = new FileWriter(fpath);

        // 기본정보를 저장할 형식 정의.
        // 각 항목들은 , 로 구분함.

        //출력 양식 fmt 생성.
        String fmt = "%s, %s, %s, %s, %s, %s\n";

        //출력양식을 이용하는 String.format()과 생성한 양식 fmt를 이용하여 데이터 순서에 맞게 입력.
        String data = String.format(fmt,hakbun,name,addr,birth,dname,prof);

        // fr에 data를 입력.
        fw.write(data);

        // 입력이 끝났으므로 FileWriter 닫기.
        fw.close();

        // 버퍼기능을 지원하는 Writer 사용하기.
        fw = new FileWriter(fpath);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(data);

        bw.close();
        fw.close();








        String sjnum = "0205";
        String sjname = "프로그래밍";
        String sjdesc = "자바 프로그래밍";
        int sjprof = 301;
        
        // FileWriter를 이용하여 데이터값을 저장할 경로를 지정할 String값 fpath2를 생성.
        String fpath2 = "C:/Java/subject.dat";
        
        // FileWriter 새로하나 작성. 경로 (fpath2) 에 새로하나 쓴다 이소리임.
        FileWriter fw2 = new FileWriter(fpath2);

        //String.format에 쓸 양식 생성.
        String fmt2 = "%s,%s,%s,%s";
        
        // String.format 이용하여 양식과 데이터값 입력. 이 객체를 subject로 선언.
        String subject = String.format(fmt2,sjnum,sjname,sjdesc,sjprof);
        
        // 위에서 만든 subject를 fw2에 집어넣음
        fw2.write(subject);
        
        // 작성 끝났으니 fw2는 닫아줌
        fw2.close();
        
        // BufferedWriter 이용하여 Writer 사용
        
        fw2 = new FileWriter(fpath2);
        BufferedWriter bw2 = new BufferedWriter(fw2);

        bw2.write(subject);

        bw2.close();
        fw2.close();

        // 과목 기본정보가 저장된 파일을 읽어서 출력하기.
        // 과목번호 :
        // 과목이름 :
        // ...

        FileReader fr = new FileReader(fpath2);
        BufferedReader br = new BufferedReader(fr);
        String fmt3 = "과목번호 : %s\n과목이름 : %s\n" +
                "과목개요 : %s\n담당교수 : %s\n";
        while(br.ready()){
            String line = br.readLine();
            // System.out.println(line);

            // 읽어온 데이터를 ,단위로 분리해서 배열변수에 저장.
            String[] items = line.split(","); // ","를 기준으로 데이터를 분할(split)한다.
            String result = String.format(fmt3,items[0],items[1],items[2],items[3]);
            // 교수가 int값이긴 한데 어차피 String.format에서 String값으로 출력하니까
            // BufferedReader 이하에 새로운 양식 생성하고 그 양식을 받아 출력하게 하면 된다.
            System.out.println(result);
        }

        br.close();
        fr.close();
    }
}
