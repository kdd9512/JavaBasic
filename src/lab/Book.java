package lab;

public class Book {
    //멤버변수 선언
    String title;
    String aut;
    String trans;
    String pub;
    String pubDate;
    int price;
    double discnt;
    String bkImg;    // Java.png

    //기본 생성자
    public Book() {
        title = "누구나 알기쉬운 자바: 입문편";
        aut = "카와바 타케시 저";
        trans = "하진일 역";
        pub = "혜지원";
        pubDate = "2014,06";
        price = 22500;
        discnt = 0.1;
        bkImg = "Java.png";
    }
    //이하 생성자 문구는 ALT+INSERT 누르고 Constructor 선택한 다음 선택 가능한 문구 전부 선택한 뒤 적용하면 출력할 수 있음.
    public Book(String title, String aut, String trans, String pub, String pubDate, int price, double discnt, String bkImg) {
        this.title = title;
        this.aut = aut;
        this.trans = trans;
        this.pub = pub;
        this.pubDate = pubDate;
        this.price = price;
        this.discnt = discnt;
        this.bkImg = bkImg;
    }

    //이 형태에 익숙해져야함.
}