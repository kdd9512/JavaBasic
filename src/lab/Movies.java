package lab;

class Movies {
    String title;
    int date;
    int time;
    String genre;
    String synop;
    String intro;

    public Movies(){
            title = "";
            date = 0;
            time = 0;
            genre = "";
            synop = "";
            intro = "";

    }
    private Movies(String title, int date, int time, String genre, String synop, String intro) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.genre = genre;
        this.synop = synop;
        this.intro = intro;
    }
    public void setMovies(String title, int date, int time, String genre, String synop, String intro){
        this.title = title;
        this.date = date;
        this.time = time;
        this.genre = genre;
        this.synop = synop;
        this.intro = intro;
    }
    public void getMovies(){
        return ;
    }

}
