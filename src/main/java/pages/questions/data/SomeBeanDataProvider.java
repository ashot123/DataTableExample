package pages.questions.data;

/**
 * Created by Ashot Karakhanyan on 13-09-2014
 */


import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilterStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.util.SingleSortState;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class SomeBeanDataProvider implements ISortableDataProvider<SomeBean>, IFilterStateLocator {
    ISortState sortState = new SingleSortState();
    SomeBeanFilter filter = new SomeBeanFilter();

    final static int LIST_SIZE = 123;
    private List<SomeBean> list;

    @Override
    public Iterator<? extends SomeBean> iterator(int first, int count) {
        initList();
        List<SomeBean> ret = list;

        /*

        if (ret.size() > (first + count)) {
            ret = ret.subList(first, first + count);
        }
        */
        if (ret.size() > (first + count)) {
            ret = ret.subList(first, first + count);
        } else {
            ret = ret.subList(first, ret.size());
        }

        return ret.iterator();



    }

    @Override
    public IModel<SomeBean> model(SomeBean object) {
        return Model.of(object); // new Model(object)
    }

    @Override
    public int size() {
        initList();

        return list.size();
    }

    @Override
    public void detach() {
        list = null;
    }

    @Override
    public ISortState getSortState() {
        return sortState;
    }


    public void setSortState(ISortState state) {
        sortState = state;
    }

    @Override
    public Object getFilterState() {
        return filter;
    }

    @Override
    public void setFilterState(Object state) {
        filter = (SomeBeanFilter) state;
    }


    private void initList() {
        if (list == null) {
            final SortOrder nameSort;
            final SortOrder alterSort;
            if (sortState != null) {
                nameSort = sortState.getPropertySortOrder("lastName");
                alterSort = sortState.getPropertySortOrder("age");
            } else {
                nameSort = SortOrder.NONE;
                alterSort = SortOrder.NONE;
            }

            list = getSortedList(nameSort, alterSort, filter);
        }
    }


    private List<SomeBean> getSortedList(final SortOrder nameSort, final SortOrder alterSort, SomeBeanFilter filter) {
        List<SomeBean> result = SomeBeanGenerator.getBeans(LIST_SIZE, filter);

        Collections.sort(result, new Comparator<SomeBean>() {
            public int compare(SomeBean o1, SomeBean o2) {
                int compName = o1.getLastName().compareTo(o2.getLastName());
                int compAlter = new Integer(o1.getAge()).compareTo(o2.getAge());

                if (nameSort == SortOrder.NONE) {
                    compName = 0;

                } else if (nameSort == SortOrder.DESCENDING) {
                    compName = -compName;

                }
                if (alterSort == SortOrder.NONE) {
                    compAlter = 0;

                } else if (alterSort == SortOrder.DESCENDING) {
                    compAlter = -compAlter;

                }
                if (compName != 0) return compName;
                return compAlter;
            }
        });

        return result;
    }
}

