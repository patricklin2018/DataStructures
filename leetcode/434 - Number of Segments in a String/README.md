##434. Number of Segments in a String

Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

**Example:**
```
Input: "Hello, my name is John"
Output: 5
```

##Solution

####Solution 1 :  使用 find_first_of 和 find_first_not_of
```cpp
int countSegments(string s) {
  int idx = 0, count = 0;
	while ((idx = s.find_first_not_of(' ', idx)) != string::npos){
		count++;
		idx = s.find_first_of(' ', idx);
	}
	return count;
}
```

####Solution 2:
```cpp
int countSegments(string s) {
    int count = 0, size = s.size();
	for (int i = 0; i < size; ++i){
		if (s[i] != ' ' && (s[i + 1] == ' ' || s[i + 1] == '\0'))
			count++;
	}
	return count;
}
```