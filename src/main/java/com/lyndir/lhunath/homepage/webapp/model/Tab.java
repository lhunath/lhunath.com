package com.lyndir.lhunath.homepage.webapp.model;

import java.io.Serializable;
import org.apache.wicket.Page;
import org.apache.wicket.model.IModel;


/**
 * <h2>{@link Tab}<br>
 * <sub>[in short] (TODO).</sub></h2>
 *
 * <p>
 * <i>05 02, 2010</i>
 * </p>
 *
 * @author lhunath
 */
public class Tab implements Serializable {

    private IModel<String> name;
    private Class<? extends Page> page;

    public Tab(IModel<String> name, Class<? extends Page> page) {
        this.name = name;
        this.page = page;
    }

    public IModel<String> getName() {
        return name;
    }

    public void setName(IModel<String> name) {
        this.name = name;
    }

    public Class<? extends Page> getPage() {
        return page;
    }

    public void setPage(Class<? extends Page> page) {
        this.page = page;
    }
}
