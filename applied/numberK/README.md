## Number K

> 从任意数组中，找到第 k 大的元素的值

> ex：
> arr = [0, 2, 3, 9, 6], k = 1
> 即寻找 arr 数组中 最大 的元素，结果为 9

#### 思路

根据三路快速排序的思想，求出 partition 操作后，大于或小于标定的索引，并根据该索引缩小查找的范围。

#### 实现
实现类：

[numberK.java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/applied/numberK/numberK.java)

测试辅助用类：

[TestHelper.java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/applied/numberK/TestHelper.java)

#### 实验
```
测试1：随机数组 N = 10000
测试1 通过！

测试2：含有许多相等元素的数组 N = 10000
测试2 通过！
```