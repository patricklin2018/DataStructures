## Valid Anagram

 Given two strings s and t, write a function to determine if t is an anagram of s.
 
 For example,<br>
 s = "anagram", t = "nagaram", return true.<br>
 s = "rat", t = "car", return false.
 
 Note:<br>
 You may assume the string contains only lowercase alphabets.
 
 Follow up:<br>
 What if the inputs contain unicode characters? How would you adapt your solution 
 to such case?

## Solution:

#### solution 1:
利用无序容器，建立一个字母 hash 表，进行统计。

```cpp
bool isAnagram(string s, string t) {
    unordered_map<char, int> um;
    for (auto e : s){
        um[e]++;
    }
    for (auto e : t){
        um[e]--;
    }
    for (auto e : um){
        if (e.second != 0) {
            return false;
        }
    }
    return true;        
}
```

#### solution 2:
进行排序，然后比较。

```cpp
bool isAnagram(string s, string t) {
    sort(s.begin(), s.end()), sort(t.begin(), t.end());
    return s == t;
}
```