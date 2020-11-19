package moviesyanswer;

public class Director {
    private String name;
    private String birth;
    private String[] movie;
    private String[] casting;

    public Director() {//ALT + INSERT 후 select none
    }

    public Director(String name, String birth, String[] movie, String[] casting) {
        this.name = name;
        this.birth = birth;
        this.movie = movie;
        this.casting = casting;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setMovie(String[] movie) {
        this.movie = movie;
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

    public String[] getMovie() {
        return movie;
    }

    public String[] getCasting() {
        return casting;
    }
}
