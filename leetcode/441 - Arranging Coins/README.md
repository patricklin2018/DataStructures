##Arranging Coins

You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

**Example 1:**
```
n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
```
**Example 2:**
```
n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
```

##Solution

####1.
O(1)算法，根据 `(1 + 2 + …… + k) = n` 公式求出 k。 
```cpp
int arrangeCoins(int n) {
    return -0.5 + sqrt((long)2 * n + 0.25);
}
```

####2.
O(n)算法，一排排去递减。
```cpp
int arrangeCoins(int n) {
    int level = 0;
	while (n > 0){
		n -= ++level;
	}
	return n == 0 ? level : level - 1;
}
```