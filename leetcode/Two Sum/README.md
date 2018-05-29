###Two Sum
***
**Quiestion:**

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

**Example:**

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].

**UPDATE (2016/2/13):**

The return format had been changed to zero-based indices. Please read the above updated description carefully.
***

###solution:

一开始想到的是两层遍历，直接验证相加是否等于`target`。显然时间复杂度`O[n^2]`过高,不符合题目要求。

####solution 1
**总体思路：**

将数据排序，左右指针分别指向最小，最大值，若其和小于`target`，则左指针右移，反之右指针左移，直到和为`target`。

**步骤：**

1. 建立新向量容器
2. 将传入数据，以及下标序号传入新容器
3. 排序
4. 建立左右指针，分别指向最小指，最大值
5. 循环判断：左右指针指向值的和，若大于`target`则右指针左移，若小于`target`则左指针右移，否则退出循环。
6. 返回左右指针的下标序号

[solution1.cpp](https://github.com/PatrickLin1993/LeetCode/blob/master/Algorithmn/Two%20Sum/resolution1.cpp)

####solution 2

**总体思路：**

充分利用哈希表查找的时间复杂度为常数这一特点： 遍历传入数据，若`target-i`在哈希表存在，则返回。并且若该元素不存在于表，则加入。

**步骤：**

1. 建立哈希表
2. 遍历传入数据
3. 若哈希表中存在 `target-i` ( `i` 为数据元素) 则退出循环，到 步骤 6.
4. 若该元素 `i` 不存在于哈希表，则将元素以及索引号加入哈希表
5. 返回 步骤 2.
6. 返回当前遍历数据的索引号 `index` 和 `target-i` 数据的索引号

[solution2.cpp](https://github.com/PatrickLin1993/LeetCode/blob/master/Algorithmn/Two%20Sum/resolution2.cpp)