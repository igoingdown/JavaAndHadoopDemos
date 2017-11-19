## Summary:

This package is developed when I take course provided by ValleyGo
.

Some algorithm problems are solved with java.


-----
## Problems and Note

#### Top N Numbers

```
Given m lines, each line have n numbers, if you choose one from each line and add them up, you could have n^m different ways. Please give the largest n results of these results. The output need to also in descending order.
Examples: m= 3, n = 3 587
295
023
Result:

[20, 19, 19]

Hint: 20 = 8 + 9 + 3, 19 = 7 + 9 + 3, 19 = 8 + 9 + 2
```
##### 注意
* 大根堆小根堆相应的判别条件要对上！
* 维护一个大小为n的小根堆
* 先把堆中元素挨个输出（相当于排序），与下一行按照sum进行merge，merge到大小为n的小根堆中
* 重复上面的步骤知道最后一行merge进去。


#### leetcode 332. Reconstruct Itinerary

```
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
```

##### 注意

* DFS和heap结合
* path先添加无路可走的节点，使用链表的头插法

