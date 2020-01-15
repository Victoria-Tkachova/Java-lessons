package Lambda;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface AlgoritmSort<T> {
    Collection<T> sort(Collection<T> collection, Comparator<T> comp);
}
