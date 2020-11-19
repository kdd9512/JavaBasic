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
//Feedback : 처음 생각했던 대로 setter를 하나로 합치는 방법이 있긴 한데, 생성자가 필요하므로 현단계에선 하나하나 다 써 줘야 한다.