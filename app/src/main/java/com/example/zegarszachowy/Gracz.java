package com.example.zegarszachowy;

import android.os.CountDownTimer;
import android.widget.Button;

public class Gracz {
    private int ileSekund;
    private CountDownTimer countDownTimer;
    private Button button;
    private boolean czyAktywny;

    public Gracz(Button button, boolean czyAktywny) {
        this.button = button;
        this.czyAktywny = czyAktywny;
        ileSekund =180;
        if(czyAktywny){
            uruchomZegar();
        }
    }

    public void odwrocAktywnosc(){
        czyAktywny = !czyAktywny;
        if(czyAktywny){
            uruchomZegar();
        }else{
            zatrzymajZegar();
        }
    }
    private void zatrzymajZegar(){
        countDownTimer.cancel();
    }

    private void uruchomZegar(){
        countDownTimer = new CountDownTimer(ileSekund*1000, 1000) {
            @Override
            public void onFinish() {

            }

            @Override
            public void onTick(long l) {
                ileSekund = (int) l/1000;
                button.setText(ileSekund+"");
            }
        };
        countDownTimer.start();
    }
}
