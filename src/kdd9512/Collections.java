package kdd9512;

import java.util.ArrayList;

/**
 * 제네릭 Generic
 * 데이터 유형을 일반화(통일) 하는 것을 의미.
 * <p>
 * 여러 유형의 데이터를 사용하는 클래스의 경우,
 * 매개변수의 유형을 Object로 선언하는 경우,
 * 경우에 따라 원래 유형으로 변환해야 하는 번거로움이
 * 존재하고 오류가 발생할 가능성이 존재함.
 * - >
 */
public class Collections {
    public static void main(String[] args) {
        Object[] zoo = new Object[10];

        //동물원 동물에 우리를 배정
        //일반적으로 배열은 동일한 유형의 자료를 저장하는 자료구조이나,
        //배열의 유형을 위와 같이 Object로 선언한다면
        //그 제약이 사라지고 온갖 데이터를 한 배열에 넣을 수 있다.

        zoo[0] = new Tiger(); // 업캐스팅 적용
        zoo[1] = new Lion();
        zoo[2] = new Zebra();

        //우리에서 동물을 하나씩 빼냄
        //온갖 데이터를 집어 넣을 수 있다고는 하지만, 배열에 저장된 데이터를 빼낼때는
        //아래의 예시처럼 그 자료에 맞는 적절한 형변환을 요구한다.

        //Tiger t1 = zoo[0]; - > 에러발생. 다운캐스팅이 필요하다.(예제 OOPCasting 참고)
        Tiger t1 = (Tiger) zoo[0];

        //Lion l1 = zoo[0]; - > 다운캐스팅 필요함
        Lion l1 = (Lion) zoo[1];

        //Zebra z1 = zoo[0]; - > 다운캐스팅 필요함
        Zebra z1 = (Zebra) zoo[2];

        /*컬렉션 프레임워크
        다수의 데이터를 쉽고 효과적으로 처리할 수 있도록 표준화 방법을 제공하는 클래스
        데이터를 저장하는 자료구조와 처리하는 각종 알고리즘을 구조화하여 클래스로 구현해
        놓은것.

        종류 : 동적배열, 집합, 해시맵, 트리, 큐(Queue)
         */
        ArrayList zoo2 = new ArrayList();
        //컬렉션 프레임에서 제공하는 동적배열.
        //동적배열의 자료형은 기본적으로 Object
        //즉 위의 Object배열처럼 자료를 넣을때 자료형을 구분하지 않는다.

        zoo2.add(new Tiger());
        zoo2.add(new Lion());
        zoo2.add(new Zebra());
        //위의 업캐스팅처럼 번호를 지정 안해도 알아서 들어간다.
        t1 = (Tiger) zoo2.get(0);

        /*t1 = zoo2.get(0);
        l1 = zoo2.get(1);
        z1 = zoo2.get(2);
         동적배열 이용하여 데이타는 배열에 집어넣었으나,
            이전과 같이 형변환시 오류가 발생한다.*/

        //이 때, 제네릭을 이용하면 데이터의 타입을 통일시켜
        //컴파일시 타입체크 오류를 방지하고,
        //불필요한 형변환을 없앨 수 있음.
        //type-parameter ( < > ) 를 이용하여 자료구조의
        //데이터 유형을 미리 설정해 둘 수 있다.

        ArrayList<Tiger> zoo3 = new ArrayList<Tiger>(); //Tiger 를 제네릭으로 설정. 뒷쪽<> 내부의 Tiger는 지워도 됌.
        zoo3.add(new Tiger());
        zoo3.add(new Tiger());
        // zoo3.add(new Lion()); 설정한것은 Tiger 이므로 Lion 넣으려고 하면 에러가 발생함.

        t1 = zoo3.get(0);
        //자동으로 형변환 되므로, 오류 없이 처리할 수 있게 됌.

        ArrayList<Lion> zoo4 = new ArrayList<Lion>(); //Lion을 제네릭으로 설정.

        zoo4.add(new Lion());
        zoo4.add(new Lion());
        zoo4.add(new Lion());

        l1 = zoo4.get(0);


    }
}

class Tiger {
}

class Lion {
}

class Zebra {
}