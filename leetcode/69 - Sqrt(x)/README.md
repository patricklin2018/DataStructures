##69. Sqrt(x)

Implement `int sqrt(int x)`.

Compute and return the square root of x.

##Solution

二分法。

>CPP

```
int mySqrt(int x) {
    if (x == 1){
		return 1;
	}
	long left = 0, right = x;
	while (left + 1 < right){
		long mid = left + (right - left) / 2;
		if (mid * mid == x){
			return mid;
		}
		else if (mid * mid < x){
			left = mid;
		}
		else{
			right = mid;
		}
	}
	return left;
}
```

这里如果 `mid * mid == target` 溢出，可以变更为 `mid == target / mid`。

>JAVA

```java
public int mySqrt(int x) {
    if (x == 1){
    	return 1;
    }
 	int left = 0;
 	int right = x;
 	while (left + 1 < right){
 		int mid = left + (right - left) / 2;
 		if (mid == x / mid){
 			return mid;
 		}
 		else if (mid < x / mid){
 			left = mid;
 		}
 		else{
 			right = mid;
 		}
 	}
 	return left;
}
```