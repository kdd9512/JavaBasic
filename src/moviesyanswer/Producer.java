package moviesyanswer;

public class Producer {
    private String name;
    private String addr;
    private String[] movie;

    public Producer() {
    }

    public Producer(String name, String addr, String[] movie) {
        this.name = name;
        this.addr = addr;
        this.movie = movie;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setMovie(String[] movie) {
        this.movie = movie;
    }

    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }

    public String[] getMovie() {
        return movie;
    }
}
