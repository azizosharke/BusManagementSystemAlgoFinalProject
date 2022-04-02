import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;

// https://algs4.cs.princeton.edu/52trie/TST.java.html by Sedgwick and Wayne

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
    public void set(String key, String string) throws IllegalArgumentException {          //if the system found the key in the table , it will
        if (key == null) {                                                               // automatically delete the key
            throw new IllegalArgumentException("NULL");
        }
        if (!findKey(key)) ;

        else if (string == null) ;

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
    public boolean findKey(String key) throws IllegalArgumentException {   //if the key is in the table
        if (key != null) {
            return get(key) != null;
        } else {
            throw new IllegalArgumentException("NULL");
        }
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
    private void gather(Node<String> node, StringBuilder pre, Queue<String> stack) {
        if (node != null) {
            gather(node.l, pre, stack);
            if (node.string == null) {
            } else {
                stack.add(pre.toString() + node.s);
            }
            gather(node.m, pre.append(node.s), stack);
            pre.deleteCharAt(pre.length() - 1);
            gather(node.r, pre, stack);
        }
    }
    public Iterable<String> mainKeys(String pre) throws IllegalArgumentException {
        if (pre != null) {
            Queue<String> stack = new LinkedList<>();
            Node<String> node = get(root, pre, 0);
            if (node != null) {
                if (node.string != null)
                    stack.add(pre);
                gather(node.m, new StringBuilder(pre), stack);
            }
            return stack;
        } else {
            throw new IllegalArgumentException("NULL");
        }
    }
    public List<String> busStopInfo(String input) {
        List<String> stopList = new LinkedList<>();
        for (String information : this.mainKeys(input)) {
            stopList.add(map.get(this.get(information)));
        }
        if (!stopList.isEmpty()) {
            return stopList;
        }
        stopList.add("TRY AGAIN !! \n");
        return stopList;
    }

//    private void contain(Node i, StringBuilder pre, Queue<String> q) {
//        if (i != null) {
//            contain(i.l, pre, q);
//            if (i.val == null) {
//            } else {
//                q.enqueue(pre.toString() + i);
//            }
//            contain(i.m, pre.append(i), q);
//            contain.deleteCharAt(pre.length() - 1);
//            contain(i.r, pre, q);
//        }
//    }
    public TernarySearchTree(String file) {
        File f = new File(file);
        Scanner scanner;
        scanner = null;
        try {
            scanner = new Scanner(f);
        } catch (FileNotFoundException w) {
            w.printStackTrace();
        }
        assert scanner != null;
        scanner.nextLine();

        if (scanner.hasNextLine()) {
            do {
                var wholeLine = scanner.nextLine();
                var array = wholeLine.split(",");
                var stopStationID = array[0];
                var builder = new StringBuilder();
                builder.append(array[2]);
                if (!builder.substring(0, 8).equals("fs")) {
                    switch (builder.substring(0, 2)) {
                        case "nb", "sb", "wb", "eb" -> {
                            var dir = builder.substring(0, 2);
                            builder.delete(0, 3);
                            builder.append(" ").append(dir);
                        }
                    }
                } else {
                    var sc = builder.substring(0, 11);
                    builder.delete(0, 12);
                    builder.append(" ").append(sc);
                }
                var nameOfStop = builder.toString();
                this.set(nameOfStop, stopStationID);
                var stopInformation = " ID: " + stopStationID + "\n" +
                        "CODE : " + array[1] + " |" +
                        "NAME : " + nameOfStop + " |" +
                        "DESCRIPTION : " + array[3] + "\n" +
                        "LATITUDE  : " + array[4] + " |" +
                        "LONGITUDE  : " + array[5] + " |" +
                        "ZONE : " + array[6] + " |" +
                        " LOCATION TYPE : " + array[8] + "\n -------------------------";
                map.put(stopStationID, stopInformation);
            } while (scanner.hasNextLine());
        }
    }
}


// do {
//         var wholeLine = scanner.nextLine();
//         var array = wholeLine.split(",");
//         var stopStationID = array[0];
//         var builder = new StringBuilder();
//         builder.append(array[2]);
//         if (!builder.substring(0, 8).equals("fs")) {
//         switch (builder.substring(0, 2)) {
//         case "nb", "sb", "wb", "eb" -> {
//         var dir = builder.substring(0, 2);
//         builder.delete(0, 3);
//         builder.append(" ").append(dir);
//         }
//         }
//         } else {
//         var sc = builder.substring(0, 11);
//         builder.delete(0, 12);
//         builder.append(" ").append(sc);
//         }
// finished TST by looking at the slides and Youtube