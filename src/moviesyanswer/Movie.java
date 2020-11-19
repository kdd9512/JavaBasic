package moviesyanswer;

public class Movie {
    private String title; //제목
    private String year; //개봉연도
    private int runtime; //상영시간
    private String prdct; //제작사
    private String[] genre; //장르
    private String[] dirct; //감독
    private String[] actor; //배우
    private String summary; //줄거리
    private String desc; //소개

    public Movie() {

    }

    public Movie(String title, String year, int runtime, String prdct, String[] genre,
                 String[] dirct, String[] actor, String summary, String desc) {
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.prdct = prdct;
        this.genre = genre;
        this.dirct = dirct;
        this.actor = actor;
        this.summary = summary;
        this.desc = desc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public void setPrdct(String prdct) {
        this.prdct = prdct;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public void setDirct(String[] dirct) {
        this.dirct = dirct;
    }

    public void setActor(String[] actor) {
        this.actor = actor;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public int getRuntime() {
        return runtime;
    }

    public String getPrdct() {
        return prdct;
    }

    public String[] getGenre() {
        return genre;
    }

    public String[] getDirct() {
        return dirct;
    }

    public String[] getActor() {
        return actor;
    }

    public String getSummary() {
        return summary;
    }

    public String getDesc() {
        return desc;
    }
}
