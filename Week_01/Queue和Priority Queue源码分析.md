`Queue源码分析`

Queue接口的定义比较简单，实现了一个基本队列，主要包括以下方法：

- boolean offer(E e)
- E remove()
- E poll()
- E element()
- E peek()

这里要注意一下element()和peek()的区别，前者如果队列为空会抛出异常，后者则会返回null.

Queue主要有下面几个实现类：

 * LinkedList
 * PriorityQueue
 * LinkedBlockingQueue
 * ArrayBlockingQueue
 * PriorityBlockingQueue
 
 
 `PriorityQueue源码分析`
 
 PriorityQueues基于对象的优先级来实现队列的出入，优先级主要通过实现Comparator接口来定义，底层算法是通过一个二叉小顶堆来实现的
 （后面课程学到的时候再深入分析 ）
 - 优先队列的头是基于自然排序或者Comparator排序的最小元素。如果有多个对象拥有同样的排序，那么就可能随机地取其中任意一个。当我们获取队列时，返回队列的头对象
 - 优先队列的大小是不受限制的，但在创建时可以指定初始大小
 - PriorityQueue是非线程安全的，所以Java提供了PriorityBlockingQueue