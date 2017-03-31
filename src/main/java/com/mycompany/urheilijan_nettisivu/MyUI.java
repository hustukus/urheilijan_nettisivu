package com.mycompany.urheilijan_nettisivu;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        
        final VerticalLayout baseLayout = new VerticalLayout();
        baseLayout.setSizeFull();
        
        final VerticalLayout headingPictureLayout = new VerticalLayout();
        headingPictureLayout.setHeight("30%");
        Label pictureLabel = new Label("kuvan pitäisi tulla tähän");
        
        final VerticalLayout restOfthepageLayout = new VerticalLayout();
        restOfthepageLayout.setHeight("70%");
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener( e -> {
            baseLayout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });
        
        final HorizontalLayout leftsideMenuLayout = new HorizontalLayout();
        leftsideMenuLayout.setWidth("20%");
        
        Button button1 = new Button("nappi 1");
        Button button2 = new Button("nappi 2");
        Button button3 = new Button("nappi 3");
        
        leftsideMenuLayout.addComponents(button1, button2, button3);
        headingPictureLayout.addComponent(pictureLabel);
        restOfthepageLayout.addComponents(name, button);

        baseLayout.addComponents(headingPictureLayout, restOfthepageLayout, leftsideMenuLayout);
        baseLayout.setMargin(true);
        baseLayout.setSpacing(true);
        
        setContent(baseLayout);
    
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
