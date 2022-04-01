import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;


public class TernarySearchTree {
    private Node<String> root;
    private final HashMap<String, String> map = new HashMap<>();

    private static class Node<String> {
        private char s;
        private Node<String> l;
        private Node<String> m;
        private Node<String> r;
        private String string;

    }

    public void set(String key, String string) {          //if the system found the key in the table , it will
        if (key == null) {                                // automatically delete the key
            throw new IllegalArgumentException("NULL");
        }
        if (!findKey(key));

        else if (string == null);

        root = set(root, key, string, 0);
    }
    private Node<String> set(Node<String> node, String k, String string, int g) {
        char a = k.charAt(g);
        if (node != null) {
        } else {
            node = new Node<>();
            node.s = a;
        }
        if (a >= node.s) {
            if (a <= node.s) {
                if (g < k.length() - 1)
                    node.m = set(node.m, k, string, g + 1);
                else
                    node.string = string;
            } else {
                node.r = set(node.r, k, string, g);
            }
        } else {
            node.l = set(node.l, k, string, g);
        }
        return node;
    }


    public boolean findKey(String key) {   //if the key is in the table
        if (key != null) {
            return get(key) != null;
        }
        throw new IllegalArgumentException("NULL");
    }

    public String get(String k) throws IllegalArgumentException {          // if there is a key that matches a string
        if (k != null) {                   // this function should return the string and null if not as
            if (k.length() == 0)           // I threw an exception
                throw new IllegalArgumentException(" MUST BE  >= 1 !!");
            Node<String> node = get(root, k, 0);
            return node == null ? null : node.string;
        } else {
            throw new IllegalArgumentException("NULL");
        }
    }

    private Node<String> get(Node<String> node, String k, int g) throws IllegalArgumentException {
        if (node != null) {
            if (k.length() != 0) {
                char a = k.charAt(g);
                if (a >= node.s) {
                    if (a > node.s)
                        return get(node.r, k, g);
                    else if (g < k.length() - 1)
                        return get(node.m, k, g + 1);
                    else
                        return node;
                } else {
                    return get(node.l, k, g);
                }
            } else {
                throw new IllegalArgumentException("MUST BE  >= 1 !!");
            }
        } else {
            return null;
        }
    }

}