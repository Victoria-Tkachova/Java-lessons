import java.util.Arrays;

public class commonElements {
    public static void main(String[] args) {
        int diap1a = 100;
        int diap1b = 25;
        int diap2a = 20;
        int diap2b = 110;
        int diap1min = diap1a < diap1b ? diap1a : diap1b;
        int diap1max = diap1a < diap1b ? diap1a : diap1b;
        int diap2min = diap2a < diap2b ? diap2a : diap2b;
        int diap2max = diap2a < diap2b ? diap2a : diap2b;

        int[] diapason1 = new int[diap1max-diap1min];
        for (int i = diap1min; i < diapason1.length; i++);
        int [] diapason2= new int [diap2max-diap2min];
        for (int j=diap2min; j < diapason2.length; j++);

        int[] commonNumbers = duplicateElements(diapason1, diapason2);
        System.out.println("Common numbers:");
        for (int i = 0; i < commonNumbers.length; i++) {
            System.out.println(commonNumbers[i]);
        }
    }

    public static int[] duplicateElements (int[] ...elements1) {
       int [] result = null;
        int res = 0;
        int sizeTotal=0;
        for(int[] temp:elements1){
          sizeTotal+= temp.length;//equals  sizeTotal=sizeTotal+temp.length
        }
        int[] fullArray = new int [sizeTotal];
        int j=0;
        for (int i=0; i<elements1.length; i++) {
           for(int temp:elements1[i]) {
            fullArray[j]= temp;
            j++;
           }
        }
        int calcucateElements [][] = new int [fullArray.length] [2];
        for (int i=0; i<fullArray.length; i++){
            calcucateElements[i][1]=counter(i,fullArray);
            if (calcucateElements[i][1]>1){
               res++;
              }
              result= new int [res];
              for (int k=0; k<result.length; k++) {
                  if (calcucateElements[i][1]>1) {
                      result[k]=calcucateElements[i][0];
                  }
              }
        }
        return result;
        }
    public static int counter(int indexElement, int[] wholelArray) {
        int count=0;
        int value = wholelArray[indexElement];
        for (int temp:wholelArray) {
            if(value==temp){
                count++;
            }
        }
        return count;
    }

    int[] findCommon(int start1,int end1,int start2,int end2){
        int[] result;
        int[] arr1=createArray(start1,end1);
        int[] arr2=createArray(start2,end2);
        int sizeResult=0;
        for(int temp:arr1){
            if(findElement(temp,arr2)){
                sizeResult++;
            }
        }
        result=new int[sizeResult];
        int j=0;
        for(int temp:arr1){
            if(findElement(temp,arr2)){
                result[j]=temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    private int[] createArray(int start1, int end1) {
        int[] result;
        int start=start1>end1?end1:start1;
        int end=start1>end1?start1:end1;
        int size=Math.abs(end -start);
        result=new int[size+1];
        for(int i=0;i<=size;i++){
            result[i]=start++;
        }
        // System.out.println("* "+Arrays.toString(result));
        return result;
    }

    private boolean findElement(int element, int[] arr2) {
        boolean result=false;
        for(int temp:arr2){
            if(temp==element){
                result=true;
                break;
            }
        }
        return result;

    }
    }





class User{
 private   static int count;

  User(){
      count++;
  }

static int getCount(){
      return count;
}
}