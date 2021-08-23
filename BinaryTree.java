package sample;


import java.util.HashMap;
import java.util.LinkedList;

class BinaryTree{
    public class Node {
        int value;

        public Node root;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            setLeft(null);
            setRight(null);
        }

        public int getData() {
            return value;
        }

        public void setData(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public Node root;
    public BinaryTree(){
        this.root=null;
    }

    public boolean find(int key){
        Node current=root;
        while(current!=null){
            if(current.getData()==key){
                return true;
            }else if(current.getData()>key){
                current=current.getLeft();
            }else{
                current=current.getRight();
            }
        }
        return false;
    }

    public boolean delete(int key){
        Node parent=null;
        Node current=root;
        boolean isLeftChild=false;
        while(current.getData()!=key){
            parent=current;
            if(current.getData()>key){
                current=current.getLeft();
                isLeftChild=true;
            }else{
                current=current.getRight();
                isLeftChild=false;
            }
            if(current==null){
                return false;
            }
        }
        //자식 노드가 없는 경우
        if(current.getLeft()==null && current.getRight()==null){
            if(current==root){
                root=null;
            }
            if(isLeftChild){
                parent.setLeft(null);
            }else{
                parent.setRight(null);
            }
        }
        //하나의 자식 노드를 가지고 있는 경우
        else if(current.getRight()==null){
            if(isLeftChild){
                parent.setLeft(current.getLeft());
            }else{
                parent.setRight(current.getLeft());
            }
        }else if(current.getLeft()==null){
            if(isLeftChild){
                parent.setLeft(current.getRight());
            }else{
                parent.setRight(current.getRight());
            }
        }
        //두개의 자식 노드를 가지고 있는 경우
        else if(current.getLeft()!=null && current.getRight()!=null){
            //오른쪽 서브트리의 최솟값을 찾는다.
            Node successor=succesor(current));
            if(isLeftChild){
                if(current==root){
                    root=successor;
                }else if(isLeftChild){
                    root.setLeft(successor);
                }else{
                    root.setRight(successor);
                }
            }
            successor.setLeft(current.getRight());
        }
        return true;
    }

    public Node succesor(Node deleteNode){
        Node successor=deleteNode;
        Node succesorParent=null;
        Node current= deleteNode.getRight();
        while(current!=null){
            succesorParent=successor;
            successor=current;
            current=current.getRight();

        }
        if(successor!=deleteNode.getRight()){
            succesorParent.setLeft(successor.getLeft());
            succesorParent.setRight(successor.getRight());
        }
        return successor;
    }

    public void insert(int key){
        Node newNode = new Node(key);
        if(root==null){
            root= newNode.left;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent=current;
            if(current.getData()>key){
                current= current.getLeft();
                if(current==null){
                    parent.setLeft(newNode);
                    return;
                }
            }else{
                current= current.getRight();
                if(current==null){
                    parent.setRight(newNode);
                    return;
                }
            }
        }
    }

    public void display(Node root){
        if(root!=null){
            display(root.getLeft());
            System.out.println("현재 값은 "+ root.getData());
            display(root.getRight());
        }
    }


}


public class Main{
    static public void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(8);
        tree.insert(7);
        tree.insert(10);
        tree.insert(9);
        tree.insert(11);

        tree.removeNode(10);
    }
}
