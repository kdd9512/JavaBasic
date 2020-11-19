package lab;

class Directors {
    String drName;
    String birth;
    String direct;
    String act;

    public Directors(){
        drName = "";
        birth = "";
        direct = "";
    }
    private Directors(String drName, String birth, String direct, String act) {
        this.drName = drName;
        this.birth = birth;
        this.direct = direct;
        this.act = act;
    }
    public void setDrName(String drName) {
        this.drName = drName;
    }
    public void setBirth(String birth){
        this.birth  = birth;
    }
    public void setDirect(String direct){
        this.direct = direct;
    }
    public void setAct(String act){
        this.act = act;
    }
    public void getDirector(){

        return;
    }
}
//합치는 방법이 있긴 한데, 현단계에선 하나하나 다 써 줘야 한다.