package com.practise;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		Queue<Node> nodeQueue = null;
		Map<String, Node> stringCountMap = null;
		for (int testCase = 0; testCase < noOfTestCases; testCase++) {
			int noOfStreams = sc.nextInt();
			stringCountMap = new HashMap<String, Node>();
			
			nodeQueue = new PriorityQueue<Node>(new Comparator<Node>() {

				@Override
				public int compare(Node firstNode, Node secondNode) {
					if (firstNode.count == secondNode.count) {
						return firstNode.index - secondNode.index;
					} else {
						return firstNode.count - secondNode.count;
					}
				}

			});

			for (int index = 0; index < noOfStreams; index++) {
				String input = sc.next();
				Node existingNode = stringCountMap.get(input);
				Node node = new FirstNonRepeatingChar().new Node(input, index);
				int count = 0;
				int previousIndex = 0;
				if(existingNode != null) {
					nodeQueue.remove(existingNode);
					previousIndex = existingNode.index;
					count = existingNode.count;
					node.index = previousIndex;
				}else{
					node.index = index;
				}
				node.setCount(++count);
				nodeQueue.add(node);
				stringCountMap.put(input, node);
				Node resultNode = nodeQueue.peek();
				if(resultNode.count > 1){
					System.out.print("-1"+" ");
				}else{
					System.out.print(resultNode.input+" ");
				}
			}
			
		}
		System.out.println(" ");

		/*Iterator<Node> nodeQueueItr = nodeQueue.iterator();
		while (nodeQueueItr.hasNext()) {
			System.out.println(nodeQueue.poll());
		}*/
	}

	class Node {
		String input;
		int index;
		int count;

		public Node() {
		}

		public Node(String input, int index) {
			super();
			this.input = input;
			this.index = index;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((input == null) ? 0 : input.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (input == null) {
				if (other.input != null)
					return false;
			} else if (!input.equals(other.input))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Node [input=" + input + ", index=" + index + ", count=" + count + "]";
		}

	}
}
