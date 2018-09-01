package com.alitest;
import java.util.Stack;

public class MinStack {
	
	public static void main( String[] args )
    {
    	

    }
	
	Stack<Integer> minstack=new Stack<Integer>();
	
	Stack<Integer> stack=new Stack<Integer>();
	/** initialize your data structure here. */
    public MinStack() {
        
    }
    
    
    
    public void push(int x) {
    	if(minstack.isEmpty() || minstack.get(minstack.size()-1)>=x) {
    		minstack.push(x);
    	}
    	stack.push(x);
    }
    
    public void pop() {
    	int num= stack.pop();
    	if(!minstack.isEmpty()&& minstack.get(minstack.size()-1)==num) {
    		minstack.pop();
    	}
    }
    
    public int top() {
    	
    	return stack.peek();
    }
    
    public int getMin() {
    	
    	return minstack.peek();
    }

}
