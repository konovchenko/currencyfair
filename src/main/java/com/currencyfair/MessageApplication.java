package com.currencyfair;

import com.currencyfair.service.MessageService;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
* @author Anton Konovchenko
* @version 1.0.0
*/
@ApplicationPath("/resources")
public class MessageApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        // register root resource
        classes.add(MessageService.class);
        return classes;
    }
}
