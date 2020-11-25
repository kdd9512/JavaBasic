package kdd9512;

import java.util.HashSet;

public class Lotto45<lotto> {
    public static void main(String[] args) {
        HashSet<Integer> lotto = new HashSet<>();
        while (lotto.size() < 6) {
            lotto.add((int) (Math.random() * 45) + 1);
        }
        System.out.println("로또 번호 : " + lotto);
    }
}// 모든 전제조건 만족(중복값 불허, 6자리의 수 출력). 나의 답.

 /*
 1. set은 중복값을 저장 안함.
 2. while 은 소괄호 안 조건이 true가 될 때까지 무한 반복.
    즉, lotto의 사이즈가 0,1,2,3,4,5로 총 6자리가 될 때까지 무조건 뽑는다.
 3. 만약 중복값이 있다면 set은 중복값을 저장 안하니까 자동으로 짤리고
    자연스레 while문이 충족되지 않으니까 6자리 찰때까지 계속 반복.
 */


