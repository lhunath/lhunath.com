package com.lyndir.lhunath.homepage.webapp;

import com.lyndir.lhunath.homepage.webapp.page.AboutPage;
import com.lyndir.lhunath.homepage.webapp.page.ContactPage;
import com.lyndir.lhunath.homepage.webapp.page.CreationsPage;
import com.lyndir.lhunath.homepage.webapp.page.OpheliaPage;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.target.coding.HybridUrlCodingStrategy;


/**
 * <h2>{@link HomepageWebApplication}<br>
 * <sub>[in short] (TODO).</sub></h2>
 *
 * <p>
 * <i>05 02, 2010</i>
 * </p>
 *
 * @author lhunath
 */
public class HomepageWebApplication extends WebApplication {

    @Override
    protected void init() {

        mount( new HybridUrlCodingStrategy( "/about", AboutPage.class ) );
        mount( new HybridUrlCodingStrategy( "/ophelia", OpheliaPage.class ) );
        mount( new HybridUrlCodingStrategy( "/contact", ContactPage.class ) );
        mount( new HybridUrlCodingStrategy( "/creations", CreationsPage.class ) );
    }

    @Override
    public Class<? extends Page> getHomePage() {

        return AboutPage.class;
    }
}
