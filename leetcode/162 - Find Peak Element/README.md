##162. Find Peak Element

A peak element is an element that is greater than its neighbors.

Given an input array where `num[i] ≠ num[i+1]`, find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that `num[-1] = num[n] = -∞`.

For example, in array `[1, 2, 3, 1]`, 3 is a peak element and your function should return the index number 2.

##Solution

循环中处理三种情况:

```
1. 如果 mid 比 左右两点都大，即为波峰，返回。
2. 如果 mid 比 前一点小，即左端处于下降姿态，那么 right = mid 往前寻找波峰。
3. 如果 mid 比 后一点小，即右端处于上升姿态，那么 left  = mid 往后寻找波峰。
```

>CPP

```cpp
int findPeakElement(vector<int>& nums) {
    int size = nums.size();
	if (size == 0) {
		return -1;
	}
	if (size == 1) {
		return 0;
	}
	int left = 0, right = size - 1;
	while (left + 1 < right) {
		int mid = left + (right - left) / 2;
		if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
			return mid;
		}
		else if (nums[mid] < nums[mid - 1]) {
			right = mid;
		}
		else {
			left = mid;
		}
	}
	return nums[left] > nums[right] ? left : right;
}
```

>JAVA

```java
public int findPeakElement(int[] nums) {
    if (nums == null || nums.length == 0){
    	return -1;
    }
    else if (nums.length == 1){
    	return 0;
    }
    int left = 0;
    int right = nums.length - 1;
    while (left + 1 < right){
    	int mid = left + (right - left) / 2;
    	if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
    		return mid;
    	}
    	else if (nums[mid] < nums[mid - 1]){
    		right = mid;
    	}
    	else{
    		left = mid;
    	}
    }
    return nums[left] >= nums[right] ? left : right;
}
```