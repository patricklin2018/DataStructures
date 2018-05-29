##227. Basic Calculator II

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only **non-negative** integers, `+`, `-`, `*`, `/` operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
```
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
```
**Note:** Do not use the `eval` built-in library function.

##Solution:

####Solution 1: 13mm
通过堆栈，处理乘除法，而加减法则压栈。
```cpp
int calculate(string s) {
	s = s + '+';
	stack<int> cal;
	int i = 0, size = s.size(), tmp = 0, result = 0;
	char symbol = '+';
	for (i = s.find_first_not_of(' ', i); i != string::npos; i = s.find_first_not_of(' ', i + 1)){
		if (s[i] >= '0' && s[i] <= '9'){
			tmp = tmp * 10 + (s[i] - '0');
			continue;
		}
		if (symbol == '+' || symbol == '-'){
			cal.push(tmp * (44 - symbol));
		}
		else{
			int& leftN = cal.top();
			if (symbol == '*')
				leftN *= tmp;
			else
				leftN /= tmp;
		}
		symbol = s[i];
		tmp = 0;
	}

	while (!cal.empty()){
		result += cal.top();
		cal.pop();
	}
	return result;
}

```
####Solution 2: 19mm
利用 `istringstream` 处理字符串。
```cpp
int calculate(string s) {
	istringstream in('+' + s + '+');
	long long Result = 0, Term = 0, Tmp;
	char Symbol;
	while (in >> Symbol){
		if (Symbol == '+' || Symbol == '-'){
			Result += Term;
			in >> Term;
			Term *= 44 - Symbol;
		}
		else{
	    	in >> Tmp;
			if (Symbol == '*')
				Term *= Tmp;
			else
				Term /= Tmp;
		}
	}
	return Result;
}
```
