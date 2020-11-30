##学习笔记

####广度优先遍历（BFS）VS 深度优先遍历（DFS）
广度优先更加符合人脑的思维，一个比较形象的解释就是搜索路径像一个水波纹一样一层一层的扩散，直到最底层

分别使用BFS和DFS对二叉树进行层序遍历的代码片段如下：


```
void bfs(TreeNode root) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }
}

```

```

void dfs(TreeNode root){
    if (root == null) {
        return;
    }
    dfs(root.left);
    dfs(root.right);
}

```

- DFS的代码非常简洁，因为使用了递归，不需要自己维护栈
- BFS的代码稍显繁琐，但是符合人类的思维，比较容易理解

####贪心算法（Greedy Algorithm)
寻找最优解问题的常用方法，这种方法模式一般将求解过程分成若干个步骤，但每个步骤都应用贪心原则，选取当前状态下最好/最优的选择（局部最有利的选择），并以此希望最后堆叠出的结果也是最好/最优的解。

在一个比较典型的背包最大价值的问题中， 我们可选的策略有以下几种：
- 价值主导选择，每次都选价值最高的物品放进背包；
- 重量主导选择，每次都选择重量最轻的物品放进背包；
- 价值密度主导选择，每次选择都选价值/重量最高的物品放进背包。

优点：简单，高效，省去了为了找最优解可能需要穷举操作，通常作为其它算法的辅助算法来使用；
缺点：不从总体上考虑其它可能情况，每次选取局部最优解，不再进行回溯处理，所以很少情况下得到最优解。

####二分查找（Binary Search）
二分查找算法相对来说是很容易理解的一个种算法，代码模版如下：

```
public static int binary(int[] arr, int data) {
        int min = 0;
        int max = arr.length - 1;
        int mid;
        while (min <= max) {
            // 防止溢出，加法变减法
            mid =  min + (max - min) / 2;
            if (arr[mid] > data) {
                max = mid - 1;
            } else if (arr[mid] < data) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

```

要使用二分查找，需要满足下列条件：
- 有序
- 单调
- 有上下界
- 可以通过索引访问元素


