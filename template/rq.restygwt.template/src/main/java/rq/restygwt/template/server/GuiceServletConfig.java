package rq.restygwt.template.server;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class GuiceServletConfig extends GuiceServletContextListener
{   
    @Override
    protected Injector getInjector()
    {
        final Map<String, String> params = new HashMap<String, String>();

        params.put(JERSEY_CONFIG_PROPERTY_PACKAGES, REST_INTERFACE_PACKAGE);
        params.put(JERSEY_API_JSON_POJO_MAPPING_FEATURE, "true");

        return Guice.createInjector(
            new ServletModule()
            {
                @Override
                protected void configureServlets()
                {
                    serve("/api/*").with(GuiceContainer.class, params);        
                }
            }
        );
    }

    private static final String JERSEY_CONFIG_PROPERTY_PACKAGES = "com.sun.jersey.config.property.packages";
    private static final String JERSEY_API_JSON_POJO_MAPPING_FEATURE = "com.sun.jersey.api.json.POJOMappingFeature";
    private static final String REST_INTERFACE_PACKAGE = "rq.restygwt.template.server";
}
