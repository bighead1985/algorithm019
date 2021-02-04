package leetcode.mid;

import java.util.*;

/**
 * Description: 721.账户合并
 * User: liqing@pluosi
 * Date: 2021-02-04
 * Time: 10:53 PM
 */
public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        //存储每个邮箱账户的索引值
        Map<String, Integer> emailToIndex = new HashMap<>();

        //存储每个邮箱账户对应的账户名称
        Map<String, String> emailToName = new HashMap<>();
        int emailsCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }

        //根据邮箱账户的索引使用并查集来进行合并
        UnionFind uf = new UnionFind(emailsCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                uf.union(firstIndex, nextIndex);
            }
        }

        //将邮箱账号按照根节点的索引值放入hash表中
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<>());
            account.add(email);
            indexToEmails.put(index, account);
        }

        //最后将哈希表转换成题目要求的格式进行输出
        List<List<String>> merged = new ArrayList<>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int index1, int index2) {
            parent[find(index2)] = find(index1);
        }

        public int find(int index) {
            if (parent[index] != index) {
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }
    }


}