HashMap总结
------

- HashMap采用Entry数组来存储key-value对，每一个键值对组成了一个Entry实体，Entry类实际上是一个单向的链表结构，它具有Next指针，可以连接下一个Entry实体，以此来解决Hash冲突的问题

- 构造方法

```
    HashMap()    //无参构造方法
    HashMap(int initialCapacity)  //指定初始容量的构造方法 
    HashMap(int initialCapacity, float loadFactor) //指定初始容量和负载因子
    HashMap(Map<? extends K,? extends V> m)  //指定集合，转化为HashMap
 ```
 
- 添加方法

```
public V put(K key, V value) {
    //调用putVal()方法完成
    return putVal(hash(key), key, value, false, true);
}

final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
               boolean evict) {
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    //判断table是否初始化，否则初始化操作
    if ((tab = table) == null || (n = tab.length) == 0)
        n = (tab = resize()).length;
    //计算存储的索引位置，如果没有元素，直接赋值
    if ((p = tab[i = (n - 1) & hash]) == null)
        tab[i] = newNode(hash, key, value, null);
    else {
        Node<K,V> e; K k;
        //节点若已经存在，执行赋值操作
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
        //判断链表是否是红黑树
        else if (p instanceof TreeNode)
            //红黑树对象操作
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        else {
            //为链表，
            for (int binCount = 0; ; ++binCount) {
                if ((e = p.next) == null) {
                    p.next = newNode(hash, key, value, null);
                    //链表长度8，将链表转化为红黑树存储
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);
                    break;
                }
                //key存在，直接覆盖
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }
    //记录修改次数
    ++modCount;
    //判断是否需要扩容
    if (++size > threshold)
        resize();
    //空操作
    afterNodeInsertion(evict);
    return null;
}

1.如果当前map中没有数据，执行resize方法
2.如果要插入的键值对要存放的位置上刚好没有元素，那么就把它封装成Node对象，并放在这个位置上。
3.如果发生碰撞，判断node的类型是红黑树还是链表：
    3.1 如果为红黑树，则将K-V对插在红黑树对应的位置。
    3.2 如果为链表，遍历链表：
　       a.如果为链表最后一个node ,则将新的node节点插入到链表尾
　       b.插入完，如果链表的node数量大于8，则将链表转为红黑树的操作；如果当前哈希表为空或数组长度小于64，会扩容，否则转化为红黑树。转化的过程：先遍历链表 ，将链表的节点转化为红黑树的节点；然后将链表转化为红黑树。
         c.遍历链表时，如果key已存在，则直接bredk循环。
4.判断是否要扩容
5.返回

```



