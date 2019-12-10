package Generic;

import java.util.Comparator;

public class StringComparator implements Comparator <String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.substring(o1.length()-1).compareTo(o2.substring(o2.length()-1));
    }
}
