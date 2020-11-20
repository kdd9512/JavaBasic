package student;

public class Subway {
    private int sNum;
    private int pasnger;
    private int earn;

    public Subway() {
    }

    public Subway(int sNum, int pasnger, int earn) {
        this.sNum = sNum;
        this.pasnger = pasnger;
        this.earn = earn;
    }

    public void setsNum(int sNum) {
        this.sNum = sNum;
    }

    public void setPasnger(int pasnger) {
        this.pasnger = pasnger;
    }

    public void setEarn(int earn) {
        this.earn = earn;
    }

    public int getsNum() {
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
        System.out.printf("\n%2d호선, 승객 : %2d, 수입 : +%2d\n",sNum,pasnger,earn);
    }

}
