import java.util.PriorityQueue;

/**
 * Description:剑指 Offer 49. 丑数
 * Date: 2020-11-15
 * Time: 12:30 PM
 */
public class NthUglyNumber {

    public int nthUglyNumber(int n) {


        int[] uglyArr = new int[]{2, 3, 5};
        PriorityQueue<Long> queue = new PriorityQueue<>();
        int count = 0;
        queue.offer(1L);

        while (!queue.isEmpty()) {
            long cut = queue.poll();
            if (++count >= n) {
                return (int) cut;
            }

            for (int i : uglyArr) {

                if (!queue.contains(i * cut)) {
                    queue.offer((i * cut));
                }

            }

        }
        return -1;


    }


    public static void main(String[] args) {

        System.out.println(new NthUglyNumber().nthUglyNumber(10));

    }

}
