package com.demo;

class Stack {
private int top=0;
public int getTop() {
	return top;
}

public void setTop(int top) {
	this.top = top;
}
private String arr[]=new String[100];

public String[] getArr() {
	return arr;
}

public void push(String element) {
	arr[top]=element;
	top++;
}
public void pop() {
	if(top==0) {
		System.out.println("Underflow");
		return;
	}
	top--;
}
public boolean isEmpty() {
	if(top==0)
		return true;
	return false;
}
public void peek() {
//	System.out.println("top:"+top);
		System.out.println("top ele:"+arr[top-1]);
		return;
}
public void disp() {
	for(int l=top-1;l>=0;l--)
		System.out.print(arr[l]+" ");
	System.out.println();
}
}

public class StackImplement{
public static void main(String[] args) {
	Stack st=new Stack();
	st.push("rohit");
	st.push("sai");
	st.push("gupta");
	st.disp();
	st.peek();
	st.pop();
	st.disp();
	st.push("vinay");
	st.disp();
	st.pop();
	st.pop();
	st.disp();
	st.peek();
	st.pop();
	System.out.println("is Empty:"+st.isEmpty());
}
}

