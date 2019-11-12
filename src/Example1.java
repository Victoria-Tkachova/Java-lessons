public class Example1 {

    public static void main(String[] args) {
        int a=1;
        Month mon=Month.Лютий;
        int[] arr={1,3,4,5,7};
        int i = 0;
        for (int temp:arr) {
            arr[i]=33;
            System.out.println(arr[i]);
            i++;


        }
        label1:for (int r=0;i<arr.length;i=+2){
            for(int w=0;w<5;w++){
if(w==1){
    break label1 ;
}
            }
        }

        mon.one();
        int b=a>30?35:0;
        if (a>30){
            b=35;
        }
        else {
            b=0;
        }
        int n=0;
        while (n<30 ){
            if (n%2==0){
                System.out.println(n);
        }
            n++;
        }
        String val="sddsdsd";
        Month month=Month.Січень;
        switch (month){
            case Лютий:{
                System.out.println(1);
                break;
            }
            case Січень:{
                System.out.println(2);
                break;
            }
            default:{
                System.out.println("dsdsd");
            }

        }

    }
    void changeRotation (int[] list, int index1, int index2) {
     int temp=list[index1];
        list[index1]=list[index2];
     list[index2]=temp;

    }

}

enum Month{
    Січень(1),Лютий(2);

    Month(int number) {
        this.number = number;
    }

    int number;
    void one(){
        System.out.println(number);
    }
}

//  3,7,8,1,3    1,7,8,3,3    1,3,8,3,7  1,3,3,8,7  1,3,3,7,8