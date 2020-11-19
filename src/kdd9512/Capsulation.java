package kdd9512;

/**캡슐화
 * 클래스와 멤버변수 선언시 정보의 은닉정도를 부여함.
 *
 * 정보은닉 : 사용자가 굳이 알 필요 없는 정보는
 * 사용자로부터 숨겨야 한다는 개념.
 *
 * 최소한의 정보만 제공하여 보안 및 파일의 기능을 유지.
 *
 * 자바에서 지원하는 4가지 접근 제한자.
 *      public -> default -> protected -> private
 * 보안    저 ------------------------------>고
 *
 */
public class Capsulation {
    public static void main(String[] args) {
       Person2 p = new Person2();

       //p.name = "홍길동";
       //캡슐화를 적용하지 않은 코딩. (부적절함)
       //private 선언된 멤버변수는
       //객체명. 변수명으로 접근할 수 없기 때문에
        //읽어서 출력할 수 없음.

        p.setName("홍길동");
        // name 이라는 멤버변수에 값을 대입하려면
        // setter 메서드를 이용하여 권한을 받아야 한다.
        // 생성자명.setXxx(담을 값);
        // Xxx에는 변수명 입력.

        System.out.println(p.getName());
        // getter 메서드로
        // name 에 담긴 값인 홍길동을 return하여 출력한 것이다.

    }
}
class Person2 {
    // 멤버변수 선언시 캡슐화를 적용하려면
    // 접근제한자를 private로 쓴다.
    // private class Person2{}
    private String name;
    private String job;
    private int age;
    private String gender;
    private String blood;

    //기본 생성자

    /**
     * setter/getter : (private 열람권한 부여하는 메서드)
     * setter
     * public setXxx(매개변수) {
     *  this.변수 = 매개변수;
     * }
     *  public 반환값 getXxx(){
     *    return 변수;
     *  }
    */
    //setter 메서드
    public void setName(String name){
        this.name = name;
    }
    //getter 메서드
    public String getName(){
        return name;
    }
    // 이를 JavaBeans 라고 한다.
    // 식별가능하며 재사용성이 높은 소프트웨어를 만들기 위한 기본 규칙이다.
    // 1. 멤버변수는 반드시 private으로 선언
    // 2. 기본생성자가 있어야 함.
    // 3. setter/getter 메서드를 정의해야 함.


}

