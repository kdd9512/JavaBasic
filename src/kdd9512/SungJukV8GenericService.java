package kdd9512;

public abstract class SungJukV8GenericService implements SungJukV8Interface {
    // 기능이 여러개이나 기능을 작동시키기 위한 작업은 공통이므로 이를 잡기 위해 추상클래스 사용.
    // 추상클래스인 GenericService 에서 Interface 를 구현(imlpements).
    // implements 위치 잘봐야.
    @Override
    public void newSungJuk() {

    }

    @Override
    public void readSungJuk() {

    }

    @Override
    public void readOneSungJuk() {

    }

    @Override
    public void removeSungJuk() {

    }

    @Override
    public void modifySungJuk() {

    }//인터페이스에서 입력한 메서드의 개수만큼 오버라이드 해야 오류가 안남.

}

