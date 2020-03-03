package com.vestas.kawit.windows_layer.power_point;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComFailException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class PowerPointLayer {
    /**
     * This class job is to run PowerPoint application, load presentation and start it on the screen.
     */

    private ActiveXComponent powerPoint = new ActiveXComponent("PowerPoint.Application");
    private Dispatch presentations = powerPoint.getProperty("Presentations").toDispatch();
    private Dispatch presentation;


    public Result runPresentation(String filePath) {

        System.out.println(stopPresentation());

        presentation = Dispatch.call(presentations, "Open", filePath).toDispatch();
        Dispatch slideShowSettings = Dispatch.call(presentation, "SlideShowSettings").toDispatch();

        Dispatch.call(slideShowSettings, "Run").toDispatch();

        //TODO implement return value logging
        return Result.SUCCESS;
    }

    private Result stopPresentation() {
        try {
            System.out.print("Stopping Power Point Application ::: ");
            //TODO this is not working as intended
            //refreshPresentationStatus();
            if (presentation != null) {
                System.out.println(powerPoint.getProperty("ActivePresentation"));
                Dispatch.call(presentation, "Save");
                Dispatch.call(presentation, "Close");
            }
            return Result.SUCCESS;
        } catch (ComFailException cfe) {
            System.out.print(cfe.getLocalizedMessage());
            return Result.FAILURE;
        }
    }

    //TODO
    private void refreshPresentationStatus() {
        Variant activePresentation = powerPoint.getProperty("ActivePresentation");
        if (activePresentation.toString().contains("There is no active presentation")) {
            presentation = null;
        }
    }

    enum Result {
        SUCCESS, FAILURE
    }

}
