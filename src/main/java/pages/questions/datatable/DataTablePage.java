package pages.questions.datatable;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterForm;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.TextFilteredPropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import pages.questions.data.SomeBean;
import pages.questions.data.SomeBeanDataProvider;


public class DataTablePage extends WebPage {
    public DataTablePage() {
        List<IColumn<SomeBean>> columns = new ArrayList<IColumn<SomeBean>>();
        columns.add(new TextFilteredPropertyColumn<SomeBean, String>(Model.of("FirstName"), "firstName"));
        columns.add(new TextFilteredPropertyColumn<SomeBean, String>(Model.of("LastName"), "lastName", "lastName"));
        columns.add(new PropertyColumn<SomeBean>(Model.of("Age"), "age", "age"));

        SomeBeanDataProvider dataProvider = new SomeBeanDataProvider();

        FilterForm form = new FilterForm("form", dataProvider);

        DefaultDataTable<SomeBean> dataTable = new DefaultDataTable<SomeBean>("dataTable", columns, dataProvider, 10);
        dataTable.addTopToolbar(new FilterToolbar(dataTable, form, dataProvider));
        form.add(dataTable);

        /*add(new Panel("AA") {
        });*/
        add(form);
    }
}

