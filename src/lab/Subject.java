package lab;

public class Subject {
    String sbjName;
    String sbjPhone;
    String sbjLocate;
    String sbjHead;

    public Subject(){
        sbjName = "컴퓨터공학";
        sbjPhone = "123-4567-8901";
        sbjLocate = "E동 2층";
        sbjHead = "504";

    }
    public Subject(String sbjName, String sbjphone, String sbjlocate, String sbjhead){
        this.sbjName = sbjName;
        this.sbjPhone = sbjphone;
        this.sbjLocate = sbjlocate;
        this.sbjHead = sbjhead;

    }

}
