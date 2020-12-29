import java.util.*;

/**
 * Description: 力扣排行榜
 * User: liqing
 * Date: 2020-12-27
 * Time: 5:40 PM
 */
public class Leaderboard {


    PriorityQueue<Integer> queue;
    Map<Integer, Integer> cache;


    public Leaderboard() {
        //构造小顶堆
        this.queue = new PriorityQueue<>((p1, p2) -> p1 - p2);
        this.cache = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        this.cache.put(playerId, cache.getOrDefault(playerId, 0) + score);
    }

    public int top(int k) {
        int counter = 0;
        for (int score : cache.values()) {
            Integer num = queue.peek();
            if (queue.isEmpty()) {
                queue.offer(score);
                counter++;

            }else if (null != num ) {
                if (counter >= k) {
                    if(score > num) {
                        queue.poll();
                        queue.offer(score);
                    }
                }else{
                    queue.offer(score);
                    counter++;
                }
            }
        }

        int total =  queue.stream().mapToInt(i->i).sum();
        queue.clear();
        return total;
    }

    public void reset(int playerId) {
        this.cache.put(playerId, 0);
    }

    public static void main(String[] args) {

//        ["Leaderboard","addScore","addScore","addScore","addScore","addScore","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","addScore","top","reset","reset","addScore","reset"]
//        [[],[1,13],[2,93],[3,84],[4,6],[5,89],[6,31],[7,7],[8,1],[9,98],[10,42],[5],[1],[2],[3,76],[4,68],[1],[3],[4],[2,70],[2]]

        Leaderboard lb = new Leaderboard();
        lb.addScore(1,13);
        lb.addScore(2,93);
        lb.addScore(3,84);
        lb.addScore(4,6);
        lb.addScore(5,89);

        lb.addScore(6,31);
        lb.addScore(7,7);
        lb.addScore(8,1);
        lb.addScore(9,98);
        lb.addScore(10,42);

        System.out.println(lb.top(5));
        lb.reset(1);
        lb.reset(2);
        lb.addScore(3,76);
        lb.addScore(4,48);
        System.out.println(lb.top(1));
        lb.reset(3);
        lb.reset(4);
        lb.addScore(2,70);
        lb.reset(2);
    }
}
