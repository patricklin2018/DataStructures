#include <iostream>
#include <string>
#include <cassert>
using namespace std;

/**

@author Patrick-lenovo
@create 2018/6/9 19:41

八数码问题
BFS + HASH

**/

class Solution {
public:
	/*
		src 当前状态， dst 目标状态
		搜索最短路径，返回路径(路径采用UDLR分别表示上下左右移)
		若无解则返回 hasn't solution
	*/
	string search(int* src, int* dst) {
		assert(src != nullptr || dst != nullptr);

		cout << "初始状态如下：" << endl;
		statePrinter(src);

		// init
		head = 0;
		rear = 1;
		memset(isVisited, false, sizeof(isVisited));

		int dstHashCode = getHashCode(dst);

		states[head] = new State(src);
		isVisited[getHashCode(src)] = true;

		while (head < rear) {
			State* s = states[head];

			// 找到目标局面
			if (memcmp(s->state, dst, sizeof(s->state)) == 0) {
				return getPath(head);
			}

			// 查找空格
			int i = 0;
			for (; i < 9; ++i) {
				if (s->state[i] == 0) {
					break;
				}
			}

			int srcX = i % 3;
			int srcY = i / 3;
			
			// 尝试上下左右移动
			for (int j = 0; j < 4; ++j) {
				int dstX = srcX + dx[j];
				int dstY = srcY + dy[j];
				
				if (dstX >= 0 && dstX < 3 && dstY >= 0 && dstY < 3) {
					int tmp[9];
					memcpy(tmp, &s->state, sizeof(tmp));
					int dstP = dstX + dstY * 3;
					tmp[i] = tmp[dstP];
					tmp[dstP] = 0;

					int tmpHashCode = getHashCode(tmp);

					// 截枝
					if (dstHashCode == tmpHashCode) {
						states[rear] = new State(tmp, head, stepChar[j]);
						return getPath(rear);
					}
					
					// 查重
					if (!isVisited[tmpHashCode]) {
						states[rear] = new State(tmp, head, stepChar[j]);
						isVisited[tmpHashCode] = true;
						rear++;
					}
				}
			}
			head++;
		}

		return "hasn't solution";
	}

	string getPath(int start) {
		string result;
		State* tmp = states[start];
		while (tmp != nullptr && tmp->parent != -1) {
			statePrinter(tmp->state);
			cout << endl;
			result = tmp->step + result;
			tmp = states[tmp->parent];
		}

		statePrinter(tmp->state);

		return result;
	}

	Solution() {
		states = new State*[MAXSIZE];
	}

	~Solution() {
		delete states;
	}

private:
	// 状态表示
	struct State {
		int state[9];
		// parent = -1 时，则为根
		int parent;
		char step;

		State(int* st, int p = -1, char s = NULL) {
			memcpy(&state, st, sizeof(state));
			parent = p;
			step = s;
		}
	};

	// 最大规模
	const int static MAXSIZE = 1000003;

	// 存储状态树数组
	State** states;

	// 用 head 表示当前遍历索引
	int head;

	// 用 rear 表示状态树数组尾部
	int rear;

	// 记录对应的 hash code 是否被访问过
	bool isVisited[MAXSIZE];

	// 各个移动方向
	const int dx[4] = { 0, 0, -1, 1 };
	const int dy[4] = { -1, 1, 0, 0 };
	
	// 用 0-3 代表上下左右，其对应的 step 为 UDLR
	const char stepChar[4] = { 'U', 'D', 'L', 'R' };

	/*
		按照九宫格的形状打印数组
	*/
	void statePrinter(int* arr) {
		for (int i = 0; i < 9; ++i) {
			cout << arr[i] << " ";
			if (i % 3 == 2) {
				cout << endl;
			}
		}
		cout << endl;
	}

	/*
		获得哈希值
	*/
	int getHashCode(int* state) {
		int val = 0;
		for (int i = 0; i < 9; ++i) {
			val = val * 10 + state[i];
		}
		return val % MAXSIZE;
	}
};

/*
	方法测试
*/
int main() {
	
	int src[9] = { 3,4,7,8,2,0,5,1,6 };
	int dst[9] = { 1,2,3,4,5,6,7,8,0 };

	Solution solution;
	string path = solution.search(src, dst);
	cout << path << endl;

	if (path != "hasn't solution") {
		cout << "step = " << path.size() + 1 << endl;
	}

	system("pause");
	return 0;
}