package student;

public class Bus {
    private int bNum;
    private int pasnger;
    private int earn;

    public Bus() {
    }

    public Bus(int bNum, int pasnger, int earn) {
        this.bNum = bNum;
        this.pasnger = pasnger;
        this.earn = earn;
    }

    public void setbNum(int bNum) {
        this.bNum = bNum;
    }

    public void setPasnger(int pasnger) {
        this.pasnger = pasnger;
    }

    public void setEarn(int earn) {
        this.earn = earn;
    }

    public int getbNum() {
        return bNum;
    }

    public int getPasnger() {
        return pasnger;
    }

    public int getEarn() {
        return earn;
    }

    public void take(int bgt){
        this.earn+=1000; //수입 1000 증가
        pasnger++;// 승객증가
    }
    public void showInfo() {
        System.out.printf("\n버스번호 : %2d, 승객 : %2d, 수입 : +%2d\n", bNum, pasnger, earn);
    }
}
