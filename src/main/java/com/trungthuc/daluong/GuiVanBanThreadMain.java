package com.trungthuc.daluong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GuiVanBanThreadMain {
    public static void main(String[] args) {
        List<String> init = new ArrayList<>();

        init.add("JAVA");
        init.add("PYTHON");
        init.add("C++");
        init.add("JS");
        init.add("PHP");

        GuiVanBanThread guiVanBanThread1 = new GuiVanBanThread("THREAD1");
        guiVanBanThread1.setData(Collections.singletonList(init));
        guiVanBanThread1.start();
        GuiVanBanThread guiVanBanThread2 = new GuiVanBanThread("THREAD2");
        guiVanBanThread2.setData(Collections.singletonList(init));
        guiVanBanThread2.start();

    }
}
