#include <iostream>
#include <stack>
#include <string>
using namespace std;
bool isMatching(char opening, char closing)
{
    return (opening == '(' && closing == ')') ||
           (opening == '{' && closing == '}') ||
           (opening == '[' && closing == ']');
}
bool isBalanced(string expression) {
    
    stack<char> s;
    for (char ch : expression) {
        if (ch == '(' || ch == '{' || ch == '[') {
            s.push(ch);
        } else if (ch == ')' || ch == '}' || ch == ']') {
            if (s.empty() || !isMatching(s.top(), ch)) {
                return false;
            }
            s.pop();
        }
    }
    return s.empty();
}
int main() {
    string expression;
    cout << "Enter an expression: ";
    getline(cin, expression);
    if (isBalanced(expression)) {
        cout << "The expression is balanced." << endl;
    } else {
        cout << "The expression is not balanced." << endl;
    }
    return 0;
}