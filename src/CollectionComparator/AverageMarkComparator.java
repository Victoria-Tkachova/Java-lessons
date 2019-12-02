package CollectionComparator;

import java.util.Comparator;

public class AverageMarkComparator implements Comparator <Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAverageMark() < o2.getAverageMark()) {
            return -1;
        }
        else if (o1.getAverageMark() == o2.getAverageMark()) {
            return 0;
        }
        else {
            return 1;
        }
    }
}
