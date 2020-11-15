import java.util.*;

/**
 * Description:
 * User: liqing@pluosi
 * Date: 2020-11-15
 * Time: 12:49 PM
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {

        //构造HashMap，存放每个数字的出现次数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num:nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        //构造优先队列，将当前数字和对应的次数放入优先队列
        Queue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){

            int num = entry.getKey();
            int count = entry.getValue();

            queue.offer(new int[]{num,count});

            while(queue.size()>k){
                queue.poll();
            }
        }


        //取出优先队列的前k个元素放入数组
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;

    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new TopKFrequent().topKFrequent(new int[]{1,1,-1,-1,-1,2,3,3,3,3,4},3)));

    }
}
