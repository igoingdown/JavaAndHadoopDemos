## Summary:

This package is developed when I take course provided by ValleyGo
.

Some algorithm problems are solved with java.


-----
## Problems and Note

#### Top N Numbers

`
Given m lines, each line have n numbers, if you choose one from each line and add them up, you could have n^m different ways. Please give the largest n results of these results. The output need to also in descending order.
Examples: m= 3, n = 3 587
295
023
Result:

[20, 19, 19]

Hint: 20 = 8 + 9 + 3, 19 = 7 + 9 + 3, 19 = 8 + 9 + 2
`
##### 注意
* 大根堆小根堆相应的判别条件要对上！
* 维护一个大小为n的小根堆
* 先把堆中元素挨个输出（相当于排序），与下一行按照sum进行merge，merge到大小为n的小根堆中
* 重复上面的步骤知道最后一行merge进去。



