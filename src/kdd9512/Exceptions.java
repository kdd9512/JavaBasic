package kdd9512;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions {
    /**
     * 예외 exceptions 와 오류 error
     * 자바프로그램 작성시 문법에 코드를 작성하면
     * 컴파일 오류가 발생한다.
     * 또한, 코드가 제대로 작성되었다 하더라도
     * 실행 중, 예상하지 못한 상황으로 인해 오류가 발생할 가능성도 있다.
     * 이처럼 프로그램 실행중에 예상치 못한 상황으로 프로그램이
     * 영향을 받는 것을 오류와 예외로 구분
     * <p>
     * 일반적으로 오류는 시스템 단계에서 프로그램에 심각한 문제를
     * 야기하여 실행중인 프로그램을 강제 중단시킴
     * -> 네트워크 상 접속오류, 메모리부족 등
     * 이러한 오류는 개발자가 처리할 수 없는 오류들임.
     * <p>
     * 반면, 예외 exception 는 오류와 마찬가지로 실행중인 프로그램을 중단시키나,
     * 발생할 수 있는 상황을 미리 예측하여 코드수정을 통해
     * 프로그램 실행 중단을 방지할 수 있음.
     */
    public static void main(String[] args) {
        // 예외처리전1
        System.out.println("프로그램 시작1");
        System.out.println("프로그램 끝1");

        // 예외처리전2
        System.out.println("프로그램 시작2");
        int a = 10, b = 20;
        int c = a + b;
        System.out.println(c);
        System.out.println("프로그램 끝2");

        // 예외처리전3
        /*System.out.println("프로그램 시작3");
        int d = 10, e = 0;
        int f = d / e; // 문법적으로는 전혀 하자가 없으나 에러 발생.
        System.out.println(f);// 위에서 에러가 발생하여 37,38,39번 줄은 실행이 안된다.
        System.out.println("프로그램 끝3"); // ArithmeticException 에러 발생. 0 으로 나누기를 실행시켜서 오류가 나는 것.*/

        // 예외처리 구문
        // try ~ catch ~ (exception) ~ finally
        // 예외처리전3
        System.out.println("프로그램 시작4");
        int d = 10, e = 0;
        int f = 0;
        try {
            f = d / e; // 오류가 발생하여 실행이 중단됌.
        } catch (Exception ex) {
            // 예외처리 핸들러
            System.out.println("오류발생");
            System.out.println(ex.getMessage()); // 예외처리된 동작의 이유를 볼 수 있음.

        }
        System.out.println(f);
        System.out.println("프로그램 끝4");

        // ex) 정수만 입력받아 화면에 출력하는 코드 작성.
        // 단, 예외처리코드 이용하여 문자를 입력해도
        // 프로그램 실행이 중단되지 않도록 할 것.
        // "정수만 입력가능."
        System.out.print("1~9 사이의 정수를 입력");
        Scanner sc = new Scanner(System.in);
        try {

            int aa = sc.nextInt();
            System.out.println(aa);
            // catch (Exception ex){}
        } catch (InputMismatchException ime) {
            System.out.println("범위를 벗어남.");
        }
        // 학생 3명의 이름을 입력받아 화면에 출력하는 코드를 작성.
        // 단, 학생이름을 저장할 배열과 예외처리를 이용할 것.
        String[] name = new String[3]; // 문자열 저장할 배열 생성.
        try {
            for (int i = 0; i <= name.length; ++i) {
                System.out.println("이름" + i + " 은?");
                name[i] = sc.next();
            }
        } catch (ArrayIndexOutOfBoundsException aiob) {
            System.out.println("배열크기 초과");
        }
        // 예외의 종류
        // 검사형 예외 : checked exception
        // 비검사형 예외 : unchecked exception

        // 비검사형 예외
        // 명시적인 예외처리를 강제하지 않음
        // 예외발생 확인 시점은 실행시.
        // ArithmeticException
        // ArrayIndexOutOfBoundsException
        // InputMismatchException

        // 검사형 예외
        // 명시적 예외처리를 강제함 (안하면 안넘어감)
        // 예외발생시 확인시점은 컴파일시점
        // IOException
        // ClassNotFoundException

        // ex SungJuk.dat 파일 읽어다가 화면에 출력.
        String fname = "c:/Java/sungjuk.dat";
        try {
            FileReader fr = new FileReader(fname);
            while (fr.ready()) {
                System.out.println((char) fr.read());
            }
            fr.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("성적파일은 c:/Java/sungjuk.dat 경로에 있어야 합니다");
        } catch (IOException ie) {
            System.out.println("파일읽기 오류발생");
        }

        // finally 블럭
        // 예외발생여부 관계없이, 무조건 출력되는 블럭.
        // finally 절에 작성.

        /*FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fname);
            br = new BufferedReader(fr);
            while (br.ready()) {
                System.out.println(br.readLine());
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException ioException) {
                }
            if (fr != null)
                try {
                    fr.close();
                } catch (IOException ie) {
                }
        }*/

        // try - with - resourde
        // JDK 7 부터는 데이터베이스를 이용하는 자바코등의 경우
        // 자원을 반납하는 코드가 작성되어야 하는데
        // try - with resource 구문을 이용하면
        // 명시적으로 반환하는 코드를 작성하지 않아도 됌.

        try (FileReader fr = new FileReader(fname);
            BufferedReader br = new BufferedReader(fr);){
            while (br.ready()){
                System.out.println(br.readLine());
            }
        }catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }catch (IOException ie){
            ie.printStackTrace();
        }


        try (FileWriter fw = new FileWriter(fname);
        BufferedWriter bw = new BufferedWriter(fw);) {
            bw.write("이 글부터 읽어라.");
        }catch (IOException ie){
            ie.printStackTrace();
        }

        // 예외회피 / 양도 / 떠넘기기
        // 메서드 선언부에 throws 를 사용해서
        // 해당 메서드에서 발생한 예외를 미리 명시하고
        // 메서드를 호출한 상위메서드에서 이를 처리하게끔 할 수 있음.
        // 이를 통해 각 하위메서들에서 발생하는 예외들을
        // 한곳에 모아서 처리가 가능.
        // 메서드 서명 throws 예외종류
        //


    }

}