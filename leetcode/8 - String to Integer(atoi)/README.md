##String to Integer(atoi)

Implement atoi to convert a string to an integer.

**Hint:** Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

**Notes:** It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

**Requirements for atoi:**

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, `INT_MAX (2147483647)` or `INT_MIN (-2147483648)` is returned.

##Solution
```cpp
int myAtoi(string str) {
	int int_max = 2147483647, int_min = -2147483648, size = str.size(), indicator = 1;
	long long res = 0;
	int i = str.find_first_not_of(' ');
	if (str[i] == '+' || str[i] == '-'){
		indicator = 1 - 2 * (str[i++] == '-');
	}
	while (i < size && str[i] >= '0' && str[i] <= '9'){
		res = res * 10 + (str[i++] - '0');
		if (indicator * res >= int_max) return int_max;
		if (indicator * res <= int_min) return int_min;
	}
	return indicator * res;
}
```