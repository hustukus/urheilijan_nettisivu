package com.mycompany.urheilijan_nettisivu;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
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
        
        /*
        final CustomLayout baseLayout = new CustomLayout();
        
        final HorizontalLayout pictureLayout = new HorizontalLayout();
        
        final GridLayout baseGridLayout = new GridLayout(6, 6);
        baseGridLayout.setSizeFull();
        
        Label pictureLabel = new Label("kuvan pitäisi tulla tähän");
        
        Label pictureLabel2 = new Label("kuvan pitäisi tulla tähän");
        Label pictureLabel3 = new Label("kuvan pitäisi tulla tähän");
        Label pictureLabel4 = new Label("kuvan pitäisi tulla tähän");
        
        Label leftsideMenuLabel = new Label("vasemman menujutun pitäisi tulal tähän");
        
        Label calendarLabel = new Label("kalenteri/tapahtumajutun pitäisi tulla tänne");
        
        final VerticalLayout restOfthepageLayout = new VerticalLayout();
        restOfthepageLayout.setHeight("70%");
        restOfthepageLayout.setWidth("100%");
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener( e -> {
            restOfthepageLayout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });
        
        Button button1 = new Button("nappi 1");
        Button button2 = new Button("nappi 2");
        Button button3 = new Button("nappi 3");
        
        restOfthepageLayout.addComponents(name, button, button1, button2, button3);
        
        baseGridLayout.addComponent(pictureLabel, 0, 0);
        
        baseGridLayout.addComponent(leftsideMenuLabel, 0, 2);
        baseGridLayout.addComponent(pictureLabel3, 1, 2);
        baseGridLayout.addComponent(calendarLabel, 5, 2);
        
        //baseGridLayout.addComponent(pictureLabel, 2, 6, 0, 0);
        //baseGridLayout.addComponent(restOfthepageLayout, 4, 4, 1, 3);
        //baseGridLayout.addComponent(leftsideMenuLabel, 1, 4, 0, 3);
        //baseGridLayout.addComponent(calendarLabel, 1, 4, 6, 3);
        baseGridLayout.setMargin(true);
        baseGridLayout.setSpacing(true);
        
        setContent(baseGridLayout);
        */
        
        final AbsoluteLayout baseLayout = new AbsoluteLayout();
        baseLayout.setSizeFull();
        setContent(baseLayout);
        
        final HorizontalLayout pictureLayout = new HorizontalLayout();
        pictureLayout.setSizeFull();
        final VerticalLayout leftsideMenuLayout = new VerticalLayout(); 
        leftsideMenuLayout.setSizeFull();
        final VerticalLayout middleLayout = new VerticalLayout();
        middleLayout.setSizeFull();
        final VerticalLayout calendarLayout = new VerticalLayout();
        calendarLayout.setSizeFull();
        
        Label pictureLabel = new Label("kuvan pitäisi tulla tähän");
        Button nappula1 = new Button("siirtymä 1");
        Button nappula2 = new Button("siirtymä 2");
        Label calendarLabel = new Label("kalenterijutut tänne");
        
        Panel containerPanel = new Panel();
        containerPanel.setSizeFull();
        VerticalLayout containerLayout = new VerticalLayout();
        containerLayout.setMargin(true);
        Label middleLabel = new Label("vitusti kaikkee vitusti kaikkee vitusti kaikkee vitusti kaikkee vitusti kaikkee vitusti kaikkee vitusti kaikkee ");
        containerLayout.addComponent(middleLabel);
        containerPanel.setContent(containerLayout);
        
        pictureLayout.addComponent(pictureLabel);
        leftsideMenuLayout.addComponent(nappula1);
        leftsideMenuLayout.addComponent(nappula2);
        middleLayout.addComponent(containerPanel);
        calendarLayout.addComponent(calendarLabel);
        
        baseLayout.addComponent(pictureLayout, "left: 0%; right: 0%;" + "top: 0%; bottom: 70%;");
        baseLayout.addComponent(leftsideMenuLayout, "left: 0%; right: 80%;" + "top: 30%; bottom: 0%;");
        baseLayout.addComponent(middleLayout, "left: 20%; right: 20%;" + "top: 30%; bottom: 0%;");
        baseLayout.addComponent(calendarLayout, "left: 80%; right: 0%;" + "top: 30%; bottom: 0%;");     
    
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
