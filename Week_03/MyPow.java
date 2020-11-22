/**
 * Description:50.Pow(x,n)
 * Date: 2020-11-17
 * Time: 9:59 PM
 */
public class MyPow {

    public double myPow(double x, int n) {

        long l = n;
        return l > 0 ? _pow(x, l) : 1 / _pow(x, -l);
    }

    private double _pow(double x, long l) {

        if (l == 0) {
            return 1.0;
        }

        double y = _pow(x, l / 2);

        return l % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(2, 5));
    }
}
