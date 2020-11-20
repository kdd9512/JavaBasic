package student;

public class Subway {
    private String sNum;
    private int pasnger;
    private int earn;

    public Subway() {
    }

    public Subway(String sNum, int pasnger, int earn) {
        this.sNum = sNum;
        this.pasnger = pasnger;
        this.earn = earn;
    }

    public void setsNum(String sNum) {
        this.sNum = sNum;
    }

    public void setPasnger(int pasnger) {
        this.pasnger = pasnger;
    }

    public void setEarn(int earn) {
        this.earn = earn;
    }

    public String getsNum() {
        return sNum;
    }

    public int getPasnger() {
        return pasnger;
    }

    public int getEarn() {
        return earn;
    }
    public void take(int bgt){
        this.earn += 1500;
        pasnger++;
        
    }
    public void showInfo(){
        System.out.println("지하철" + getsNum() + "호선 의 승객은 현재 " + getPasnger() + "명이고 잔액은" + Student.getBgt() + "원 입니다");

    }
}
