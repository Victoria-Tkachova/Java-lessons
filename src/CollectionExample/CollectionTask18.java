package CollectionExample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CollectionTask18 {
    class Science {
        String studentName;
        int mathMarks;
        int historyMarks;
        int englishMarks;
        int psychologyMarks;
        int biologyMarks;

        Science (String studentName, int mathMarks, int historyMarks, int englishMarks, int psychologyMarks, int biologyMarks) {
            this.studentName = studentName;
            this.mathMarks = mathMarks;
            this.historyMarks = historyMarks;
            this.englishMarks = englishMarks;
            this.psychologyMarks = psychologyMarks;
            this.biologyMarks = biologyMarks;
        }

        String getStudentName() {
            return studentName;
        }
        int getMathMark() {
            return mathMarks;
        }



    }

    class SciMarks {
        int mathMark1;

        public SciMarks(int mathMark1) {
            this.mathMark1 = mathMark1;
         }

        public int getMathMark1() {
            return mathMark1;
        }

        public void setMathMark1(int mathMark1) {
            this.mathMark1 = mathMark1; // класс с полем оценок
        }

     }
    public static void main(String[] args) {
        Science student1 = new Science ("Иванов", 67, 76, 43, 67, 78);
        Science student2 = new Science ("Петров", 56, 63, 79, 86, 56);
        Science student3 = new Science ("Сидоров", 87, 76, 57, 67, 63);
        Science student4 = new Science ("Козлов", 80, 54, 78, 65, 92);
        Science student5 = new Science ("Трянов", 78, 99, 87, 76, 54);
        Science student6 = new Science ("Абрамов", 75, 69, 89, 61, 81);

        ArrayList<Integer> marksStudent1 =new ArrayList<Integer>();
        Collections.addAll(marksStudent1, student1.mathMarks, student1.biologyMarks, student1.englishMarks, student1.historyMarks, student1.psychologyMarks);


        ArrayList<Integer> marksStudent2 =new ArrayList<Integer>();
        Collections.addAll(marksStudent2, student2.mathMarks, student2.biologyMarks, student2.englishMarks, student2.historyMarks, student2.psychologyMarks);

        ArrayList<Integer> marksStudent3 =new ArrayList<Integer>();
        Collections.addAll(marksStudent3, student3.mathMarks, student3.biologyMarks, student3.englishMarks, student3.historyMarks, student3.psychologyMarks);

        ArrayList<Integer> marksStudent4 =new ArrayList<Integer>();
        Collections.addAll(marksStudent4, student4.mathMarks, student4.biologyMarks, student4.englishMarks, student4.historyMarks, student4.psychologyMarks);

        ArrayList<Integer> marksStudent5 =new ArrayList<Integer>();
        Collections.addAll(marksStudent5, student5.mathMarks, student5.biologyMarks, student5.englishMarks, student5.historyMarks, student5.psychologyMarks);

        ArrayList<Integer> marksStudent6 =new ArrayList<Integer>();
        Collections.addAll(marksStudent6, student6.mathMarks, student6.biologyMarks, student6.englishMarks, student6.historyMarks, student6.psychologyMarks);

        Map<String, ArrayList <Integer>> journal = new HashMap<>();
        journal.put (student1.getStudentName(), marksStudent1);
        journal.put (student2.getStudentName(), marksStudent2);
        journal.put (student3.getStudentName(), marksStudent3);
        journal.put (student4.getStudentName(), marksStudent4);
        journal.put (student5.getStudentName(), marksStudent5);
        journal.put (student6.getStudentName(), marksStudent6);



          for (ArrayList<Integer> i : journal.values()) {
              int marksSum = 0;
              for (int j=0; j < marksStudent1.size(); j++) {
                  marksSum += marksStudent1.get(j);
              }
              for (int j=0; j < marksStudent2.size(); j++) {
                  marksSum += marksStudent2.get(j);
              }
              for (int j=0; j < marksStudent3.size(); j++) {
                  marksSum += marksStudent3.get(j);
              }
              for (int j=0; j < marksStudent3.size(); j++) {
                  marksSum += marksStudent4.get(j);
              }
              for (int j=0; j < marksStudent5.size(); j++) {
                  marksSum += marksStudent5.get(j);
              }
              for (int j=0; j < marksStudent6.size(); j++) {
                  marksSum += marksStudent6.get(j);
              }
            double averageValue = ((double) marksSum / journal.size());
              System.out.println("Общий средний балл по всем предметам " + averageValue);
        }

            for (ArrayList <Integer> i : journal.values()) {
                int marksMathSum = 0;
                for (int j=0; j < marksStudent1.size(); j++) {
                    if (marksStudent1.contains(student1.mathMarks)) {
                        marksMathSum += marksStudent1.get(j);
                        break;
                    }
                }
                for (int j=0; j < marksStudent2.size(); j++) {
                    if (marksStudent2.contains(student2.mathMarks)) {
                        marksMathSum += marksStudent2.get(j);
                        break;
                    }
                }
                for (int j=0; j < marksStudent3.size(); j++) {
                    if (marksStudent3.contains(student3.mathMarks)) {
                        marksMathSum += marksStudent3.get(j);
                        break;
                    }
                }
                for (int j=0; j < marksStudent4.size(); j++) {
                    if (marksStudent4.contains(student4.mathMarks)) {
                        marksMathSum += marksStudent4.get(j);
                        break;
                    }
                }
                for (int j=0; j < marksStudent5.size(); j++) {
                    if (marksStudent5.contains(student5.mathMarks)) {
                        marksMathSum += marksStudent5.get(j);
                        break;
                    }
                }
                for (int j=0; j < marksStudent6.size(); j++) {
                    if (marksStudent6.contains(student6.mathMarks)) {
                        marksMathSum += marksStudent6.get(j);
                        break;
                    }
                }
                double averageMath = ((double) marksMathSum / journal.size());
                System.out.println("Общий средний балл по математике составляет " + averageMath);
            }

        for (ArrayList <Integer> i : journal.values()) { //вычисление среднего балла по биологии
            int marksBiologySum = 0;
            for (int j=0; j < marksStudent1.size(); j++) {
                if (marksStudent1.contains(student1.biologyMarks)) {
                    j = marksStudent1.indexOf(student1.biologyMarks);
                    marksBiologySum += marksStudent1.get(j);
                    break;
                }
            }
            for (int j=0; j < marksStudent2.size(); j++) {
                if (marksStudent2.contains(student2.biologyMarks)) {
                    j = marksStudent2.indexOf(student2.biologyMarks);
                    marksBiologySum += marksStudent2.get(j);
                    break;
                }
            }
            for (int j=0; j < marksStudent3.size(); j++) {
                if (marksStudent3.contains(student3.biologyMarks)) {
                    j = marksStudent3.indexOf(student3.biologyMarks);
                    marksBiologySum += marksStudent3.get(j);
                    break;
                }
            }
            for (int j=0; j < marksStudent4.size(); j++) {
                if (marksStudent4.contains(student4.biologyMarks)) {
                    j = marksStudent4.indexOf(student4.biologyMarks);
                    marksBiologySum += marksStudent4.get(j);
                    break;
                }
            }
            for (int j=0; j < marksStudent5.size(); j++) {
                if (marksStudent5.contains(student5.biologyMarks)) {
                    j = marksStudent5.indexOf(student5.biologyMarks);
                    marksBiologySum += marksStudent5.get(j);
                    break;
                }
            }
            for (int j=0; j < marksStudent6.size(); j++) {
                if (marksStudent6.contains(student6.biologyMarks)) {
                    j = marksStudent6.indexOf(student6.biologyMarks);
                    marksBiologySum += marksStudent6.get(j);
                    break;
                }
            }
            double averageBiol = ((double) marksBiologySum / journal.size());
            System.out.println("Общий средний балл по биологии составляет " + averageBiol);
        }

        for (ArrayList <Integer> i : journal.values()) { // вычисление среднего балла по английскому
            int marksEnglSum = 0;
            for (int j=0; j < marksStudent1.size(); j++) {
                if (marksStudent1.contains(student1.englishMarks)) {
                    j = marksStudent1.indexOf(student1.englishMarks);
                    marksEnglSum += marksStudent1.get(j);
                    break;
                }
            }
            for (int j=0; j < marksStudent2.size(); j++) {
                if (marksStudent2.contains(student2.englishMarks)) {
                    j = marksStudent2.indexOf(student2.englishMarks);
                    marksEnglSum += marksStudent2.get(j);
                    break;
                }
            }
            for (int j=0; j < marksStudent3.size(); j++) {
                if (marksStudent3.contains(student3.englishMarks)) {
                    j = marksStudent3.indexOf(student3.englishMarks);
                    marksEnglSum += marksStudent3.get(j);
                    break;
                }
            }
            for (int j=0; j < marksStudent4.size(); j++) {
                if (marksStudent4.contains(student4.englishMarks)) {
                    j = marksStudent4.indexOf(student4.englishMarks);
                    marksEnglSum += marksStudent4.get(j);
                    break;
                }
            }
            for (int j=0; j < marksStudent5.size(); j++) {
                if (marksStudent5.contains(student5.englishMarks)) {
                    j = marksStudent5.indexOf(student5.englishMarks);
                    marksEnglSum += marksStudent5.get(j);
                    break;
                }
            }
            for (int j=0; j < marksStudent6.size(); j++) {
                if (marksStudent6.contains(student6.englishMarks)) {
                    j = marksStudent6.indexOf(student6.englishMarks);
                    marksEnglSum += marksStudent6.get(j);
                    break;
                }
            }
            double averageEngl = ((double) marksEnglSum / journal.size());
            System.out.println("Общий средний балл по английскому составляет " + averageEngl);
        }



        //for(Science x:all){
           // SciMarks math = all.get(x.getMathMark());
         //   int allMathMarks = x.getMathMark() + math.getMathMark1();
         //   }
         //   else {
         //       allMathMarks.put(x.getStudentName(), new SciMarks(x.getMathMark()));
       //     }
     //   }
     //   for (Map.Entry<String, SciMarks> map:allMathMarks.entrySet()) { // расчет среднего значения
     //       SciMarks allSum = map.getValue();
     //       double avg = ((double) allSum.getMathMark1()/all.size());
    //        System.out.println("Cтудент " + map.getKey() + " средний бал по всем математике " +avg);
        }

    }

