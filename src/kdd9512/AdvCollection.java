package kdd9512;

import java.util.*;

public class AdvCollection {
    public static void main(String[] args) {
        /**Set : 집합
         * Set 인터페이스를 구현한 컬렉션 클래스
         * 요소의 저장순서가 유지 안됌.
         * 데이터를 중복으로 저장할 수 없음
         *
         * HashSet : 해쉬 알고리즘을 이용하여
         * 데이터를 저장하기 떄문에 검색속도가 빠름
         *
         * 일반적으로 저장된 자료의 양에 상관없이
         * 특정 데이터를 찾는데 걸리는 시간이 항상 일정할 순 없나?
         * - > 해쉬 알고리즘을 이용하면 가능하다
         **/
        Set<String> names = new HashSet<>();

        // 데이터 추가 : add()
        // 정렬순서는 현재 값이 한글이므로 가나다 순.

        names.add("혜교");
        names.add("지현");
        names.add("수지");
        names.add("지현");  //중복데이터 추가

        //데이터 모두 출력

        /*for (int i = 0; i < names.size(); ++i) {
            System.out.println(names.get(i));
        }//HashSet 에서는 get 사용불가.*/

        for (String name : names) {
            System.out.println(name);
        }// 중복저장이 허용되지 않기 때문에, 단 하나만 출력한다.

        // 컬렉션 데이터 순환 (iterate) 하기.
        // 컬렉션 프레임워크에 저장된 각 요소들을
        // 읽어오는 방법을 표준화한 것.
        // 단순히 값을 가져오고 싶을 때 쓰는 함수.


        Iterator<String> iter = names.iterator();
        // Iterator<데이터타입> 변수명 = 객체명.iterator();
        // 여기선< >에 String 을 썼으니, String 값 죄다 가져온다.
        // iterator는 OOP프로그래밍 에서 배열이나 그와 유사한 자료구조의 내부 요소를 순회하는 객체를 의미.


        while (iter.hasNext()) {
            //iter.hasNext() : iter내에 더 읽어올 요소가 있는가를 확인한다( hasNext() )
            //이는 가능여부를 묻는것 ( = boolean )이므로 for 문이 아니라
            // 작동에 T/F를 따지는 "while" 문을 써야 한다.

            System.out.println(iter.next());
            //iter.next() : iter내에 읽어올 요소가 남아 있다면 그 값을 가져온다( next() )
        }
        // 데이터 수정 : set - > 사용 불가. 이는 get도 마찬가지다.
        // names.set(0, "수현");
        // 따라서, 먼저  remove를 실행하여 값을 지운 뒤, 빈 자리에 add 함수로 값을 재삽입.
        // 혜교를 수현으로 바꿈.
        names.remove("혜교");
        names.add("수현");

        // hashset 에 다양한 유형의 값을 추가해 봄.
        names.add("apple");
        names.add("peach");
        names.add("berry");

        names.add("123");
        names.add("789");
        names.add("456");

        iter = names.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }// 값들의 순서가 이상하게 출력됌.
        // 이는 결과가 각 데이터의 고유 해시값에 의해 정렬되기 때문.

        // https://url.kr/IJ7jdR
        // sha256 hash코드 생성기.
        // sha (secure hash algorithm)
        // 256 : 256bit 길이의 코드 생성.

        // ex) 로또 6/45 프로그램 생성
        // 임의 숫자 6개를 생성하는 코드 생성(1~45)
        // 단, 중복은 허용하지 않음.

        // HashMap
        // 키와 값으로 저장하는 컬렉션 클래스
        // Map 인터페이스를 구현한 컬렉션 클래스
        // 키와 값을 하나의 쌍으로 저장하는 방식을 사용
        // 키는 실질적으로 값을 찾기 위한 방편으로 사용.
        // 요소의 저장순서는 유지되지 않음.
        // 키는 중복 데이터 저장 불가 (=키가 겹치면 안됌.)
        // ** 단, 값은 중복으로 저장할 수 있음.**

        // 해시 알고리즘을 사용하기 때문에,
        // 검색속도가 빠름.

        // 데이터 추가
        // 게임이름과 가격을 저장하는 해시맵을 생성
        Map<String, Integer> product = new HashMap<>();
        // 가격을 저장할 변수유형은 int 가 아닌 Integer 로 써야 한다.

        //데이터 추가 : .put(키, 값)
        // add 가 아니라 put을 쓴다.
        product.put("gameA", 50000);
        product.put("gameB", 70000);
        product.put("gameC", 65000);

        //값 조회 : get(키)
        System.out.println(product.get("gameA"));

        // 모든 키 확인 : keySet()
        // keySet의 리턴값은
        Set<String> keys = product.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
        // 모든 값 확인 : values
        // values 메서드의 리턴값.
        Collection<Integer> vals = product.values();

        for (Integer val : vals) {// 가져올 값은 int 값이므로 Integer 로 가져올 값의 종류를 결정해준다.
            System.out.println("가져온 값 : " + val);
        }

        Map<Integer, GameInfo> games = new HashMap<>();

        games.put(123, new GameInfo("gameA", 75000));
        games.put(234, new GameInfo("gameB", 65000));
        games.put(345, new GameInfo("gameC", 55000));

        // 키가 234인 게임의 정보 출력
        System.out.println(games.get(234).name);
        System.out.println(games.get(234).price);

        // GameInfo의 모든 게임정보 출력

        Set<Integer> keys2 = games.keySet();
        for (Integer key : keys2) {
            System.out.println("키가" + key + "인 게임정보");
            System.out.println(games.get(key).name);
            System.out.println(games.get(key).price);


            // 해시알고리즘

            // 해시함수 : 임의의 길이를 갖는 임의의 데이터에 대해
            // 고정된 길이의 데이터로 매핑하는 함수

            // 해시값 : 해시함수를 적용해서 나온 값(고정값).
            // 해시함수는 복잡한 알고리즘을 사용하지 않기 때문에
            // CPU 연산이 많이 필요하지 않음.
            // 같은 입력값에 대해서는 같은 해시값을 출력.
            // 단, 해시 함수의 알고리즘의 종류에 따라 값을 다르게 출력할 수 있음.
            // 간혹 서로 다른 데이터가 같은 해시값을 내는 경우가 발생하는데
            // 이럴 때는 충돌한다.

            // 대표적인 해시함수 : MD5, SHA256
            // 특정 단어 검색(레코드 검색),
            // 문서의 위조율(ex : 논문위조분석)측정(유사 레코드 비교),
            // 정보암호화 등에 사용할 수 있음.


        }


    }
}
