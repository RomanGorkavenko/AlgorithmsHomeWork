package ru.roman.sem4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicInteger;
import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {

    @Test
    void containsFalse() {

        AtomicInteger counter = new AtomicInteger(0);

        TreeNode.Tree<Integer> tree = new TreeNode.Tree<>();
        tree.add(5);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(8);
        tree.add(12);
        tree.add(4);

        boolean result = tree.contains(10, counter);

        assertFalse(result);
    }

    @Test
    void containsTrue() {

        AtomicInteger counter = new AtomicInteger(0);

        TreeNode.Tree<Integer> tree = new TreeNode.Tree<>();
        tree.add(5);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(8);
        tree.add(12);
        tree.add(4);

        boolean result = tree.contains(4, counter);

        assertTrue(result);
    }

    @Test
    void containsCount() {

        TreeNode.Tree<Integer> tree = new TreeNode.Tree<>();
        AtomicInteger counter = new AtomicInteger(0);
        tree.add(5);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(8);
        tree.add(12);
        tree.add(4);

        TreeNode.Tree<Integer> tree2 = new TreeNode.Tree<>();
        AtomicInteger counter2 = new AtomicInteger(0);
        tree2.add(1);
        tree2.add(2);
        tree2.add(3);
        tree2.add(4);
        tree2.add(5);
        tree2.add(12);
        tree2.add(8);

        tree.contains(12, counter);
        tree2.contains(12, counter2);

        assertEquals(3, counter.get());
        assertEquals(6, counter2.get());
    }

    @Test
    void containsNullPointerException() {

        AtomicInteger counter = new AtomicInteger(0);

        TreeNode.Tree<Integer> tree = new TreeNode.Tree<>();

        Assertions.assertThrows(NullPointerException.class, () -> tree.contains(12, counter));
    }

    @Test
    void containsNullPointerExceptionGetMassage() {

        AtomicInteger counter = new AtomicInteger(0);

        TreeNode.Tree<Integer> tree = new TreeNode.Tree<>();

        NullPointerException exception = Assertions.assertThrows(NullPointerException.class,
                () -> tree.contains(12, counter));

        assertEquals("Your tree value can't be null", exception.getMessage());
    }
}