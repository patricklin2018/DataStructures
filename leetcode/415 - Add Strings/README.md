##Add Strings

Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

1. The length of both num1 and num2 is < 5100.

2. Both num1 and num2 contains only digits 0-9.

3. Both num1 and num2 does not contain any leading zero.

4. You must not use any built-in BigInteger library or convert the inputs to integer directly.

##Solution

从最后一位开始往前遍历，逐位进行加法运算。

```cpp
string addStrings(string num1, string num2) {
    string res = (num1.size() >= num2.size() ? num1 : num2),
    	other = (num1.size() >= num2.size() ? num2 : num1);
    int sizeRes = res.size();
    int carry = 0;
    for (auto i = sizeRes - 1; i >= 0; --i){
    	int locOth = i - sizeRes + other.size();
    	int a = (locOth >= 0 ? other[locOth] - '0' : 0) + (res[i] - '0') + carry;
    	res[i] = a % 10 + '0';
    	carry = a / 10;
    }
    if (carry != 0){
    	res.insert(res.begin(), carry + '0');
    }
    return res;
}
```