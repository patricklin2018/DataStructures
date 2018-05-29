##Plus One
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

##Solution
####1.
最常见方法，满十进位。
```
vector<int> plusOne(vector<int>& digits) {
   int size = digits.size(), carry = 0;
   digits[size - 1]++;
	for (int i = size - 1; i >= 0; --i){
		int value = digits[i] + carry;
		digits[i] = value % 10;
		carry = value / 10;
	}
	if (carry){
		digits.insert(digits.begin(), carry);
	}
	return digits;
}
```
####2.
容易理解但却不容易想到，遇到 `9` 才进位，直到不遇见 `9`。
```cpp
vector<int> plusOne(vector<int>& digits) {
    int size = digits.size();
	for (int i = size - 1; i >= 0; --i){
		if (digits[i] == 9)
			digits[i] = 0;
		else{
			digits[i]++;
			return digits;
		}
	}
	digits.insert(digits.begin(), 1);
	return digits;
}
```