package kdd9512;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ArrayList
 * 동적배열의 한 종류
 * List 인터페이스를 구현해서 만든 컬렉션 프레임워크
 * 요소의 저장순서가 유지
 * <p>
 * 장 : 중복으로 데이터를 저장할 수 있다는 장점이 있음.
 * <p>
 * 단 : 크기가 늘어나면 새로운 배열을 생성하고
 * 기존의 요소들을 옮겨야하는 복잡한 과정이 동반된다는 단점이 있음.
 */
public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        // 데이터 추가 : ArrayList이름 . add(대상); 이 순서대로 값이 삽입된다.
        // 기존값이 있다면 기존값의 가장 마지막 값부터 순서대로 삽입됌.
        names.add("혜교");
        names.add("지현");
        names.add("수지");


        //지정한 위치에 데이터를 추가하고 싶다면, add(위치, 대상)
        names.add(0, "수현");

        //요소 추출 : get(위치)
        System.out.println("요소 추출 : " + names.get(1));

        //요소 수정 : set(위치, 대상)
        names.set(1, "윤아");

        //요소 삭제 : remove(위치)
        names.remove(1);
        System.out.println("요소 삭제 : " + names.get(1));

        // 컬렉션 자료구조에 저장된 데이터를
        // 출력하려면 foreach 구문을 사용한다. (=향상된 for문)
        for (String name : names) {// 형태를 기억해 둘 것.
            System.out.println(name);
        }

        //요소 전체 삭제 : clear()

        //데이터 검색하기
        //배열에서 원하는 데이터를 찾는 방법은 2가지
        //위치로 찾음 : get(위치)
        //실제값으로 찾음 : contains, indexOf

        String[] game = {"gameA", "gameB", "gameC"};

        // ArrayList<String> games = (ArrayList<String>) Arrays.asList(game);
        // 다운캐스팅 형변환 예시. 문법적으로는 오류가 없으나 실행하면 다운캐스팅 에러 발생.
        // - > 쓰지마라

        List<String> games = Arrays.asList(game);
        //일반배열을 동적배열로 변환하려면
        //Arrays 클래스의 asList 메서드를 사용한다.

        System.out.println(games);

        //games 동적배열에서 gameA 를 찾기
        //전체를 시작점부터 쭉 뒤지는 것이기 떄문에 이 방법은 효율이 매우 나쁘다.
        //만약 찾고자 하는 값이 엄청나게 긴 배열 맨 마지막에 있다면 그 배열 전체를 다 뒤져야 하므로.
        for (int i = 0; i < games.size(); ++i) {
            if (games.get(i).equals("gameA")) {
                //그냥 양 쪽을 == 로 비교하면 될 것같지만 가져오려는 값이 String 이므로 .equals() 를 이용해야 한다.
                System.out.println((i + 1) + "번 째에서 발견");
                break;//찾으면 더 이상 검색 할 필요가 없으므로 break
            }
        }//위치 기반 검색

        for (String g : games) {
            //데이터의 존재여부만을 필요로 한다면, 향상된 for문으로 작성하는게 더 짧고 좋다.
            if (g.equals("gameA")) {
                System.out.println("데이터 발견");
                break;
            }
        }//값 기반 검색

        if (games.contains("gameC")) {//위의 향상된 for문을 축약시킨 코드.
            System.out.println("데이터 찾음");
        } // for문 단축. 값 기반 검색.

        System.out.println(games.indexOf("gameB"));
        // 몇번 배열에 위치하고 있는지를 알 수 있는 코드. 위치 기반 검색.

        GameInfo g1 = new GameInfo("gameA", 35000);
        GameInfo g2 = new GameInfo("gameB", 45000);
        GameInfo g3 = new GameInfo("gameC", 55000);
        //인스턴스 생성.

        //동적배열에 인스턴스들 저장. 작성양식에 주목.
        List<GameInfo> games2 = new ArrayList<>();
        games2.add(g1);
        games2.add(g2);
        games2.add(g3);

        //gameC 요소를 출력. - > 값이 아닌 주소가 나온다 kdd9512.GameInfo@1b6d3586
        //ArrayList의 요소가 GameInfo의 객체이므로
        //실제 값이 아닌 GameInfo 객체의 주소가 저장되는 것.
        System.out.println(games2.get(2));

        //따라서, 객체의 실제값을 출력하려면
        //대상.변수명  또는 대상.getter 를 이용해야 함.
        System.out.println(games2.get(2).name);
        System.out.println(games2.get(2).price);

        // 특정 요소를 검색하는 코드를 4가지 방법으로 작성.
        // for, foreach, contains, indexOf
        for (int i = 0; i < games2.size(); ++i) {
            if (games2.get(i).name.equals("gameB")) {
                //game2 가 객채라 그냥으론 값을 못받고 찾는 그 특정값에 맞게 조정해야 함.
                System.out.println((i + 1) + "번 째에서 발견");
                break;
            }
        }//for

        for (GameInfo g : games2) {
            if (g.name.equals("gameB")) {
                System.out.println("데이터가 존재합니다1");
                break;
            }
        }//foreach

       /* if (games2.contains("gameB")) {// 역시 games2 가 객체라 작동을 안함.
            System.out.println("데이터가 존재합니다");
        }*/
        for (GameInfo g : games2) {
            if (g.name.contains("gameB")) {
                System.out.println("데이터가 존재합니다2");
                break;
            }
        }//contains

        for (GameInfo g : games2) {
            if (g.name.indexOf("gameB") >= 0) {
                //indexOf로 값을 찾고 그 값이 존재하는가(0보다 크거나 같다) 를 조건으로 걸어야 함.
                // 값이 참/거짓 이 되어야 하기 때문.
                System.out.println("데이터가 존재합니다3");
                break;
            }
        }
        //indexOf


    }

}

class GameInfo {
    String name;
    int price;

    public GameInfo(String name, int price) {//매개변수 이용하는 생성자.
        this.name = name;
        this.price = price;
    }
}
