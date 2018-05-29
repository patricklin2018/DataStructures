##First Unique Character in a String

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

```
s = "leetcode"

return 0.

s = "loveleetcode",

return 2.
```

Note: 

You may assume the string contain only lowercase letters.

##Solution

利用无序容器建立字母hash表，再根据该字符串顺序，逐一进行查询，是否为 `Unique`。

```cpp
int firstUniqChar(string s) {
    unordered_map<char, int> um;
    int index = 0;
    for (auto e : s){
        um[e]++;
    }
    for (auto e : s){
        if (um[e] < 2){
            return index;
        }
        index++;
    }
    return -1;
}
```