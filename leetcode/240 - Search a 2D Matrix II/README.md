##240. Search a 2D Matrix II

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

* Integers in each row are sorted in ascending from left to right.
* Integers in each column are sorted in ascending from top to bottom.

For example,

Consider the following matrix:

```
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```

Given **target** = `5`, return `true`.

Given **target** = `20`, return `false`.

##Solution:

从右上角或者左下角开始搜索。

>CPP

```cpp
bool searchMatrix(vector<vector<int>>& matrix, int target) {
    if (matrix.size() == 0 || matrix[0].size() == 0){
		return false;
	}
	int r = matrix.size(), c = matrix[0].size();
	int i = 0, j = c - 1;
	while (i < r && j >= 0){
		if (matrix[i][j] == target){
			return true;
		}
		else if (matrix[i][j] > target){
			j--;
		}
		else{
			i++;
		}
	}
	return false;
}
```

>JAVA

```java
public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
		 return false;
	}
	int r = 0;
	int c = matrix[0].length - 1;
	while(r < matrix.length && c >= 0){
		if (matrix[r][c] == target){
			return true;
		}
		else if (matrix[r][c] < target){
			r++;
		}
		else{
			c--;
		}
	}
	return false;
}
```