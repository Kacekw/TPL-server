package com.vestas.kawit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TplserverApplication {
    /**
     * Application was designed and written to help team working within SAP system. It consists of three theoretical modules that:
     * - maintains "task lists" of SAP ERP system using input from client application that is being used by the team. When asked, app can find, retrieve and pass
     * on task list object as a JSON so that it can be red and used by the user using client application withing the same network.
     * - log users actions as it help to maintain and upgrade the app, it also helps to maintain the workload of people using it as it provides clear view on
     * how much workload people have. It also provides online-table-alike view available for clients connected to the same network.
     * - it shares an option to upload and run .pptx (Microsoft PowerPoint) presentation so that it can run on screen.
     */

    public static void main(String[] args) {
        SpringApplication.run(TplserverApplication.class, args);
    }

}
