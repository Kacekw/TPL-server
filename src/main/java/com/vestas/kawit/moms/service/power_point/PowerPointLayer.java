package com.vestas.kawit.moms.service.power_point;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class PowerPointLayer {

    private Dispatch presentation;
    private Dispatch presentations;
    private ActiveXComponent powerPoint;


    public Result runPresentation(String filePath) {
        System.out.println(stopPresentation());

        powerPoint = new ActiveXComponent("PowerPoint.Application");
        presentations = powerPoint.getProperty("Presentations").toDispatch();
        presentation = Dispatch.call(presentations, "Open", filePath).toDispatch();

        return Result.SUCCESS;
    }

    public Result stopPresentation(){
        /*if (presentation == null && variant == null){
            System.out.println("presentation is null");
            return Result.FAILURE;
        }
        else{*/
        if (powerPoint != null){
            System.out.println(Dispatch.call(presentation, "Close"));
            return Result.SUCCESS;
        }
        else return Result.FAILURE;
    }

}
