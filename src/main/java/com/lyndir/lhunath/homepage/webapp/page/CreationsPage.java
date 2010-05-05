package com.lyndir.lhunath.homepage.webapp.page;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


/**
 * <h2>{@link CreationsPage}<br>
 * <sub>[in short] (TODO).</sub></h2>
 *
 * <p>
 * <i>05 02, 2010</i>
 * </p>
 *
 * @author lhunath
 */
public class CreationsPage extends LayoutPage {

    @Override
    protected IModel<String> getPageImage() {

        return new Model<String>( "images/resources/creations.1.png" );
    }

    @Override
    public IModel<String> getPageTitle() {

        return new Model<String>("Creations");
    }
}
