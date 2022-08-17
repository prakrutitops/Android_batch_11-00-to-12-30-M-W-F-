package com.t178;

import java.util.LinkedList;

public class LinkedListEx 
{
	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList<>();
		ll.add("TOPS");
		ll.add(10);
		ll.add('H');
		System.out.println(ll);
		ll.addFirst("INDIA");
		ll.addLast("HELLO");
		System.out.println(ll);
		
	}
}
