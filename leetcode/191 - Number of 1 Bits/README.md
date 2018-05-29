##Number of 1 Bits

Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation `00000000000000000000000000001011`, so the function should return 3.

##Solution:

辗转相除法：

```cpp
int hammingWeight(uint32_t n) {
        uint32_t a = n;
        int count = 0;
        while(a != 0){
            if (a % 2){
                count++;
            }
            a /= 2;
        }
        return count;
    }
```

也可以利用位操作进行：

```cpp
int hammingWeight(uint32_t n) {
        int count = 0;
        while (n != 0){
            if (n & 1 == 1){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
```