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

    public void setMkName(String mkName) {
        this.mkName = mkName;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setMov(String mov) {
        this.mov = mov;
    }

    public String getMkName() {
        return mkName;
    }

    public String getAddr() {
        return addr;
    }

    public String getMov() {
        return mov;
    }
}



