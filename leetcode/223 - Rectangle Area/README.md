##223. Rectangle Area

Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

![](https://github.com/PatrickLin1993/LeetCode/blob/master/Algorithmn/223%20-%20Rectangle%20Area/rectangle_area.png)

Assume that the total area is never beyond the maximum possible value of int.

##Solution:
讨论是否相交：
```cpp
int max(int a, int b){
	return (a >= b ? a : b);
}
int min(int a, int b){
	return (a <= b ? a : b);
}

int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
	int left = max(A, E);
	int bottom = max(B, F);
	int right = min(C, G);
	int top = min(D, H);

	// 相离
	if (left >= right || bottom >= top){
		return (C - A) * (D - B) + (G - E) *(H - F);
	}
	// 相交
	return (C - A) * (D - B) + (G - E) * (H - F) - (top - bottom) * (right - left);
}
```