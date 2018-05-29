##224. Basic Calculator

Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open `(` and closing parentheses `)`, the plus `+` or minus sign `-`, non-negative integers and empty spaces` `.

You may assume that the given expression is always valid.

Some examples:
```
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
```
**Note: Do not** use the eval built-in library function.

##Solution:

因为只有加减法，所以可以从左到右计算过去，碰到括号就将符号堆栈，然后符号两两作用得出最后符号。如下：

|符号A|符号B| 结果 |
|---|-----|------|
|+|-|-|
|+|+|+|
|-|+|-|
|-|-|+|

总结起来，就是相同符号结果为 `+`， 相异符号结果为 `-`。因此，我们可以定义 `+` 为 `1`，`-` 为 `-1`。那么的作用即两者相乘。

```cpp
int calculate(string s) {
	vector<int> signStack;
	int size = s.size(), result = 0, sign = 1;
	for (int i = 0; i < size; ++i){
		char c = s[i];
		if (c >= '0' && c <= '9'){
			int n = (c - '0');
			while (i + 1 < size && s[i + 1] >= '0' && s[i + 1] <= '9'){
				n = n * 10 + (s[i + 1] - '0');
				i++;
			}
			for (auto e : signStack){
				sign *= e;
			}
			result += sign * n;
		}
		else if (c == '+' || c == '-')
			sign = 44 - c;
		else if (c == '('){
			signStack.push_back(sign);
			sign = 1;
		}
		else if (c == ')')
			signStack.pop_back();
	}
	return result;
}
```