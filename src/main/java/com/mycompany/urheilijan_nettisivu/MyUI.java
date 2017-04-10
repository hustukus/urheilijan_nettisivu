package com.mycompany.urheilijan_nettisivu;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
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
        
        // layout, jonka päälle kaikki muu rakentuu (root-layout)
        final AbsoluteLayout baseLayout = new AbsoluteLayout();
        baseLayout.setSizeFull();
        setContent(baseLayout);
        
        // muut layoutit baselayoutin jälkeen, joihin kaikki komponentit tulee (layouttien sisään voi pistää myös uusia layouttteja)
        final HorizontalLayout pictureLayout = new HorizontalLayout();
        pictureLayout.setSizeFull();
        final AbsoluteLayout leftsideMenuLayout = new AbsoluteLayout(); 
        leftsideMenuLayout.setSizeFull();
        leftsideMenuLayout.setStyleName("leftsidemenustyle");
        final VerticalLayout middleLayout = new VerticalLayout();
        middleLayout.setSizeFull();
        final VerticalLayout calendarLayout = new VerticalLayout();
        
        // kuvan lisääminen sivun yläosaan
        
        // A theme resource in the current theme ("mytheme")
        // Located in: VAADIN/themes/mytheme/img/themeimage.png
        ThemeResource resource = new ThemeResource("images/harkkatyo_kansikuva.png");

        // Use the resource
        Image coverPicture = new Image(null, resource);        
        
        
        // vasemman palkin sisältö
        VerticalLayout helpingLayout = new VerticalLayout();
        helpingLayout.setWidth("100%");
        helpingLayout.setHeightUndefined();
        Button nappula1 = new Button("Esittely");
        Button nappula2 = new Button("Kuvat");
        Button nappula3 = new Button("Kalenteri");
        Button nappula4 = new Button("Blogitekstit");
        helpingLayout.addComponents(nappula1, nappula2, nappula3, nappula4);
        helpingLayout.setComponentAlignment(nappula1,Alignment.MIDDLE_CENTER);
        helpingLayout.setComponentAlignment(nappula2,Alignment.MIDDLE_CENTER);
        helpingLayout.setComponentAlignment(nappula3,Alignment.MIDDLE_CENTER);
        helpingLayout.setComponentAlignment(nappula4,Alignment.MIDDLE_CENTER);
        
        //keskiosan sisällöt
        // panelin sisällä on VerticalLayout, ja VerticalLayoutissa on taas panel
        Panel containerPanel = new Panel();
        containerPanel.setSizeFull();
        VerticalLayout containerLayout = new VerticalLayout();
        containerLayout.setMargin(true);
        Panel middlePanel = new Panel("vitusti kaikkee vitusti kaikkee vitusti kaikkee vitusti kaikkee vitusti kaikkee vitusti kaikkee vitusti kaikkee ");
        middlePanel.addStyleName("basic-style");
        containerLayout.addComponent(middlePanel);
        containerPanel.setContent(containerLayout);
        
        // oikean palkin sisältö
        VerticalLayout calendarHelpingLayout = new VerticalLayout();
        Label calendarLabel = new Label("Täältä näet tulevat tapahtumat. Jee!");
        Panel calendarPanel = new Panel("Tänne sitten tulee nuita tulevia tapaahtumia jahka ne saadaan jostain Tänne sitten tulee nuita tulevia tapaahtumia jahka ne saadaan jostain Tänne sitten tulee nuita tulevia tapaahtumia jahka ne saadaan jostain Tänne sitten tulee nuita tulevia tapaahtumia jahka ne saadaan jostainTänne sitten tulee nuita tulevia tapaahtumia jahka ne saadaan jostain");        
        calendarHelpingLayout.addComponents(calendarLabel, calendarPanel);
        calendarHelpingLayout.setSizeFull();
        calendarHelpingLayout.setMargin(true);
        
        // lisätään sisältö omiin Layouttteihinsa
        pictureLayout.addComponent(coverPicture);
        leftsideMenuLayout.addComponent(helpingLayout, "left: 0%; right: 0%;" + "top: 30%; bottom: 30%;");
        middleLayout.addComponent(containerPanel);
        calendarLayout.addComponent(calendarHelpingLayout);
        
        // määritellään komponenteille paikka layouttiensa sisällä
        pictureLayout.setComponentAlignment(coverPicture,Alignment.MIDDLE_CENTER);
        /*

        */
        
        // määritellään peruslayoutin(baselayout) sisällä/päällä olevien layouttien paikat
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
