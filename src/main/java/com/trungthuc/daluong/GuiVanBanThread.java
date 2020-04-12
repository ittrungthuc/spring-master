package com.trungthuc.daluong;

import java.util.List;

public class GuiVanBanThread extends Thread {

    private List<Object> data;

    public GuiVanBanThread(String threadName){
        super(threadName);
    }

    @Override
    public void run() {
        for (Object a : data){
            System.out.printf("Thread : " + getName() + ": value : " + a);
            System.out.println("END THREAD:  " + getName());

        }
        super.run();
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
