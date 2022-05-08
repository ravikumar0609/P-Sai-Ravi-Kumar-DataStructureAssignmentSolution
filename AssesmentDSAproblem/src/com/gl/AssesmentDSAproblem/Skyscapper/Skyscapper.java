package com.gl.AssesmentDSAproblem.Skyscapper;

/**
 * @author psairavikumar
 * @code version 1.0.0
 * @implementation 
 * @InputParm 
 * floor size
 * output - days with floor size build
 * 
 */
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Skyscapper {

	/**
	 *    Data structure Queue ,priority queue and Stack is used.
	 *     Queue is used to store the input value
	 *     priority queue is used to sort the input queue
	 *     stack is used to compare and print the value 
	 */
	public static Queue<Integer> floorSize = new LinkedList<>();
	public static PriorityQueue<Integer> sortedFloorSize = new PriorityQueue<Integer>(Collections.reverseOrder());
	public static Stack<Integer> floorStack = new Stack<Integer>();

	// Sort a stack using another stack
	public static Stack<Integer> sortStack(Stack<Integer> stack) {
		Stack<Integer> tempStack = new Stack<Integer>();
		while (!stack.isEmpty()) {
			int currentData = stack.pop();
			while (!tempStack.isEmpty() && tempStack.peek() > currentData) {
				stack.push(tempStack.pop());
			}
			tempStack.push(currentData);
		}
		return tempStack;
	}
	// this method will check the floor size in respective days and build the Skyscapper once the correct floor size is available 
	public static void checkSkyscapperBuild() {
		int dayCount = 1;
		// to check if queue is empty if not it will run until queue is empty
		while (!floorSize.isEmpty()) {
			System.out.println("Day: " + dayCount);
			// remove the first element from queue
			int element = floorSize.poll();
			//push it to stack
			floorStack.push(element);

			// used to sort the element in stack to consider the floor size in decreasing order
			Stack<Integer> tempStack = new Stack<Integer>();
			tempStack.addAll(floorStack);
			floorStack = sortStack(tempStack);
			
			// compare the element with the first element of priority queue
			if (element == sortedFloorSize.peek()) {
				// this condition will check if the head of priority queue is in input queue or not

				while (!floorSize.contains(sortedFloorSize.peek()) && !sortedFloorSize.isEmpty()) {
					// if queue is empty but stack is not empty Stack pop operation will be printing the value

					if (floorSize.isEmpty() && !floorStack.empty()) {

						int stack_item = floorStack.pop();
						sortedFloorSize.remove(stack_item);
						System.out.print(stack_item);

					} else if (sortedFloorSize.peek() == floorStack.peek()) {
						int stack_item = floorStack.pop();
						sortedFloorSize.remove(stack_item);
						System.out.print(stack_item);
					}

				}
				System.out.println();

			} else {
				System.out.println();
			}
			dayCount++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter the total no of floors in the building");
		Scanner sc = new Scanner(System.in);
		int no_of_floors = sc.nextInt();
		// create a queue and sorted queue with distinct floor size
		for (int i = 0; i < no_of_floors; i++) {
			System.out.println("enter the floor size given on day : " + (i + 1));
			int element = sc.nextInt();
			// will check the element if element is already in queue then it will say duplicate value.
			if (floorSize.contains(element)) {
				System.out.println("duplicate value " + element + ", please try again ");
				i--;
			}
			else {
				floorSize.add(element);
				sortedFloorSize.add(element);				
			}
		}
		// method to check the days with floor size for Skyscapper build
		checkSkyscapperBuild();
		sc.close();

	}

}
