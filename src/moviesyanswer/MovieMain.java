package moviesyanswer;

public class MovieMain {
    public static void main(String[] args) {
        String[] genre = { "드라마" };
        String[] director = { "톰 후퍼" };
        String[] actor = { "콜린 퍼스","헬레나 본햄 카터","제프리 러시" };
        String summary = "때는 1939년, 세기의 스캔들을 일으키며 왕위를 포기한 형 때문에 본의 아니게 왕위에 오른 버티(콜린 퍼스 분).....";
        String desc = "제2차 세계 대전 시기 내성적인 영국 국왕 조지 6세가 말더듬이를 견뎌내고 군중들에게 연설하는 과정을 다룬 영화. 조지 6세와 라이오넬 로그의 우정에 중점을 맞춰 이야기를 전개한다. " +
                "동명의 책도 있는데 바로 라이오넬의 손자가 쓴 것이다.";

        //객체의 String 배열이나 줄거리 소개 등의 긴 문구들은 여기서 처리한다.

        Movie kingsspeech = new Movie("킹스 스피치","2010",119,"시소 필름즈",genre,director,actor,summary,desc);

        System.out.println(kingsspeech.getTitle());
        System.out.println(kingsspeech.getYear());
        System.out.println(kingsspeech.getRuntime());
        System.out.println(kingsspeech.getPrdct());
        // 장르,감독,배우는 값이 나오는게 아니라 주소가 나오므로 Movie 객체에서 관련 getter를 고쳐야한다.
        // 이는 참조형 변수이기 때문이며, 반복문을 이용하여 처리해야 한다.
        for(int i = 0 ; i < genre.length ; ++i){
            System.out.println(kingsspeech.getGenre()[i]);
        }
        for(int i = 0 ; i< director.length ; ++i){
            System.out.println(kingsspeech.getDirct()[i]);
        }
        for(int i = 0 ; i< actor.length ; ++i){
            System.out.println(kingsspeech.getActor()[i]);
        }
        System.out.println(kingsspeech.getSummary());
        System.out.println(kingsspeech.getDesc());
        }

    }

}