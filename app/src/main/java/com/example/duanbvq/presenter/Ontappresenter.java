package com.example.duanbvq.presenter;

import com.example.duanbvq.interfaces.Mainview;
import com.example.duanbvq.interfaces.OnTapView;

public class Ontappresenter {
    private OnTapView onTapView;
    public Ontappresenter(OnTapView onTapView){
        this.onTapView=onTapView;
    }
    public void openone(){
        onTapView.navigate_one();
    }
}
