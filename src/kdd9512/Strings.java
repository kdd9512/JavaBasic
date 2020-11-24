package kdd9512;

/**
 * String 클래스
 * C언어에서는 문자열을 char 배열로 표현
 * 자바에서는 별도로 String 클래스를 제공.
 * <p>
 * String 클래스의 객체는 한번 생성되면, 읽기만 가능하고
 * 이를 변경하는 것은 불가능한, 불변객체이다.
 * 따라서 + 연산자로 문자열을 결합하는 경우,
 * 기존의 문자열이 변경되는 것이 아니라 각각의 내용을 합쳐 새 객체가 형성된다.
 */
public class Strings {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "world!";

        str1 = str1 + str2;
        str1 = str1 + "abc";// 가능은 하나, 메모리 낭비가 심하다.

        // 이를 보완하기 위해 StringBuffer, StringBuilder 가 존재한다.
        StringBuffer sb = new StringBuffer();

        sb.append("Hell").append("World!!!").append("abc");
        System.out.println(sb);


        /*문자열 간 비교
        문자열 상수 풀이라는 개념을 이해할 필요가 있다.
        a 객체 생성 -> "Hello"를 SCP(상수풀) 에 저장.
        b 객체 생성 ->  SCP에 이미 동일값이 이미 존재하므로
                       저장된 값을 참조하도록 함. 이 작업이 있기에 메모리 절약이 가능한 것.
        c 객체 생성 ->  SCP가 아닌 다른 위치에 "Hello"를 새로 생성함.


        */
        String a = "Hello";
        String b = "Hello";
        String c = new String("Hello");

        // a와 b는 같은가? 또한 a와 c도 같을까?
        System.out.println(a == b); //a 와 b는 같다
        System.out.println(a == c); //a 와 c는 다르다.
        System.out.println(b == c); //b 와 c는 다르다.
        // 문자열 변수간 비교에서  == 연산자는
        // 수의 비교 때 와는 다르게 값 자체를 비교하는 것이 아니라,
        // 값이 저장된 메모리상의 위치를 비교하는 것임을 주의! ( 중요함 )

        // 따라서, 문자열간 값을 지교하고 싶다면,
        // equlas 메서드를 사용해야 함.
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(b.equals(c));
        // 값의 내용이 대소문자까지 완벽히 일치하므로 전부 true
        // a = b = c 라는 결과가 나온다.

    }
}
