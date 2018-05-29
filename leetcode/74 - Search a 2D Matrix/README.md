##74. Search a 2D Matrix

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

* Integers in each row are sorted from left to right.
* The first integer of each row is greater than the last integer of the previous row.

For example,

Consider the following matrix:

```
[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
```

Given **target** = `3`, return `true`.

##Solution

二分法。

>CPP

```
bool searchMatrix(vector<vector<int>>& matrix, int target) {
    if (matrix.size() == 0 || matrix[0].size() == 0){
		return false;
	}
	int r = matrix.size(), c = matrix[0].size();
	int left = 0, right = r * c - 1;
	while (left + 1 < right){
		int mid = left + (right - left) / 2;
		int tmp = matrix[mid / c][mid % c];
		if (tmp == target){
			return true;
		}
		else if (tmp < target){
			left = mid;
		}
		else {
			right = mid;
		}
	}
	return  matrix[left / c][left % c] == target || matrix[right / c][right % c] == target;
}
```

>Java

```java
public boolean searchMatrix(int[][] matrix, int target) {
	 if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
		 return false;
	 }
	 
	 int left = 0;
	 int right = matrix.length * matrix[0].length - 1;
	 while (left + 1 < right){
		 int mid = left + (right - left) / 2;
		 int r = mid / matrix[0].length;
		 int c = mid % matrix[0].length;
		 if (matrix[r][c] == target){
			 return true;
		 }
		 else if (matrix[r][c] < target){
			 left = mid;
		 }
		 else{
			 right = mid;
		 }
	 }
	 if (matrix[left / matrix[0].length][left % matrix[0].length] == target){
		 return true;
	 }
	 if (matrix[right / matrix[0].length][right % matrix[0].length] == target){
		 return true;
	 }
	 return false;
}
```