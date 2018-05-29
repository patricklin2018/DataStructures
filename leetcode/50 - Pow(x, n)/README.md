##50. Pow(x, n)

Implement pow(x, n).

##Solution

32 位的 `int` 类型最大值为 2147483648, 而最小值为 -2147483647。故第四行代码 `unsigned long long p = n; ` 中不能定义为 `int` 类型，或者 `n = -n;`

>CPP

```cpp
double myPow(double x, int n) {
	if (n == 0){
		return 1;
	}
	unsigned long long p = n;
	if (n < 0){
		p = -n;
		x = 1 / x;
	}
	double res = 1;
	while (p > 0){
		if ((p & 1) == 1){
			res *= x;
		}
		x *= x;
		p = p >> 1;
	}
	return res;
}
```

>JAVA

```java
public double myPow(double x, int n) {
    if (n == 0){
    	return 1;
    }
    long p = n;
    if (n < 0){
    	p = -p;
    	x = 1 / x;
    }
    double res = 1;
    while (p > 0){
    	if ((p & 1) == 1){
    		res *= x;
    	}
    	x *= x;
    	p = p >> 1;
    }
    return res;
}
```