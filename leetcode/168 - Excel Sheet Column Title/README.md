##Excel Sheet Column Title

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB    

##Solution:

整体思路，就是利用辗转相除法将十进制转换成二十六进制。需要注意的是，当目前位置为 `Z` 时， 若进一位不为 0，需减 1。否则会出现 `52 = BZ` 的情况。

例如

```cpp
string convertToTitle(int n) {
    string result = "";
    while (n != 0){
        auto tmp = (n - 1) % 26 + 'A';
        result.insert(result.begin(), tmp);
        n = n / 26;
        if (tmp == 'Z' && n != 0)
            n--;
    }
    return result;
}
```

也可写成：

```cpp
string convertToTitle(int n) {
    string result = "";
    while (n != 0){
        auto tmp = (n - 1) % 26 + 'A';
        result.insert(result.begin(), tmp);
        n = (n - 1) / 26;
    }
    return result;
}
```

####Excel Sheet Column Number:

[Excel Sheet Column Number](https://github.com/PatrickLin1993/LeetCode/tree/master/Algorithmn/171%20-%20Excel%20Sheet%20Column%20Number)