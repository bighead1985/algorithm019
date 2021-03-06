**学习笔记**


二叉树
------

####特点

- 每个节点最多有2棵子树，不存在度大于2的节点
- 要区分左子树和右子树的顺序，不能随意颠倒

```
        A     A
       /        \
      B          B
      
上述两棵树是完全不同的
```
    
####特殊形态


- 斜树

```
        A 
       /     
      B 
     /         
    C
```  
  
- 满二叉树

```
        o 
       /  \   
      o    o
     / \   /\     
    o   o o  o 
```    

- 完全二叉树

```
        o 
       /  \   
      o    o
     / \   /     
    o   o o  
```    

####性质

- 性质1：在二叉树的第i层上最多有2^i-1个节点
- 性质2：深度为k的二叉树最多有2^k -1 个节点
- 性质3：对任何一棵二叉树T,终端节点数量为n0, 度为2的节点数为n2,则n0 = n2+1
- 性质4：具有n个节点的完全二叉树的深度为[log2n]+1([x]表示不大于x的最大正整数)
- 性质5：n个节点的完全二叉树按层序编号，对任一节点i有（1<=i<=n）
  
  - 如果i=1，则节点i是根，如果i>1,则双亲节点是[i/2]
  - 如果2i>n ,则节点i无左孩子（节点i为叶子节点）；否则其左孩子是节点2i
  - 如果2i+1 >n ,则节点i无右孩子；否则其右孩子是节点2i+1
  
####二叉树的存储结构
- 数组
- 链表

####二叉树的遍历
- 前序遍历 root->left->right
- 中序遍历 left->root->right
- 后序遍历 left->right->root
- 层序遍历 level1->level2->....->leveln



二叉搜索树(BST)
------

####特点
- 若其左子树存在，则其左子树中每个节点的值都不大于该节点值；
- 若其右子树存在，则其右子树中每个节点的值都不小于该节点值。


二叉堆
------

####特点
- 完全二叉树
- 父节点的值小于所有子节点的值（小顶堆，最小堆）
- 父节点的值大于所有子节点的值（大顶堆，最大堆）
- 顺序存储


####操作
- 插入节点
- 上浮节点
- 删除节点
- 下沉节点
- 构建二叉堆
