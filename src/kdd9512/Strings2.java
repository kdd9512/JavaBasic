package kdd9512;


/**
 * 문자열 처리 시 유용한 기능을 제공하는 메서드.(DB다룰때 유용하게 사용할 수 있음.)
 */
public class Strings2 {
    public static void main(String[] args) {
        //문자열 길이 : length
        String str = "Hello, world!";
        System.out.println("문자열 길이 : " + str.length());

        //문자열 검색
        //indexOf : 지정한 문자 찾기.
        int idx = str.indexOf('w');
        System.out.println("문자 w의 위치 : " + idx);
        // 해당 문자가 존재하는 문자열에서 몇 번째에 존재하는지를 출력함.(왼쪽 기준.  - > 방향으로 검색)
        // java는 시작점이 0이므로 8번째에 위치한 글자(띄어쓰기포함)인 w는 7번 글자로 나온다.

        int idx2 = str.indexOf('?');
        System.out.println("문자 ? 의 위치 : " + idx2);
        //존재하지 않는 문자를 찾는다면?

        int idx3 = str.indexOf("Hello");
        System.out.println("문자열의 위치 : " + idx3);
        //문자열 찾기

        //lastIndexOf(문자) : 지정한 문자 찾기(오른쪽 기준.  < - 방향으로 검색), 위치값 출력.
        str = "Hello, Hi, Noon";
        idx = str.lastIndexOf('H');
        System.out.println("H의 위치 : " + idx);
        idx = str.lastIndexOf('n');
        System.out.println("n의 위치 : " + idx);

        //문자 바꾸기 : replace
        //replace(찾을 문자열 , 바꿀 문자열);
        str = "A*B*C*D";
        str = str.replace("*", "-");
        //바꾸는것 만으로는 결과가 나오지 않으니, str에 덮어씌우도록 str = 을 붙히고 replace문을 쓴다.
        System.out.println(str);


        // 문자열 분리 : split
        // 지정한 문자를 기준으로 문자열을 나눠 배열에 저장.
        // split(구분기호)
        str = "201350050,김태희,경기도,1985.3.22,컴퓨터,504";
        String[] result = str.split(",");// "," 를 기준으로 문장을 나누고 그 나눈 값을 각각 배열에 저장.
        /*for (int i = 0; i < result.length; ++i) {
            //result 는 배열이므로 배열의 길이만큼 (값이 가득찰 때 까지) 반복하게 끔 하는 for문 작성
            System.out.println(result[i]);*//*
        }*/
        for (String data : result) { // 향상된 for문....처음봤다.
            //향상된 for문을 사용하면 배열을 다루기가 한 층 더 수월해진다.
            System.out.println(data);


        }
        // 문자열 추출 : substring
        // substring(시작위치, 끝위치+1)
        str = "Hello, world!";
        String word = str.substring(7, 12);
        System.out.println(word);

        //ex) 주민번호에서 성별을 체크하는 코드 작성.
        //123456 - 1234567, 987654-4567890
        // 1,2 : 2000년 이전 남여 구분
        // 3,4 : 2000년 이후 남여 구분
        /*str = "123456-1234567";//주민번호 성별 1
        String gword = str.substring(7, 8);
        if (gword.equals("1") || gword.equals("3")) {
            System.out.println("성별 = 남성");
        }
        str = "987654-4567890";//주민번호 성별 4
        String gword2 = str.substring(7, 8);
        if (gword2.equals("2") || gword2.equals("4")) {
            System.out.println("성별 = 여성");
        }*/ //나의 답.
        // String jumin = "123456-1234567";
        String jumin = "987654-4567890";
        String gender = str.substring(7, 8);
        String result2 = "";
        switch (gender) {
            case "1":
                result2 = "2000 이전 남";
                break;
            case "2":
                result2 = "2000 이전 여";
                break;
            case "3":
                result2 = "2000 이후 남";
                break;
            case "4":
                result2 = "2000 이후 여";
                break;
        }
        System.out.println(result2);

        // 지정한 위치의 문자 추출 : charAt
        String str01 = "123456-1234567";
        System.out.println(str01.charAt(7));


        // 표현식에 따라 일치여부 확인 : matches
        //식 사용가능 메서드 : split, replaceAll
        int num = 1234567;
        String str1 = String.format("%,d", num);
        String str2 = "1234567";
        System.out.println(str1.matches(str2));

        str1 = String.format("%,d", num);
        System.out.println(str1.matches("[a-zA-z].+"));
        //matches 의 조건식은 a 부터 z 사이의 임의문자가 하나 이상 포함되어 있을 때
        System.out.println(str1.matches("[0-9].+"));
        //matches 의 조건식은 0 부터 9 사이의 임의문자가 하나 이상 포함되어 있을 떄

        //  표현식 regular expression
        // 특정한 규칙을 가진 문자열의 집합을 표현하기 위한 형식언어.
        // [?-?]    : 문자집합표현. - 는, 두 문자 사이의 범위를 나타낸다. ex) ([0123456789]) - > [0-9]
        // [0-9] : 숫자집합
        // [a-zA-Z] : 영문자집합
        // [가-힣] : 한글집합

        // * : 0이상 무한개의 임의문자를 반복
        // ab* : ab, aba, ab1, ....

        // + : 한 번 이상 무한개의 임의문자를 반복
        // ab+ : aba, ab1 abA, abaa, ....

        // ? : 0개 또는 1개의 임의 문자를 반복.
        // ab? : aba, abb, .... ab0, abZ, abz

        // {n , m} : 최소 n개 이상 m개 이하 반복.
        // [0-9]{3,4} : 123, 987, 1234, 9876

        // ^ : 문자열 시작
        // ^123 : 123으로 시작하는 문자열을 의미

        // $ : 문자열 끝
        // 123$ : 123으로 끝나는 문자열을 의미

        // . : 임의의 문자 한개를 의미
        // .{3, } : 문자의 최소길이는 3.

        //1234567890
        //abcdefghijklmnopqrstuvwxyz
        //가나다라마바사아자차카타파하

        //다음 문자열이 전화번호 형식에 맞게 작성되었는지
        //알아보는 정규식을 작성하세요
        //010-123-4567, 011-1234-5678
        String phone = "010-123-4567";
        String pattern1 = "[0-9]{3}-[0-9]{3,4}-[0-9]{4}";
        // 숫자가 3자리 "-" 숫자가 3~4자리까지 "-" 숫자가 4자리
        System.out.println("형식이 맞습니까? : " + phone.matches(pattern1));

        String phone1 = "011-1234-5678";
        System.out.println("형식이 맞습니까? : " + phone1.matches(pattern1));

        // ex) 사용자 아이디가 다음 규칙에 적합하게
        // 작성되어 있는지 확인
        // 영문자 소문자/대문자 하나씩, 숫자, 특수기호
        // abc123!XYZ, 123jkl
        String pattern2 = "[a-zA-Z0-9!]+";
        // 정규식 내용
        // - > 알파벳 대소문자, 숫자0~9, 특수문자 ! 중에 "하나"(= " + ")가 있습니까?

        String uid = "abc123!XYZ";
        System.out.println("형식이 맞습니까? : " + uid.matches(pattern2));
        String uid2 = "123jkl";
        System.out.println("형식이 맞습니까? : " + uid2.matches(pattern2));


        //첫글자는 영문자 소문자/ 대문자
        //두번째는 영문자, 숫자, 특수기호(!)등이 포함
        // 아이디의 길이는 6~18자
        // abc123!XYZ, 123jkl

        //String pattern3 = "[a-zA-Z]{1,6}[a-zA-Z0-9!]{2,18}"; 나의 답 (오답)

        String pattern3 = "^[a-zA-Z][a-zA-Z0-9!@#$]{5,17}";
        // 답. {6,18} 이 아니라 {5,17} 인 이유는, 맨 앞글자의 조건을 ^(문자열 시작)를 시작으로 이미 정해놓고 시작하기 때문.

        String uid3 = "a12345678901234567";
        // 맨 앞글자는 영문으로 시작하고, 글자개수가 총 18개로 위 정규식 조건에 부합한다. true
        System.out.println("형식이 맞습니까? : " + uid3.matches(pattern3));

        String uid4 = "123jkl";
        //글자개수rk 6개이고 조건에 맞는듯 하지만, 정규식에서 맨 첫글자를 영문이 나와야 함을 명시했으므로 false
        System.out.println("형식이 맞습니까? : " + uid4.matches(pattern3));

    }
}
