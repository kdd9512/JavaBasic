package lab;

class Actors {
    String aName;
    String birth;
    String act;

    Actors(){
        aName = "";
        birth = "";
        act = "";

    }
    private Actors(String aName, String birth, String act) {
        this.aName = aName;
        this.birth = birth;
        this.act = act;
    }
    public void setActors(String aName, String birth, String act){
        this.aName = aName;
        this.birth = birth;
        this.act = act;
    }

    public void getActors() {
        return;

    }
}
