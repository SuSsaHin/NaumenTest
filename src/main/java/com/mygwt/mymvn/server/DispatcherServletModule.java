package com.mygwt.mymvn.server;

import net.customware.gwt.dispatch.server.guice.GuiceStandardDispatchServlet;
import com.google.inject.servlet.ServletModule;
 
public class DispatcherServletModule extends ServletModule {
  @Override
  protected void configureServlets() {
    serve("/com.mygwt.mymvn.server/dispatch").with(GuiceStandardDispatchServlet.class);
  }
}