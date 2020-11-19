package moviesyanswer;

public class Actor {
    //멤버변수
    private String name;
    private String birth;
    private String[] joinmovie;
    private String[] casting;

    public Actor() {

    }

    public Actor(String name, String birth, String[] joinmovie, String[] casting) {
        this.name = name;
        this.birth = birth;
        this.joinmovie = joinmovie;
        this.casting = casting;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setJoinmovie(String[] joinmovie) {
        this.joinmovie = joinmovie;
    }

    public void setCasting(String[] casting) {
        this.casting = casting;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String[] getJoinmovie() {
        return joinmovie;
    }

    public String[] getCasting() {
        return casting;
    }
}



