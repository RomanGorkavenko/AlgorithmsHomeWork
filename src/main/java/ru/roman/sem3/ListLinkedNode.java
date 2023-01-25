package ru.roman.sem3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListLinkedNode {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(9, new ListNode(4, new ListNode(8, new ListNode(1))));

        System.out.println(listNode.addFirst(22));
        System.out.println(ListNode.addFirst(22, listNode));
        System.out.println(ListNode.removeFirst(listNode));
        System.out.println(ListNode.reverse(listNode));

    }

    public static class ListNode implements Iterable<Integer> {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode addFirst(int value) {
            return addFirst(value, this);
        }

        public static ListNode addFirst(int value, ListNode listNode) {
            if (listNode == null || listNode.val == 0) {
                return new ListNode(value);
            }

            ListNode listResultTemp = null;
            ListNode listResult = null;

            for (Integer i : listNode) {
                ListNode temp = new ListNode(i);
                if (listResult == null) {
                    listResult = new ListNode(value);
                    listResultTemp = listResult;
                }

                listResultTemp.next = temp;
                listResultTemp = listResultTemp.next;
            }
            return listResult;
        }

        public static ListNode removeFirst(ListNode node) {
            if (node == null || node.val == 0) {
                return null;
            }
            ListNode listResult = null;
            ListNode listResultTemp = null;
            boolean flag = false;

            for (Integer i : node) {
                if (!flag) {
                    flag = true;
                } else {
                    ListNode temp = new ListNode(i);

                    if (listResult == null) {
                        listResult = temp;
                        listResultTemp = listResult;
                    } else {
                        listResultTemp.next = temp;
                        listResultTemp = listResultTemp.next;
                    }
                }
            }
            return listResult;
        }

        public static ListNode reverse(ListNode node) {
            if (node == null || node.val == 0) {
                return null;
            }
            List<Integer> list = new ArrayList<>();
            ListNode listResult = null;
            ListNode listResultTemp = null;

            for (Integer i : node) {
                list.add(i);
            }
            int i = list.size() - 1;
            while (i >= 0) {
                ListNode temp = new ListNode(list.get(i));

                if (listResult == null) {
                    listResult = temp;
                    listResultTemp = listResult;
                } else {
                    listResultTemp.next = temp;
                    listResultTemp = listResultTemp.next;
                }
                i--;
            }
            return listResult;
        }

        @Override
        public Iterator<Integer> iterator() {
            ListNode node = this;
            return new ListNode.ListNodeIterator(node);
        }

        private static class ListNodeIterator implements Iterator<Integer> {
            private ListNode node;

            public ListNodeIterator(ListNode node) {
                this.node = node;
            }

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Integer next() {
                int toReturn = node.val;
                node = node.next;
                return toReturn;
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder("[");

            ListNode iterator = this;
            while (iterator != null) {
                builder.append(iterator.val).append(" -> ");
                iterator = iterator.next;
            }
            builder.replace(builder.length() - 4, builder.length() - 1, "]");

            return builder.toString();
        }
    }

}
