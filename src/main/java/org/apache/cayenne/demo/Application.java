package org.apache.cayenne.demo;

import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.datasource.DataSourceBuilder;

public class Application {

    private final ServerRuntime cayenneRuntime;

    public static void main(String[] arg) {
        Application application = new Application();
    }

    private Application() {
        cayenneRuntime = ServerRuntime.builder()
                .addConfig("cayenne-project.xml ")
                .dataSource(DataSourceBuilder.url("jdbc:mysql://localhost/cayenne")
                        .driver(com.mysql.cj.jdbc.Driver.class.getName())
                        .userName("root")
                        .password("cayenne")
                        .pool(1,3)
                        .build()
                )
                .build();

    }


}
