##Excel Sheet Column Number

 Related to question Excel Sheet Column Title
 
 Given a column title as appear in an Excel sheet, return its corresponding column number.
 
 For example:
 
	 A -> 1
	 B -> 2
	 C -> 3
	 ...
	 Z -> 26
	 AA -> 27
	 AB -> 28
	 

##Solution:

将二十六进制转换成十进制。

```cpp
int titleToNumber(string s) {
    int n = 0;
    for (auto e : s) {
        n = n * 26 + (e - 'A' + 1);
    }
    return n;
}
```

####Excel Sheet Column Ttile:

[Excel Sheet Column Title](https://github.com/PatrickLin1993/LeetCode/tree/master/Algorithmn/168%20-%20Excel%20Sheet%20Column%20Title)