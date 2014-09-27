package pages.questions.dataview;

/**
 * Created by Ashot Karakhanyan on 13-09-2014
 */


import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByLink;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NavigatorLabel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.CompoundPropertyModel;
import pages.questions.data.SomeBean;
import pages.questions.data.SomeBeanDataProvider;
import pages.questions.data.SomeBeanFilter;


public class DataViewPage extends WebPage {
    public DataViewPage() {
        SomeBeanDataProvider dataProvider = new SomeBeanDataProvider();

        Form<SomeBeanFilter> form =
                new Form<SomeBeanFilter>("form", new CompoundPropertyModel<SomeBeanFilter>((SomeBeanFilter) dataProvider.getFilterState()));
        form.add(new TextField<String>("lastName"));
        form.add(new TextField<String>("firstName"));

        form.add(new OrderByLink("sortName", "lastName", dataProvider));
        form.add(new OrderByLink("sortAlter", "age", dataProvider));

        DataView<SomeBean> dataView = new DataView<SomeBean>("dataView", dataProvider) {
            @Override
            protected void populateItem(Item<SomeBean> item) {
                item.setDefaultModel(new CompoundPropertyModel<SomeBean>(item.getModel()));
                item.add(new Label("firstName"));
                item.add(new Label("lastName"));
                item.add(new Label("age"));
            }
        };
        dataView.setItemsPerPage(10);

        form.add(new PagingNavigator("navigator", dataView));
        form.add(new NavigatorLabel("label", dataView));

        form.add(dataView);

        add(form);
    }
}

