##89. Gray Code
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return `[0,1,3,2]`. Its gray code sequence is:

```
00 - 0
01 - 1
11 - 3
10 - 2
```

**Note:**
For a given n, a gray code sequence is not uniquely defined.

For example, `[0,2,3,1]` is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

##Solution：

题目看不懂什么意思，百度了一下，可以使用递归生成码，基本规则如下：

```
1.  1位格雷码有两个码字
2.  (n+1)位格雷码中的前2^n个码字等于n位格雷码的码字，按顺序书写，加前缀0
3.  (n+1)位格雷码中的后2^n个码字等于n位格雷码的码字，按逆序书写，加前缀1
4.  n+1位格雷码的集合 = n位格雷码集合(顺序)加前缀0 + n位格雷码集合(逆序)加前缀1
```

[详细 - 百度：格雷码](http://baike.baidu.com/link?url=jspQ0FM2dokTUmHGsPKqplJcckaitA4Kvq068rpGE-60_xInuPMKkB25Zqep9KaFIgtQ35TzS63lhamDDhM5Ney6Mr9RcHNUEi5gjuSvfMceT9UZLMm6HK9Gmu_hnhdM3RsiMOnFxZfRyR-EoaDDYu2dnQb2SwThp7qj5tBgO4e#1)

步骤 2 的前缀加 0 相当于没有处理，所以我们只要处理步骤 3，前缀加 1。

```cpp
vector<int> grayCode(int n)
{
	vector<int> result(1, 0);
	for (int i = 1; i <= n; ++i){
		int size = result.size();
		for (int j = size - 1; j >= 0; --j){
			result.push_back(result[j] + (1 << (i - 1)));
		}
	}
	return result;
}
```