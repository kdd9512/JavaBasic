package lab;

class Makers {
    String mkName;
    String addr;
    String mov;

    Makers(){
        mkName = "";
        addr = "";
        mov = "";
    }
    private Makers(String mkName, String addr, String mov) {
        this.mkName = mkName;
        this.addr = addr;
        this.mov = mov;
    }
    public void setMakers(String mkName, String addr, String mov){
        this.mkName = mkName;
        this.addr = addr;
        this.mov = mov;
    }
    public void getMakers(){
        return ;
    }


}



