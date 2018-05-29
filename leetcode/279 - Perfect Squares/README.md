##279. Perfect Squares

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

##Solution

####Solution 1:
动态规划： 150mm

```
dp[i] = min(dp[i], 1 + dp[i - jSqrt * jSqrt]); (jSqrt = 2 to 最大平方数 )
```
```cpp
int numSquares(int n) {
        int dp[100000];
		dp[0] = 0;
		for (int i = 1; i <= n; ++i){
			int iSqrt = sqrt(i);
			dp[i] = 1 + dp[i - iSqrt * iSqrt];
			if (dp[i] == 1)
			    continue;
			for (int j = iSqrt - 1; j >= 2; --j){
				dp[i] = min(dp[i], 1 + dp[i - j * j]);
			}
		}
		return dp[n];
    }
```

####Solution 2:
数学规律： 3mm

我们发现，返回的值在 1 - 4 之间不停波动。因此我们可以总结出以下对应条件：

```
返回值为 1 ： 输入值正好为某数的平方。
返回值为 2 ： 因为 2 的情况下只有 1 + 1 的情形， 故在输入值为 (n - iSqrt * iSqrt) 正好为某数的平方时，返回值为 2。
返回值为 3 ： 勒让德三方定理（Legendre's three-square theorem）中我们得知许多自然数可以表达为 n = x^2 + y^2 + z^2，
			 当且仅当 n 不满足 n = 4^a(8b + 7) 的形式。但是换过来说，是不是所有不满足该形式的数，都符合三方定理，答案是否的，比如 3， 6等。
返回值为 4 ： 由上知，我们可以用 n = 4^a(8b + 7) 筛选出不满足三方定理的数，也就是返回值为 4 的情况。 
```
关于： [勒让德三方定理(Legendre's three-square theorem)](https://en.wikipedia.org/wiki/Legendre%27s_three-square_theorem)

```cpp
int numSquares(int n) {
    // case 1:
	if (isSqrted(n))
		return 1;

	// case 2:
	int iSqrt = sqrt(n);
	for (int i = 1; i <= iSqrt; ++i){
		if (isSqrted(n - i * i))
			return 2;
	}

	// case 4: n == a^4(8b + 7)
	while ((n & 3) == 0){
		n >>= 2;
	}
	if ((n & 7) == 7)
		return 4;

	// case 3
	return 3;
}
```

####Solution 3:
BFS: 19mm

搜索一颗树，其根为 1 到 iSquare (最大平方数)，结点则为比母节点小的所有平方数，最后计算得出结果时的层数。以 n = 12 为例：
```
1            4               9
|          /   \         /   |    \
1          1   4        1    4     9
|          |  / \       |   / \  / | \
1          1  1 4       1   1 4  1 4 9
```
以上搜索过程，当搜索进行到第三层从左第四个节点时，我们发现了(4 + 4 + 4 = 12)，便可得出结果。

```cpp
int numSquares(int n) {
    vector<int> Squares;
	vector<int> Record(n);
	queue<int> que;
	for (int i = 1; i * i <= n; ++i){
		int square = i * i;
		if (square == n)
			return 1;
		Squares.push_back(square);
		Record[square] = square;
		que.push(square);
	}
	int level = 1;
	while (!que.empty()){
		level++;
		int size = que.size();
		for (int i = 0; i < size; ++i){
			int front = que.front();
			que.pop();
			for (auto &j : Squares){
				if (j > Record[front])
					break;
				int tmp = front + j;
				if (tmp == n)
					return level;
				else if (tmp < n && Record[tmp] == 0){
					que.push(tmp);
					Record[tmp] = j;
				}
				else if (tmp > n){
					break;
				}
			}
		}
	}
	return 0;
}
```

