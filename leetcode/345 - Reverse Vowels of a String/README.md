##Reverse Vowels of a String

Write a function that takes a string as input and reverse only the vowels of a string.

**Example 1:**

Given s = "hello", return "holle".

**Example 2:**

Given s = "leetcode", return "leotcede".

**Note:**

The vowels does not include the letter "y".

##Solution
####1.
从前后开始一起遍历。
```cpp
string reverseVowels(string s) {
	string res = s, Vowels = "aeiouAEIOU";
	int size = s.size(), pre = 0, lst = size - 1, sizeVowles = Vowels.size();
	while (pre < lst){
		bool bSatisfy = true;
		if (Vowels.find(res[pre]) == string::npos){
			pre++;
			bSatisfy = false;
		}
		if (Vowels.find(res[lst]) == string::npos){
			lst--;
			bSatisfy = false;
		}
		if (bSatisfy){
			swap(res[pre], res[lst]);
			pre++;
			lst--;
		}
	}
	return res;
}
```
####2.
使用 `string::find_first_of` 查找第一个子字符。
```cpp
string reverseVowels(string s) {
	int size = s.size(), i = 0, j = size - 1;
	string Vowels = "aeiouAEIOU";
	while (i < j){
		i = s.find_first_of(Vowels, i);
		j = s.find_last_of(Vowels, j);
		if (i < j)
			swap(s[i++], s[j--]);
	}
	return s;
}
```