##Power of Four
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

**Example:**
Given num = 16, return true. Given num = 5, return false.

**Follow up:** Could you solve it without loops/recursion?

##Solution

采用位运算。4次方，相当于每次乘于4，也就是说，每次向左移2位。所以和 `0x5555555` 进行与操作，判断是否 1 在正确的位置上。但是这并不够，有可能出现多个1的情况，比如说 5（101），所以将其减1后与自己进行与操作，检测是否还有1出现。

```cpp
bool isPowerOfFour(int num) {
	if (num >= 1 && (num & 0x55555555) == num && ((num - 1) & num) == 0)
		return true;
	return false;
}
```