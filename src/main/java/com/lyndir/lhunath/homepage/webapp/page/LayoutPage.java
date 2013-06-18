package com.lyndir.lhunath.homepage.webapp.page;

import com.google.common.collect.ImmutableList;
import com.lyndir.lhunath.homepage.webapp.model.Tab;
import com.lyndir.lhunath.opal.wayward.component.LabelLink;
import java.util.HashMap;
import java.util.Map;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.behavior.StringHeaderContributor;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.ContextImage;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.template.JavaScriptTemplate;
import org.apache.wicket.util.template.PackagedTextTemplate;


/**
 * <h2>{@link LayoutPage}<br> <sub>[in short] (TODO).</sub></h2>
 *
 * <p> <i>05 02, 2010</i> </p>
 *
 * @author lhunath
 */
public abstract class LayoutPage extends WebPage {

    public LayoutPage() {

        add( new Label( "pageTitle", getPageTitle() ) );
        add( new Label( "pageHeading", getPageHeading() ) );
        add( new ContextImage( "image", getPageImage() ) );

        add( new ListView<Tab>( "menu", ImmutableList.of( new Tab( Model.of( "About" ), AboutPage.class ), //
                                                          new Tab( Model.of( "Kids" ), KidsPage.class ), //
                                                          new Tab( Model.of( "Contact" ), ContactPage.class ), //
                                                          new Tab( Model.of( "Creations" ), CreationsPage.class ) //
        ) ) {

            @Override
            protected void populateItem(final ListItem<Tab> tab) {

                boolean isActive = tab.getModelObject().getPage().isAssignableFrom( getPageClass() );
                tab.add( new LabelLink( "link", tab.getModelObject().getName() ) {

                    @Override
                    public void onClick() {

                        throw new RestartResponseException( tab.getModelObject().getPage() );
                    }
                }.add( new SimpleAttributeModifier( "class", isActive? "active": "" ) ) );
            }
        } );

        Map<String, Object> trackVariables = new HashMap<String, Object>();
        trackVariables.put( "googleAnalyticsID", "UA-24338692-1" );
        trackVariables.put( "pageView", getPageClass().getSimpleName() );
        add( new StringHeaderContributor(
                new JavaScriptTemplate( new PackagedTextTemplate( LayoutPage.class, "trackPage.js" ) ).asString( trackVariables ) ) );
    }

    protected abstract IModel<String> getPageImage();

    protected abstract IModel<String> getPageTitle();

    protected IModel<String> getPageHeading() {

        return getPageTitle();
    }
}
