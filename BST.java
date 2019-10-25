import java.util.*;

public class BST<T> {
	Node root;

	class Node {
		Comparable data;
		Node left;
		Node right;

		public Node(Comparable item) {
			data = item;
		}
	}

	public boolean find(Comparable item){
		return find(item, root);
	}
	public boolean find(Comparable item, Node node){
		if(node==null) //this is the base case
			return false;
		if(item == node.data) //returns true if item is found in the BST
			return true;
		if(node.data.compareTo(item)<0)
			return find(item,node.left);
		else
			return find(item,node.right);
	}

	public void insert(Comparable item){
		root = insert(item, root);
	}
	public Node insert(Comparable item, Node node){
		if(node == null){ //this is the base case; creates new node 
			return new Node(item);
		}
		if(item.compareTo(node.data)<0){
			node.right = insert(item,node.right);
			return node;
		}
		else{
			node.left = insert(item,node.left);
			return node;
		}
	}

	public void print(){
		print(root);
	}
	public void print(Node node){
		if(node != null){  
	        print(node.left); //prints out left subtree first
	        System.out.println(node.data); //prints out the data in node
	        print(node.right); //prints out right subtree last
	    }
	}

	public void delete(Comparable item){
		root = delete(item,root);
	}
	public Node delete(Comparable item,Node node){ //deletes item from node
		if(node == null)
			return null;
		if(node.data == item){
			if(node.left==null)
				return node.right;
			if(node.right==null)
				return node.left;
			if(node.right.left==null){
				node.data=node.right.data;
          		node.right=node.right.right;
          		return node;
          	}
          	else{
          		node.data = removeSmallest(node.right);
          		return node;
          	}
		}
		return node;
	}

	public Comparable removeSmallest(Node node){
		if(node.left.left == null){
            Comparable smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
        } 
        else {
            return removeSmallest(node.left);
		}
	}

}

