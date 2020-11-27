package kdd9512;

import java.io.*;

/**
 * 성적처리 추상클래스를 상속해서 만든 클래스
 */

public class SungJukV9Service extends SungJukV8Service { //기능은 V8에서 다 끌어오면 되므로 extends 를 이용.


    private String fpath = "c:/Java/sungjuk.dat";
    private FileReader fr = null;
    private FileWriter fw = null;
    private BufferedReader br = null;

    public SungJukV9Service() {
        // 프로그램 최초 시작 시, 파일에 저장된 모든 성적데이터를
        // List 타입의 sjdata변수에 저장.

        try { //오류가 발생했을 때, throw로 던져진 오류 상황을 여기서 처리한다. 예외처리 메서드.
            loadSungJuk();
        } catch (IOException e) {
            System.out.println("성적 데이터 읽는 중 오류 발생.");
            e.printStackTrace();
        }
    }

    private BufferedWriter bw = null;

    public void displayMenu() { //버전만 V9로 하고 싶으니 그 수정사항을 적용함
        StringBuilder sb = new StringBuilder();//화면 디자인 작성.
        sb.append("-------------------\n")
                .append("성적 처리프로그램 v9\n")
                .append("-------------------\n")
                .append("1. 성적 데이터 입력\n")
                .append("2. 성적 데이터 조회\n")
                .append("3. 성적 데이터 상세조회\n")
                .append("4. 성적 데이터 수정\n")
                .append("5. 성적 데이터 삭제\n")
                .append("0. 프로그램 종료\n")
                .append("-------------------\n")
                .append("원하시는 작업은 ? [0,1,2,3,4,5] : ");
        //StringBuilder를 이용하여 화면디자인.
        //이 형태를 기억해야 한다.
        System.out.print(sb);
        //출력은 sb만 하면 끝.
    }
    @Override
    public void newSungJuk() {

        // 성적데이터 입력받은 뒤
        // ArrayList 객체에 저장.
        super.newSungJuk();

        try { // ??????????????????
            writeSungJuk(sj);
        } catch (IOException e) {
            System.out.println("파일 쓰기 중 오류 발생.");
            e.printStackTrace();
        }

    }

    /**
     * writeSungJuk
     * 입력받은 성적데이터를 sungjuk.dat에 저장
     * 데이터입력을 담당하는 메서드 newSungJuk 에서 값을 받아오면 되므로 굳이 노출할 필요 없으므로
     * protected
     */

    protected void writeSungJuk(SungJukV0 sj) throws IOException {
        String fmt = "%s,%s,%s,%s,%s,%.1f,%s";

        // 파일 기록시 추가 append 기능을 활성화.
        fw = new FileWriter(fpath, true); // 값 누적을 위해 true 추가
        bw = new BufferedWriter(fw);

        String data = String.format(fmt, sj.getName(), sj.getKor(), sj.getMat(),
                sj.getEng(), sj.getSum(), sj.getMean(), sj.getGrd());
        //원하는 자료가 든 객체를 writeSungJuk 괄호 안에 쓰고 정의한 다음 fmt뒤에 순서대로 가져오면 된다.

        bw.newLine(); // 데이터를 입력하기 전 먼저 한줄 띄우게 함. 줄바꿈 메서드.
        bw.write(data);
        // FileWriter 클래스를 이용해서 파일에 데이터를 기록할 때 줄바꿈 등의 기능을 이용하려면
        // 이런식으로 한 줄 더 추가해야 하는 등, 다소 불편함.
        // - > PrintWriter 로 개선가능함.

        bw.close();
        fw.close();
    }

    /**
     * loadSungJuk
     * 파일에 저장된 성적데이터를
     * List타입의 sjdata에 저장.
     */
    protected void loadSungJuk() throws IOException {
        // throw IOException : 오류가 나면 이 메서드를 호출하고 있는 곳으로 상황을 전달한다.

        fr = new FileReader(fpath);
        br = new BufferedReader(fr);

        while(br.ready()){
            String[] s = br.readLine().split(",");//, 기준으로 데이터 쪼개기
            sj = new SungJukV0(s[0].trim(),
                    Integer.parseInt(s[1].trim()),
                    Integer.parseInt(s[2].trim()),
                    Integer.parseInt(s[3].trim()),
                    Integer.parseInt(s[4].trim()),
                    Double.parseDouble(s[5].trim()),
                    s[6].charAt(0));
            //지금 상태에서 그냥 읽으려면 에러뜸. 첫줄에 공백이 있기 떄문.
            //fpath 경로 가서 해당 파일 메모장으로 연 다음 맨 윗줄 공백 지워라.

            // 파일에서 읽어온 성적데이터 하나를
            // List변수 sjdata에 추가.
            sjdata.add(sj);

        }

        br.close();
        fr.close();
    }
}