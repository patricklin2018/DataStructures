##Sum Of Two Integers

Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.

##Solution

我们知道，二进制只有 0 和 1 两个数字，那么两数相加只有三种情况，要么`0 + 0`，要么`1 + 0`，要么`1 + 1`。

`1 + 1`情况，我们可以采用位与操作，再进行左移 1 位。

`0 + 1`，以及`0 + 0`情况，我们可以采用异或操作。

所得结果继续下一轮循环计算，直到位与操作结果为 0（即没有需要进位的了）。

具体步骤可以如下表示，假设我们计算 3 ＋ 1。用二进制表示则是：

0 1 1


0 0 1

步骤|操作|结果
---|---|---
1|异或|0 1 0
1|位与并左移一位|0 1 0
2|异或|0 0 0
2|位与并左移一位|1 0 0
3|异或|1 0 0
3|位与并左移一位|0 0 0


```cpp
int getSum(int a, int b) {
    if (a == 0 || b == 0) {
        return a ^ b;
    }
    while (b != 0) {
        int carry = a & b;
        a ^= b;
        b = carry << 1;
    }
    return a;
}
```

###进一步实现减法，乘法，除法

###1. 减法：
减法的运算过程与加法类似，不同的是，减法一共有四种情况，分别是`1 - 1`,`0 - 0`,`1 - 0`,`0 - 1`。

`1 - 1`,`0 - 0`,`1 - 0`,三种情况均可以采用异或操作得出结果。

`0 - 1`，可以对前者采用非操作，然后与后者进行位与计算，得出需要借数的位置，并左移 1 位。

同样将结果进入下一轮循环的计算，直到所需借数为 0。演示如下，计算 12 － 5：

1 1 0 0

0 1 0 1

步骤|操作|结果
---|---|---
1|异或|1 0 0 1
1|非操作然后进行位与并左移一位|0 0 1 0
2|异或|1 0 1 1
2|非操作然后进行位与并左移一位|0 1 0 0
3|异或|1 1 1 1
3|位与并左移一位|1 0 0 0
4|异或|0 1 1 1
3|位与并左移一位|0 0 0 0

该计算方法同样适用于 5 - 12。在二进制表示负数的方法为，原码 －> 反码 －> 补码 (~X + 1)。

```cpp
int getSubstract(int a, int b){
    while (b != 0) {
        int borrow = (~a) & b;
        a ^= b;
        b = borrow << 1;
    }
    
    return a;
}
```

###2. 乘法：

```cpp
int getMutiple(int a, int b){
    int n = 0;
    while (a != 0 && b != 0) {
        n = getSum(n, a);
        b = getSubstract(b, 1);
    }
    return n;
}
```

###3. 除法：

除法需要注意的是，只能计算整除。

```cpp
int getDivision(int a, int b){
    int n = 0;
    while (a != 0) {
        a = getSubstract(a, b);
        n = getSum(n, 1);
    }
    return n;
}
```