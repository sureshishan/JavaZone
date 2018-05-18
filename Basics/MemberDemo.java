public class MemberDemo{
    static int i;
    static double d;
    static char c;
    public static void main(String args[]){
        int a;
        a = 10;
        int b=a;
        int i = this.i;
       
        System.out.println(i);
        System.out.println(d);
        System.out.println(c);
        System.out.println(a);
        System.out.println(b);
    }
}