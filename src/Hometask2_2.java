public class Hometask2_2 {
    public static void main(String[] args) {
        int[] home = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int v = 3;
        int[] c = getDivisionElements (home, v);
        System.out.println("Result: ");
        for (int i=0; i<c.length; i++){
            System.out.print(c[i]);
        }
    }

    public static int[] getDivisionElements (int[] home, int v) {
       int value = 0;
       for (int i=0; i<home.length; i++){
           if (home[i]%v == 0) {
               value ++;
           }
       }
        int[] res = new int[value];
        int j=0;
        for (int i = 0; i < home.length; i++) {
            if (home[i] % v == 0) {
                res[j] = home[i];
                j++;
            }
        }

        return res;
    }
}
