package com.technifutur.mobile;

import com.technifutur.mobile.domain.other.Zoo;
import com.technifutur.mobile.ui.UserInterface;

public class Main {

    public static void main(String[] args) {

        UserInterface ui = new UserInterface();

        ui.generateZoo();
        ui.start();



    }
}
