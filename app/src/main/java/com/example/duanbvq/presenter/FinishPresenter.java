package com.example.duanbvq.presenter;

import com.example.duanbvq.interfaces.FinishView;

public class FinishPresenter {
    private FinishView finishView;
    public FinishPresenter( FinishView finishView){
        this.finishView=finishView;
    }
    public  void opennext(){
        finishView.navigate_next();
    }
}
