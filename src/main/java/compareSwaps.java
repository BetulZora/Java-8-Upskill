public class compareSwaps {

    static int a,b;

    public static void main(String[] args) {

        a = 10;
        b = 40;

        swap(a,b);
        System.out.println("a: " + a + ", b: "+ b);


    }

    static void swap(int c, int d){
        int temp = a;
        a = d;
        b = temp;
    }


}
