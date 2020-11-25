package kdd9512;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
         */
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
        while (iter.hasNext()) {
            //iter.hasNext() : iter내에 더 읽어올 요소가 있는가를 확인한다( hasNext() )
            //이는 가능여부를 묻는것이므로 for문이 아니라 while 문을 써야 한다.

            System.out.println(iter.next());
            //iter.next() : iter내에 읽어올 요소가 남아 있다면 그 값을 가져온다( next() )
        }


    }
}
