##Pascal's Triangle

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,

Return
```
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

##Solution

####1.
```cpp
vector<vector<int>> generate(int numRows) {
	vector<vector<int>> res;
	for (int i = 0; i < numRows; ++i){
		vector<int> curLevelVec;
		curLevelVec.push_back(1);
		for (int j = 1; j < i; ++j){
			curLevelVec.push_back(res[i - 1][j] + res[i - 1][j - 1]);
		}
		if (i != 0)
			curLevelVec.push_back(1);
		res.push_back(curLevelVec);
	}
	return res;
}
```
#####2.
与方法 1 大致相同， 只不过提前开辟好空间，直接修改。
```cpp
vector<vector<int>> generate(int numRows) {
   vector<vector<int>> res(numRows);
	for (int i = 0; i < numRows; ++i){
		res[i].resize(i + 1);
		res[i][0] = res[i][i] = 1;
		for (int j = 1; j < i; ++j)
			res[i][j] = res[i - 1][j] + res[i - 1][j - 1];
	}
	return res;
}
```