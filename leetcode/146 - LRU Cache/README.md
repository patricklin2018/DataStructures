##146. LRU Cache

Design and implement a data structure for [Least Recently Used (LRU) cache](https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU). It should support the following operations: get and put.

`get(key`) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
`put(key, value)` - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

**Follow up:**

Could you do both operations in O(1) time complexity?

**Example:**

```
LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
```

##Solution

```cpp
class LRUCache {
public:
	vector<int> use;
	map<int, int> data;
	int size;

	LRUCache(int capacity) {
		size = capacity;
	}

	int get(int key) {
		if (data[key] > 0){
			EraseUse(key);
			use.push_back(key);
			return data[key];
		}
		return -1;
	}

	void put(int key, int value) {
		if (data[key] > 0){
			data[key] = value;
			EraseUse(key);
			use.push_back(key);
			return;
		}
		if (use.size() < size){
			data[key] = value;
			use.push_back(key);
		}
		else{
			int tmpKey = use[0];
			data[tmpKey] = -1;
			EraseUse(tmpKey);
			data[key] = value;
			use.push_back(key);
		}
	}

	void EraseUse(int key){
		for (auto it = use.begin(); it != use.end(); ++it){
			if (*it == key){
				use.erase(it);
				return;
			}
		}
	}
};
```