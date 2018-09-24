package interview.Airbnb.Job.Experience;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListIterator2D implements Iterator<Integer> {
    private Iterator<List<Integer>> rowIter;
    private Iterator<Integer> colIter;
    public ListIterator2D(List<List<Integer>> matrix) {
        rowIter = matrix.iterator();
        colIter = Collections.emptyIterator();
    }

    @Override
    public boolean hasNext() {
        while ((colIter == null || !colIter.hasNext()) && rowIter.hasNext()) colIter = rowIter.next().iterator();
        return colIter != null && colIter.hasNext();
    }

    @Override
    public Integer next() {
        return colIter.next();
    }

    public void remove() {
        while ((colIter == null || !colIter.hasNext()) && rowIter.hasNext()) colIter = rowIter.next().iterator();
        if (colIter != null) colIter.remove();
    }
}
