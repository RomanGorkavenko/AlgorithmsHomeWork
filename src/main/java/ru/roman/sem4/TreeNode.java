package ru.roman.sem4;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TreeNode {

    static class Tree<T extends Comparable<T>> {

        private Node root;

        private class Node {
            private final T value;
            private Node left;
            private Node right;

            public Node(T value) {
                this.value = value;
            }
        }

        public void add(T value) {
            Objects.requireNonNull(value);
            root = appendNode(root, value);
        }

        private Node appendNode(Node current, T value) {
            if (current == null) {
                return new Node(value);
            }

            int compare = value.compareTo(current.value);
            if (compare < 0) {
                current.left = appendNode(current.left, value);
            } else if (compare > 0) {
                current.right = appendNode(current.right, value);
            }

            return current;
        }

        public boolean contains(T value, AtomicInteger counter) {
            return contains(root, value, counter);
        }

        private boolean contains(Node node, T value, AtomicInteger counter) {
            if(node == null){
                throw new NullPointerException("Your tree value can't be null");
            }
            counter.incrementAndGet();
            int point = node.value.compareTo(value);
            if (point > 0) {
                if (node.left != null) {
                    return contains(node.left, value, counter);
                } else {
                    return false;
                }
            }
            if (point < 0) {
                if (node.right != null) {
                    return contains(node.right, value, counter);
                }else {
                    return false;
                }
            }
            return true;
        }
    }
}
