package intro;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

class Node{
	int data;
	ArrayList<Node> children = new ArrayList<>();
}



public class GenericTree {

	public static void main(String[] args) {
		int arr[] = {10,20,40,-1,50,-1,-1,30,60,-1,-1,-1};
		Node root = new Node();
		root.data = arr[0];
		Stack<Node> st= new Stack<>();
		st.push(root);
		for(int i = 1; i<arr.length; i++) {
			if(arr[i]!=-1) {
				Node temp = new Node();
				temp.data = arr[i];
				st.peek().children.add(temp);
				st.push(temp);
			}else {
				st.pop();
			}
		}
		
//		printTree(root);
		levelOrderZigZag(root);
		System.out.println();
		levelOrderLineWise(root);
	}
	
	public static void printTree(Node root) {
		
		String s = root.data+" --> ";
		for(int i = 0; i<root.children.size(); i++) {
			Node temp = root.children.get(i);
			s+= temp.data+" ";
		}
		System.out.println(s+".");
		for(Node child: root.children) {
			printTree(child);
		}
	}
	
	public static int sizeOfTheTree(Node root) {
		int size  = 0;
		for(Node ch: root.children) {
			size+=sizeOfTheTree(ch);
		}
		return size+1;
	}
	
	public static int maxOfTree(Node root) {
		int max = root.data;
		for(Node child: root.children) {
			max = Math.max(max,maxOfTree(child));
		}
		return max;
	}
	
	public static int heightOfTree(Node root) {
		int height = -1; // depth of the deepest node
		for(Node child: root.children) {
			height = Math.max(height, heightOfTree(child));
		}
		return height +1;
	}
	
	
	
	public static void preOrderTraversal(Node root) {
		System.out.println(root.data);
		for(Node child : root.children) {
			preOrderTraversal(child);
		}
	}

	public static void postOrderTraversal(Node root) {
		for(Node child: root.children) {
			postOrderTraversal(child);
		}
		System.out.println(root.data);
	}
	
	public static void levelOrderTraversal(Node root) {
		// it prints level by level element in a single line
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		while(q.size()>0) {
			Node rem =q.remove();
			for(Node child: rem.children) {
				q.add(child);
			}
			System.out.print(rem.data+" ");
			
		}
	}
	
	
	public static void levelOrderLineWise(Node root) {
		Queue<Node> q = new ArrayDeque<>();
		Queue<Node> hq = new ArrayDeque<>();
		q.add(root);
		while(q.size()>0) {
			Node rem  = q.remove();
			System.out.print(rem.data+" ");
			for(Node child: rem.children) {
				hq.add(child);
			}
			if(q.size()==0) {
				q = hq;
				hq = new ArrayDeque<>();
				System.out.println();
			}
		}
	}
	
	public static void levelOrderZigZag(Node root) {
		int lvl = 0;
		Stack<Node> q = new Stack<>();
		Stack<Node> hq = new Stack<>();
		q.add(root);
		while(q.size()>0) {
			Node rem = q.pop();
			System.out.print(rem.data+ " ");
			if(lvl%2==0) {
				for(Node child: rem.children) {
					hq.add(child);
				}
			}else {
				for(int i = rem.children.size()-1; i>=0; i--) {
					hq.add(rem.children.get(i));
				}
			}
			
			if(q.size()==0) {
				q = hq;
				hq = new Stack<>();
				System.out.println();
				lvl++;
			}
		}
	}
}
