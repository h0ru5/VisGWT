package com.github.h0ru5.gwt.angular.viz;

import com.google.gwt.angular.client.AngularModule;
import com.google.gwt.angular.client.NgDepends;
import com.google.gwt.angular.client.NgName;

@NgName("viz")
@NgDepends({VizDirective.class,DotService.class})
public class VizModule implements AngularModule {

}
