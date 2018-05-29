##319. Bulb Switcher

There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

**Example:**
```
Given n = 3. 

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off]. 

So you should return 1, because there is only one bulb is on.
```

##Solution
按照常规模拟计算发现超时，所以肯定有规律可循。

电灯数|Result
-----|------
1-3|1
4-8|2
9-15|3
16-24|4
25-35|5

可以发现，其实就是寻找平方根。

```cpp
int bulbSwitch(int n) {
    return sqrt(n);
}
```