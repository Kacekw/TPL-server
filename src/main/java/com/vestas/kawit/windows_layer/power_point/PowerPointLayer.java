package com.vestas.kawit.windows_layer.power_point;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComFailException;
import com.jacob.com.Dispatch;

public class PowerPointLayer {

    private Dispatch presentation;
    private Dispatch presentations;
    private ActiveXComponent powerPoint;


    public Result runPresentation(String filePath) {

        System.out.println(stopPresentation());

        if (powerPoint == null) powerPoint = new ActiveXComponent("PowerPoint.Application");
        if (presentations == null) presentations = powerPoint.getProperty("Presentations").toDispatch();
        presentation = Dispatch.call(presentations, "Open", filePath).toDispatch();
        Dispatch slideShowSettings = Dispatch.call(presentation, "SlideShowSettings").toDispatch();

        Dispatch.call(slideShowSettings, "Run").toDispatch();

        //TODO implement return value logging
        return Result.SUCCESS;
    }

    private Result stopPresentation(){
        try {
            if (presentation != null) {
                System.out.println("exiting");
                Dispatch.call(presentation, "Save");
                Dispatch.call(presentation, "Close");
            }
            return Result.SUCCESS;
        }catch (ComFailException cfe){
            cfe.printStackTrace();
            return Result.FAILURE;
        }
    }

    enum Result {

        SUCCESS, FAILURE
    }

}
