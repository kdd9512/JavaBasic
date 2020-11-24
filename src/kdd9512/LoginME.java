package kdd9512;

import java.util.Scanner;

/**
 * 로그인 확인 프로그램.
 * 0. 인증용 id와 비밀번호랄 하나 생성
 * -> abc123 / 987xyz
 * 1. id, password를 입력받음.
 * 2a. 아이디와 비밀번호가 틀리면 "가입되지 않은 계정입니다"
 * 2b. 아이디만 맞으면 "비밀번호가 다릅니다"
 * 2c. 비밀번호가 맞으면 "로그인 합니다."
 */

public class LoginME {
    public static void main(String[] args) {
        String uid = "abc123";
        String upw = "987xyz";
        String id = "";
        String pw = "";

        while (true) {//로그인 될때까지 반복하게 해야 하므로 scan부터 다시 하게끔 while문을 스캐너 앞에 실행하게 써둔다.
            System.out.printf("\n====로그인 하십시오.====\n");
            Scanner sc = new Scanner((System.in));
            System.out.print("아이디 입력");
            id = sc.nextLine();
            System.out.print("비밀번호 입력");
            pw = sc.nextLine();

            if (!uid.equals(id) && !upw.equals(pw)) {
                System.out.println("등록되지 않은 계정입니다");
            } else if (uid.equals(id) && !upw.equals(pw)) {
                System.out.println("비밀번호가 틀립니다");
            } else if (!uid.equals(id) && upw.equals(pw)) {
                System.out.println("등록되지 않은 계정입니다");
            } else if (uid.equals(id) && upw.equals(pw)) {
                System.out.println("로그인 합니다...");
                break;
            }


        }

    }
}



