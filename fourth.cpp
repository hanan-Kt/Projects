#include <iostream>
#include <cctype>
#include <string>
#include <stack>
using namespace std;
int precedence(char op) {
    if (op == '^')
    return 3;
    if (op == '*' || op == '/' || op == '%')
    return 2;
    if (op == '+' || op == '-')
    return 1;
 return 0;
}
bool isRightAssociative(char op) {
    return op == '^';
}
string infixtoPotfix(string expression) {
 stack<char>s;
 string poastfix = "";
 for (char ch : expression) {
    if (isalnum(ch)) {
        poastfix += ch;
    } else if (ch == '(') {
        s.push(ch);
    } else if (ch == ')') {
        while (!s.empty() && s.top() != '(') {
            poastfix += s.top();
            s.pop();
        }
        if (!s.empty()) {
            s.pop();
        }
    } else {
        while (!s.empty() && s.top() != '(' && precedence(s.top()) >= precedence(ch)) {
            poastfix += s.top();
            s.pop();
        }
        s.push(ch);
    }
 }

 return poastfix;
}
int main() {
    string expression;
    cout << "Enter infix expression : ";
    cin >> expression;
    cout << "Postfix expression: " << infixtoPotfix(expression);
}