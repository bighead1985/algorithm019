import java.util.ArrayList;
import java.util.List;

/**
 * Description: 组合
 * Date: 2020-11-20
 * Time: 10:10 PM
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();

        //terminator
        if (n <= 0 || n < k || k == 0) {
            return res;
        }

        //process

        //if choose the n'th num
        res = combine(n - 1, k - 1);
        if (res.isEmpty()) {
            res.add(new ArrayList<>());
        }

        for (List<Integer> list : res) {
            list.add(n);
        }


        //if not choose the n'th num
        res.addAll(combine(n - 1, k));
        return res;


    }

    public static void main(String[] args) {
        System.out.println(new Combine().combine(6, 2));
    }
}
