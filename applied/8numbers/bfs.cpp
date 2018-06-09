#include <iostream>
#include <string>
#include <cassert>
using namespace std;

/**

@author Patrick-lenovo
@create 2018/6/9 19:41

����������
BFS + HASH

**/

class Solution {
public:
	/*
		src ��ǰ״̬�� dst Ŀ��״̬
		�������·��������·��(·������UDLR�ֱ��ʾ����������)
		���޽��򷵻� hasn't solution
	*/
	string search(int* src, int* dst) {
		assert(src != nullptr || dst != nullptr);

		cout << "��ʼ״̬���£�" << endl;
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

			// �ҵ�Ŀ�����
			if (memcmp(s->state, dst, sizeof(s->state)) == 0) {
				return getPath(head);
			}

			// ���ҿո�
			int i = 0;
			for (; i < 9; ++i) {
				if (s->state[i] == 0) {
					break;
				}
			}

			int srcX = i % 3;
			int srcY = i / 3;
			
			// �������������ƶ�
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

					// ��֦
					if (dstHashCode == tmpHashCode) {
						states[rear] = new State(tmp, head, stepChar[j]);
						return getPath(rear);
					}
					
					// ����
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
	// ״̬��ʾ
	struct State {
		int state[9];
		// parent = -1 ʱ����Ϊ��
		int parent;
		char step;

		State(int* st, int p = -1, char s = NULL) {
			memcpy(&state, st, sizeof(state));
			parent = p;
			step = s;
		}
	};

	// ����ģ
	const int static MAXSIZE = 1000003;

	// �洢״̬������
	State** states;

	// �� head ��ʾ��ǰ��������
	int head;

	// �� rear ��ʾ״̬������β��
	int rear;

	// ��¼��Ӧ�� hash code �Ƿ񱻷��ʹ�
	bool isVisited[MAXSIZE];

	// �����ƶ�����
	const int dx[4] = { 0, 0, -1, 1 };
	const int dy[4] = { -1, 1, 0, 0 };
	
	// �� 0-3 �����������ң����Ӧ�� step Ϊ UDLR
	const char stepChar[4] = { 'U', 'D', 'L', 'R' };

	/*
		���վŹ������״��ӡ����
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
		��ù�ϣֵ
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
	��������
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