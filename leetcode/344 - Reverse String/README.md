##Reverse String

Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

##Solution

####solution 1:
最简单的从末尾开始遍历，创建新`String`。

```cpp
string reverseString(string s){
	string newString;
	for (auto it = s.rbegin(); it != s.rend(); it--) {
		newString += *it;
	}
	return newString;
}
```

####solution 2:
从头开始，进行头尾互相调换。

```cpp
string reverseString(string s){
	int i = 0, j = s.size() - 1;
	while (i < j) {
		swap(s[i++], s[j--]);
	}
	return s;
}
```