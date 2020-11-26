/**
 * Description:
 * User: liqing@pluosi
 * Date: 2020-11-26
 * Time: 6:59 PM
 */
public class MySqrt {

    int s;

    public int mySqrt(int x) {
        s = x;
        if (x == 0) return 0;
        return ((int) (sqrts(x)));
    }

    public double sqrts(double x) {
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrts(res);
        }
    }

    public static void main(String[] args) {
        System.out.println(new MySqrt().sqrts(4d));
    }
}
