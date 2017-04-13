package com.mycompany.urheilijan_nettisivu;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ExternalResource;
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
import com.vaadin.ui.Link;
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
        
        // layout, jonka päälle kaikki muu rakentuu (root-layout)
        final AbsoluteLayout baseLayout = new AbsoluteLayout();
        baseLayout.setSizeFull();
        setContent(baseLayout);
        baseLayout.setStyleName("backgroundstyle");

        // muut layoutit baselayoutin jälkeen, joihin kaikki komponentit tulee (layouttien sisään voi pistää myös uusia layouttteja)
        final HorizontalLayout pictureLayout = new HorizontalLayout();
        pictureLayout.setSizeFull();
        final AbsoluteLayout leftsideMenuLayout = new AbsoluteLayout(); 
        leftsideMenuLayout.setSizeFull();
        final VerticalLayout middleLayout = new VerticalLayout();
        middleLayout.setSizeFull();
        final VerticalLayout calendarLayout = new VerticalLayout();
        calendarLayout.setSizeFull();
        calendarLayout.setMargin(true);
        calendarLayout.setStyleName("rightsidemenustyle");        

        
        // KANSIKUVA, kuvan lisääminen sivun yläosaan
        // Located in: VAADIN/themes/mytheme/imgages/kuvaEmmi.jpg
        ThemeResource resource = new ThemeResource("images/kuvaEmmi.jpg");
        Image coverPicture = new Image(null, resource);        
        
        // VASEMMAN PALKIN SISÄLTÖ
        
        final VerticalLayout helpingLayout = new VerticalLayout();
        helpingLayout.setWidth("100%");
        helpingLayout.setHeightUndefined();
        Button esittelyNappula = new Button("Esittely");
        Button kuvatNappula = new Button("Kuvat");
        Button kalenteriNappula = new Button("Kalenteri");
        Button blogiteksitNappula = new Button("Blogitekstit");
        esittelyNappula.setStyleName("buttonstyle");
        kuvatNappula.setStyleName("buttonstyle");
        kalenteriNappula.setStyleName("buttonstyle");
        blogiteksitNappula.setStyleName("buttonstyle");
        helpingLayout.addComponents(esittelyNappula, kuvatNappula, kalenteriNappula, blogiteksitNappula);
        helpingLayout.setComponentAlignment(esittelyNappula,Alignment.MIDDLE_CENTER);
        helpingLayout.setComponentAlignment(kuvatNappula,Alignment.MIDDLE_CENTER);
        helpingLayout.setComponentAlignment(kalenteriNappula,Alignment.MIDDLE_CENTER);
        helpingLayout.setComponentAlignment(blogiteksitNappula,Alignment.MIDDLE_CENTER);
        
        // KESKIOSAN SISÄLTÖ
        
        // panelin sisällä on VerticalLayout, johon komponentit listätään perätysten
        Panel containerPanel = new Panel();
        containerPanel.setSizeFull();
        
        VerticalLayout containerLayout = new VerticalLayout();
        containerLayout.setMargin(true);
        containerLayout.setSizeFull();
        Label introLabel = new Label("Tästä löytyvät viimeisimmät blogitekstini ja kuvani!");
        introLabel.setStyleName("headertextstyle");
        Label footer = new Label("Tänne sitten kaikki footer-jutut, yhteystiedot, sponssit sun muut");
        Label blogiTeksti1 = new Label("Tässä meillä pitkääkin pitempi blogiteksti numero 1"
                + "Tässä meillä pitkääkin pitempi blogiteksti numero 1 " 
                + "Tässä meillä pitkääkin pitempi blogiteksti numero 1 "
                + "Tässä meillä pitkääkin pitempi blogiteksti numero 1 "
                + "Tässä meillä pitkääkin pitempi blogiteksti numero 1 "
                + "Tässä meillä pitkääkin pitempi blogiteksti numero 1 ");
        blogiTeksti1.setWidth("100%");
        Label blogiTeksti2 = new Label("Tässä meillä pitkääkin pitempi blogiteksti numero 2"
                + "Tässä meillä pitkääkin pitempi blogiteksti numero 2"
                + "Tässä meillä pitkääkin pitempi blogiteksti numero 2"
                + "Tässä meillä pitkääkin pitempi blogiteksti numero 2"
                + "Tässä meillä pitkääkin pitempi blogiteksti numero 2"
                + "Tässä meillä pitkääkin pitempi blogiteksti numero 2");
        blogiTeksti2.setWidth("100%");
        
        // komponentit lisätään keskikohtaan
        containerLayout.addComponents(introLabel, blogiTeksti1, blogiTeksti2, footer);
        
        // määritellään komponenttein suhteet keskiosan sisällä
        containerLayout.setExpandRatio(introLabel, 1);
        containerLayout.setExpandRatio(blogiTeksti1, 2);
        containerLayout.setExpandRatio(blogiTeksti2, 2);
        containerLayout.setExpandRatio(footer, 1);

        containerPanel.setContent(containerLayout);
        
        // OIKEAN PALKIN SISÄLTÖ
        
        final Panel calendarPanel = new Panel("Tulevat tapahtumat:");
        calendarPanel.setSizeFull();
        VerticalLayout panelContentLayout = new VerticalLayout();
        
        // esimerkkeinä nyt pelkkiä staattisia linkkejä -> tähtäimessä jokin metodi, joka osaisi hakea linkit suoraan sivulta
        Link link1 = new Link("Maakunnallinen 50m kiväärin makuun sarjakilpailu", new ExternalResource("https://www.ampumaurheiluliitto.fi/kalenteri/kilpailut/kilpailu/?id=293"));
        Link link2 = new Link("ESA:n kevätpiekkari", new ExternalResource("https://www.ampumaurheiluliitto.fi/kalenteri/kilpailut/kilpailu/?id=289"));
        Link link3 = new Link("Nuorten EM-näyttökilkailu 2, Turku", new ExternalResource("https://www.ampumaurheiluliitto.fi/kalenteri/kilpailut/kilpailu/?id=281"));
        panelContentLayout.addComponents(link1, link2, link3);
        calendarPanel.setContent(panelContentLayout);
        
        // LISÄTÄÄN SISÄLTÖ OMIIN LAYOUTTEIHINSA
        pictureLayout.addComponent(coverPicture);
        pictureLayout.setComponentAlignment(coverPicture,Alignment.MIDDLE_CENTER);
        leftsideMenuLayout.addComponent(helpingLayout, "left: 0%; right: 0%;" + "top: 30%; bottom: 30%;");
        middleLayout.addComponent(containerPanel);
        calendarLayout.addComponents(calendarPanel);

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
