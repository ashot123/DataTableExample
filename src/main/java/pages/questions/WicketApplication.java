package pages.questions;

import org.apache.wicket.Page;
import pages.questions.datatable.DataTablePage;
import pages.questions.dataview.DataViewPage;

/**
 * Created by Ashot Karakhanyan on 10-08-2014
 */
public class WicketApplication extends org.apache.wicket.protocol.http.WebApplication {

    public WicketApplication() {
    }

    @Override
    protected void init() {
        super.init();
        //getComponentInstantiationListeners().add(new SpringComponentInjector(this));
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return DataTablePage.class;
        //return DataViewPage.class;
    }

    /*@Override
    public Session newSession(Request request, Response response) {
        return new CheesrSession(request);
    }

*/

    /* public static CheesrApplication get() {
        return (CheesrApplication) Application.get();
    }
    */


   /* @Deprecated
    public List<Cheese> getCheeses() {
        return cheeses;
    }*/


}