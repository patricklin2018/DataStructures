##Nim Game

You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time
one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You
will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether 
you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 
stones you remove, the last stone will always be removed by your friend.

##Solution
石头数|胜利者
-----|------
1-3|win
4|lost
5-7|win
8|lost
9-11|win
12|lost

其中不难发现，`win` 和 `lost` 以 4 为周期循环更替。周期前 3 个数为 `win`，第 4 个数为 `lost`

```cpp
bool canWinNim(int n) {
    return n % 4 != 0;
}
```

###Nim 加法：
如果每次可以有多堆石头，每次玩家可以拿走一堆或者同一堆里不限个石头，取走最后一堆者获胜。

这就是`Nim 加法`（<http://www.guokr.com/blog/777525/>）

`Nim 加法`就是首先将各堆石头的数量用二进制表示，然后进行`Nim 加法`(异或)。如果存在办法将和变为 0 则存在必胜策略，反之则后手者存在必胜策略。

其中我们发现：

1. 可以证明,只要`Nim 加法`和不为 0 时，总存在至少一种方法使其变成 0。
2. `Nim 加法` 的和在 0 和 非0 之间一直循环更替，故和为 非0 时，先手者总是能够将和变为 0，直到获胜。

所以结论就是，进行`Nim 加法`（异或），若和不为 0 先手者存在必胜策略，反之则后手者存在必胜策略。

```cpp
bool canWinNim(const int* stone, const int count){
    int n = 0;
    for (int i = 0; i < count; i++) {
        n ^= stone[i];
    }
    return n != 0;
}
```