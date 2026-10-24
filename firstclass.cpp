#include <iostream>
#include <stack>
#include <stack>
using namespace std;
string reverseStrig(string str)
{
    stack<char> s;
    for (char ch : str)
    {
        s.push(ch);
    }
    string reversed = "";
    while (!s.empty()) {
        reversed += s.top();
        s.pop();
    }
    return reversed;
}
int main () {
    string str;
    cout << "Enter a string: ";
    getline(cin, str);
    string reversed = reverseStrig(str);
    cout << "Reversed string: " << reversed << endl;
    return 0;
}
