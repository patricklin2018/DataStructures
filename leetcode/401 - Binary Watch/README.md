##Binary Watch

A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.

![](http://i4.piimg.com/567571/e20a9a698ac57cb9.jpg)

For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

`Input: n = 1`

`Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]`

Note:

* The order of output does not matter.
* The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
* The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".

##Solution
####Solution 1:
穷举，再利用 [191 － Number of 1 Bits](https://github.com/PatrickLin1993/LeetCode/tree/master/Algorithmn/191%20-%20Number%20of%201%20Bits) 计算出该时间表示具有的 `1` 的个数。

```cpp
int hammingWeight(uint32_t n){
    int count = 0;
    while (n != 0){
        if (n & 1)
            count++;
        n = n >> 1;
    }
    return count;
}
    
vector<string> readBinaryWatch(int num) {
    vector<string> vec;
    for (int h = 0; h <= 11; h++){
        for(int m = 0; m <= 59; m++){
            if(hammingWeight(h) + hammingWeight(m) == num){
                char timer[6];
                sprintf(timer, "%d:%02d", h, m);
                vec.push_back(timer);
            }
        }
    }
    return vec;
}
```
####Solution 2:
当然，计算该时间表示的 `1` 的个数也可以改为：

```cpp
vector<string> readBinaryWatch(int num) {
    vector<string> vec;
    for (int h = 0; h <= 11; h++){
        for(int m = 0; m <= 59; m++){
            if(bitset<10>((h << 6) + m).count() == num){
                char timer[6];
                sprintf(timer, "%d:%02d", h, m);
                vec.push_back(timer);
            }
        }
    }
    return vec;
}
```