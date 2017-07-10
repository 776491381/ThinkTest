package Sorting;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *堆排序
 * Created by fyy on 5/28/17.
 */
public class HeapSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < sum; i++) {
            list.add(scanner.nextInt());
        }
        Node Root = new Node(list.get(0));
        Root.setParent(null);
        List<Node> tree = new ArrayList<>();
        tree.add(Root);

        for (int i = 1; i <= sum - 1; i++) {
            int parSub = (i + 1) / 2 - 1;
            Node node = new Node(list.get(i));
            node.setParent(tree.get(parSub));
            if ((i + 1) % 2 == 0)
                tree.get(parSub).setLchild(node);
            else
                tree.get(parSub).setRchild(node);
            tree.add(node);
        }

        for (Node aTree : tree) {
            System.out.println(aTree.toString());
        }


        swap(tree, sum);

        sort(tree);

//        tree.forEach((x) -> System.out.println(x.toString()));


    }


    private static void  sort(List<Node> tree ){

        while (tree.size()>0) {
            System.out.println(tree.get(0).getKey());
            tree.get(0).setKey(tree.get(tree.size() - 1).getKey());
            tree.remove(tree.get(tree.size() - 1));
            swap(tree, tree.size());
        }
    }
    private static void swap(List<Node> tree, int sum) {
        boolean flag ;

        do {
            flag = false;
            for (int i = sum / 2 - 1; i >= 0; i--) {
                int temp ;
                if (tree.get(i).getRchild() != null) {
                    temp = tree.get(i).getRchild().getKey() >= tree.get(i).getLchild().getKey()
                            ? tree.get(i).getRchild().getKey() : tree.get(i).getLchild().getKey();
                    if (temp > tree.get(i).getKey()) {
                        if (tree.get(i).getRchild().getKey() >= tree.get(i).getLchild().getKey()) {

                            flag = true;
                            Node tempRNode = tree.get(i).getRchild().getRchild();
                            Node temoLNode = tree.get(i).getRchild().getLchild();
                            tree.get(i).getRchild().setParent(tree.get(i).getParent());
                            if (tree.get(i).getLchild() != null)
                                tree.get(i).getLchild().setParent(tree.get(i).getRchild());
                            if (tree.get(i).getRchild().getLchild() != null) {
                                tree.get(i).getRchild().getLchild().setParent(tree.get(i));
                            }
                            if (tree.get(i).getRchild().getRchild() != null) {
                                tree.get(i).getRchild().getRchild().setParent(tree.get(i));
                            }
                            tree.get(i).getRchild().setLchild(tree.get(i).getLchild());
                            tree.get(i).getRchild().setRchild(tree.get(i));
                            if (tree.get(i).getParent() != null) {
                                if ((i + 1) % 2 == 0)
                                    tree.get(i).getParent().setLchild(tree.get(i).getRchild());
                                else
                                    tree.get(i).getParent().setRchild(tree.get(i).getRchild());
                            }
                            tree.get(i).setParent(tree.get(i).getRchild());
                            tree.get(i).setLchild(temoLNode);
                            tree.get(i).setRchild(tempRNode);
                            Node t = tree.get(i);
                            tree.set(i,tree.get(2*(i+1)));
                            tree.set(2*(i+1),t);
                        }
                        if (tree.get(i).getRchild().getKey() < tree.get(i).getLchild().getKey()) {
                            flag = true;
                            Node tempRNode = tree.get(i).getLchild().getRchild();
                            Node temoLNode = tree.get(i).getLchild().getLchild();
                            tree.get(i).getLchild().setParent(tree.get(i).getParent());
                            if (tree.get(i).getRchild() != null)
                                tree.get(i).getRchild().setParent(tree.get(i).getLchild());
//                        System.out.println(i);
                            if (tree.get(i).getLchild().getLchild() != null) {
                                tree.get(i).getLchild().getLchild().setParent(tree.get(i));
                            }
                            if (tree.get(i).getLchild().getRchild() != null) {
                                tree.get(i).getLchild().getRchild().setParent(tree.get(i));
                            }
                            if (tree.get(i).getParent() != null) {
                                if ((i + 1) % 2 == 0)
                                    tree.get(i).getParent().setLchild(tree.get(i).getLchild());
                                else
                                    tree.get(i).getParent().setRchild(tree.get(i).getLchild());
                            }
                            tree.get(i).getLchild().setLchild(tree.get(i));
                            tree.get(i).getLchild().setRchild(tree.get(i).getRchild());
                            tree.get(i).setParent(tree.get(i).getLchild());
                            tree.get(i).setLchild(temoLNode);
                            tree.get(i).setRchild(tempRNode);
                            Node t = tree.get(i);
                            tree.set(i,tree.get(2*(i+1)-1));
                            tree.set(2*(i+1)-1,t);
                        }
                    }

                } else {
//                    System.out.println(i);
//                    System.out.println(tree.get(i).getLchild().getKey());
                    if (tree.get(i).getLchild().getKey() > tree.get(i).getKey()) {
                        flag = true;
                        Node tempRNode = tree.get(i).getLchild().getRchild();
                        Node temoLNode = tree.get(i).getLchild().getLchild();
                        tree.get(i).getLchild().setParent(tree.get(i).getParent());
                        if (tree.get(i).getRchild() != null)
                            tree.get(i).getRchild().setParent(tree.get(i).getLchild());
                        if (tree.get(i).getLchild().getLchild() != null) {
                            tree.get(i).getLchild().getLchild().setParent(tree.get(i));
                        }
                        if (tree.get(i).getLchild().getRchild() != null) {
                            tree.get(i).getLchild().getRchild().setParent(tree.get(i));
                        }
                        if (tree.get(i).getParent() != null) {
                            if ((i + 1) % 2 == 0)
                                tree.get(i).getParent().setLchild(tree.get(i).getLchild());
                            else
                                tree.get(i).getParent().setRchild(tree.get(i).getLchild());
                        }
                        tree.get(i).getLchild().setLchild(tree.get(i));
                        tree.get(i).setParent(tree.get(i).getLchild());
                        tree.get(i).setLchild(temoLNode);
                        tree.get(i).setRchild(tempRNode);
                        Node t = tree.get(i);
                        tree.set(i,tree.get(2*(i+1)-1));
                        tree.set(2*(i+1)-1,t);
                    }
                }

            }

        } while (flag);

    }


}

class Node {

    Node(int key) {
        this.key = key;
    }

    private int key;
    private Node Lchild;
    private Node Rchild;
    private Node Parent;

    int getKey() {
        return key;
    }

    void setKey(int key) {
        this.key = key;
    }

    Node getLchild() {
        return Lchild;
    }

    void setLchild(Node lchild) {
        Lchild = lchild;
    }

    Node getRchild() {
        return Rchild;
    }

    void setRchild(Node rchild) {
        Rchild = rchild;
    }

    Node getParent() {
        return Parent;
    }

    void setParent(Node parent) {
        Parent = parent;
    }

    @Override
    public String toString() {
        if (this.Parent != null)
            return "key =  " + this.key + "\nparent= " + this.Parent.getKey();
        else
            return "key =  " + this.key + "\nparent= no ";


    }

}

