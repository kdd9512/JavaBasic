package semiproject;

import java.io.*;

public class EmployeeV1ServExtend extends EmployeeV1Service {

    // 파일이 만들어질 경로 설정 및 FileR/W, BufferedReader 초기화
    private String path = "c:/Java/empserv.dat";
    private FileReader fr = null;
    private FileWriter fw = null;
    private BufferedReader br = null;

    public EmployeeV1ServExtend() {
        try {
            loadEmp();
        } catch (IOException e) {
            System.out.println("파일 불러오기 실패. 파일 경로 : " + path);
            e.printStackTrace();
        }
    }

    private BufferedWriter bw = null;

    public void displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------\n")
                .append("인사 관리 프로그램 v2\n")
                .append("-------------------\n")
                .append("1. 인사 데이터 입력\n")
                .append("2. 인사 데이터 조회\n")
                .append("3. 인사 데이터 상세조회\n")
                .append("4. 인사 데이터 수정\n")
                .append("5. 인사 데이터 삭제\n")
                .append("0. 프로그램 종료\n")
                .append("-------------------\n")
                .append("원하시는 작업은 ? [0,1,2,3,4,5] : ");

        System.out.print(sb);

    }
    // 자료 입력한걸 그대로 파일로 만들것이므로 newEmp 오버라이드 해서 여기서 기능 추가함.


    @Override
    public void inputNew() {
        super.inputNew();

        try {
            writeEmp(emp);
        } catch (IOException e) {
            System.out.println("파일 불러오기 중 오류 발생");
            e.printStackTrace();
        }
    }

    protected void writeEmp(EmployeeVO emp) throws IOException {
        String fmt = "%s,%s,%s,%s,%s,%s,%s,%d,%.1f,%d,%d"; //String.format용 양식 fmt


        // 자료를 입력하는 용도이므로 write 몽땅갖고온다.
        fw = new FileWriter(path, true);
        bw = new BufferedWriter(fw);


        String data = String.format(fmt, emp.getEmpno(), emp.getFname(), emp.getLname(), emp.getEmail(), emp.getPhone(),
                emp.getHdat(), emp.getJobid(), emp.getSal(), emp.getComm(), emp.getMgrid(), emp.getDeptid());

        bw.write(data);
        bw.newLine();

        bw.close();
        fw.close();
    }

    protected void loadEmp() throws IOException {

        //자료를 불러오는 용도니까 Reader 몽땅 갖고옴.
        fr = new FileReader(path);
        br = new BufferedReader(fr);

        //BufferedReader = br 을 읽을 수 있는가 없는가를 따진다. 읽을 수 있다면 true이므로 이하 실행.
        while (br.ready()) {
            String[] e = br.readLine().split(",");

            //String empno, String fname, String lname, String emali, String phone,
            //int hdat, String jobid, int sal, double comm, int mgrid, int deptid

            emp = new EmployeeVO(e[0], e[1], e[2], e[3], e[4],
                    e[5], e[6],
                    Integer.parseInt(e[7]),
                    Double.parseDouble(e[8]),
                    Integer.parseInt(e[9]),
                    Integer.parseInt(e[10]));

            empdata.add(emp);

        }
        br.close();
        fr.close();

    }

}

