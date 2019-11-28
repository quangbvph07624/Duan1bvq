package com.example.duanbvq.presenter;

import com.example.duanbvq.interfaces.Mainview;

public class MainPresenter {
    private Mainview mainview;
    public MainPresenter(Mainview mainview){
        this.mainview=mainview;
    }
    public void openontap(){
        mainview.navigate_ontap();
    }
    public void openthi(){
        mainview.navigate_thi();
    }
    public void openbienbao(){
        mainview.navigate_bienbao();
    }
    public void openmeo(){
        mainview.navigate_meo();
    }


}
