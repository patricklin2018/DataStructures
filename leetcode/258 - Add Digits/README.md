##Add Digits

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:<br>
Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:<br>
Could you do it without any loop/recursion in O(1) runtime?

##Solution

####solution 1:
通过计算，我们发现：

Number|1|2|3|4|5|6|7|8|9
------|---|---|---|---|----|----|----|---|---
Digit Root|1|2|3|4|5|6|7|8|9

Number|10|11|12|13|14|15|16|17|18
------|---|---|---|---|---|---|---|---|---
|Digit Root|1|2|3|4|5|6|7|8|9


Number|19|20|21|22|23|24|25|26|27
------|---|---|---|---|---|---|---|---|---
Digit Root|1|2|3|4|5|6|7|8|9


Number 以 9 为周期，循环得到 1-9 的 Digit Root。

```cpp
int addDigits(int num) {
    return num ? (num % 9 == 0 ? num % 9 + 1 : num % 9) : 0;
}
```

####solution 2:
关于 `Digit Root`， <https://en.wikipedia.org/wiki/Digital_root>。

经过学习，知 `dr(n) = n - 9 * [( n - 1 ) / 9]`。

```cpp
int addDigits(int num) {
    return num - 9 * (( num - 1 ) / 9 );
}
```

