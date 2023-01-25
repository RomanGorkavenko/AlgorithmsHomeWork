package ru.roman.sem3;

import java.util.*;

public class ListLinkedNodeAlternative {

    public static void main(String[] args) {
        //ListNode listNode = new ListNode(9, new ListNode(4, new ListNode(8, new ListNode(1))));

        ListNode listNode = new ListNode();


        listNode.addFirst(22);
        listNode.addFirst(23);
        listNode.addFirst(24);
        listNode.addFirst(25);
        listNode.addFirst(26);
        System.out.println(listNode);

        listNode.removeFirst();
        System.out.println(listNode);

        listNode.reverse();
        System.out.println(listNode);
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

        public void addFirst(int value) {
            if (val != 0) {
                next = list(this);
            }

            val = value;
        }

        public void removeFirst() {
            if (next == null) {
                val = 0;
            } else {
                val = next.val;
                next = next.next;
            }
        }

        public void reverse() {
            List<Integer> list = new ArrayList<>();
            for (Integer i : this) {
                list.add(i);
            }
            Collections.reverse(list);
            val = list.get(0);
            list.remove(0);
            next = list(list);
        }

        public static ListNode list(ListNode listNode) {
            ListNode listResultTemp = null;
            ListNode listResult = null;

            for (Integer i : listNode) {
                ListNode temp = new ListNode(i);

                if (listResult == null) {
                    listResult = temp;
                    listResultTemp = listResult;
                } else {
                    listResultTemp.next = temp;
                    listResultTemp = listResultTemp.next;
                }
            }
            return listResult;
        }

        public static ListNode list(List<Integer> list) {
            ListNode listResultTemp = null;
            ListNode listResult = null;

            for (Integer i : list) {
                ListNode temp = new ListNode(i);

                if (listResult == null) {
                    listResult = temp;
                    listResultTemp = listResult;
                } else {
                    listResultTemp.next = temp;
                    listResultTemp = listResultTemp.next;
                }
            }
            return listResult;
        }



        @Override
        public Iterator<Integer> iterator() {
            ListNode node = this;
            return new ListNodeIterator(node);
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
