##290. Word Pattern

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

**Examples:**

```
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
```
**Notes:**

You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

##Solution:

建立映射关系，相互比较。

```cpp
bool wordPattern(string pattern, string str) {
	istringstream in(str);
	unordered_map<char, string> mapping;
	unordered_set<string> record;
	int i = 0, size = pattern.size();
	for (string s; in >> s; ++i){
		if (i != size && mapping[pattern[i]] == "" && record.find(s) == record.end()){
			mapping[pattern[i]] = s;
			record.insert(s);
		}
		else if (mapping[pattern[i]] != s)
			return false;
	}
	return i == size;
}
```
