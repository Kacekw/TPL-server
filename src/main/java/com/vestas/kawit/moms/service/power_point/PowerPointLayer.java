package com.vestas.kawit.moms.service.power_point;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class PowerPointLayer {

    private Dispatch presentation;
    private Dispatch presentations;
    private Variant variant;
    private ActiveXComponent powerPoint;


    public Result runPresentation(String filePath) {
        stopPresentation();

        ActiveXComponent powerPoint = new ActiveXComponent("PowerPoint.Application");
        Dispatch presentations = powerPoint.getProperty("Presentations").toDispatch();
        Dispatch presentation = Dispatch.call(presentations, "Open", filePath).toDispatch();
        Variant variant = new Variant(false);
        return Result.SUCCESS;
    }

    public Result stopPresentation(){
        if (presentation == null && variant == null){
            return Result.FAILURE;
        }
        else{
            Dispatch.call(presentation, "Close").toDispatch();
            return Result.SUCCESS;
        }
    }

}
