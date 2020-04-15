import homework2.LinkedList;
import homework2.Node;
import homework2.operation.*;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.jupiter.api.Assertions.*;

public class TestSuite {

    @Nested
    @DisplayName("Add Operation Test")
    @RunWith(value = Parameterized.class)
    public class AddOperationTest {

        @Test
        @DisplayName("addition operation test")
        public void testOperate() {
            AddOperation addOperation = new AddOperation(5);
            assertEquals(10, addOperation.operate(5));
        }
    }

    @Nested
    @DisplayName("Increase Operation Test")
    public class IncreaseOperationTest {
        @Test
        @DisplayName("increase operation test")
        public void testOperate() {
            IncreaseOperation increaseOperation = new IncreaseOperation();
            assertEquals(6, increaseOperation.operate(5));
        }
    }

    @Nested
    @DisplayName("Multiply Operation Test")
    public class MultiplyOperationTest {

        @Test
        @DisplayName("multiply operation test")
        public void testOperate() {
            MultiplyOperation increaseOperation = new MultiplyOperation(10);
            assertEquals(20, increaseOperation.operate(2));
        }

    }

    @Nested
    @DisplayName("Node Test")
    public class NodeTest {

        @Test
        @DisplayName("set and get data test")
        public void testSetAndGetData() {
            Node node = new Node(10);
            assertEquals(10, node.getData());
        }

        @Test
        @DisplayName("String test")
        public void testToString() {
            Node node = new Node(10);
            assertEquals("10", node.toString());
        }

    }

    @Nested
    @DisplayName("Linked List Test")
    public class LinkedListTest {

        @Test
        public void testLength() {
            LinkedList linkedList = new LinkedList();
            linkedList.add(1);
            assertEquals(1, linkedList.length());
        }

        @Test
        public void testIsEmpty() {
            LinkedList linkedList = new LinkedList();
            assertTrue(linkedList.isEmpty());
        }

        @Test
        public void testAdd() {
            final int firstElement = 1;
            final int secondElement = 2;
            final int thirdElement = 0;
            LinkedList linkedList = new LinkedList();
            linkedList.add(firstElement);
            assertEquals(firstElement, linkedList.get(0));
            linkedList.add(secondElement);
            assertEquals(secondElement, linkedList.get(1));
            linkedList.add(thirdElement);
            assertEquals(thirdElement, linkedList.get(0));
            assertEquals(firstElement, linkedList.get(1));
            assertEquals(secondElement, linkedList.get(2));
        }

        @Test
        public void testGetThrowsException() {
            int index = -1;
            LinkedList linkedList = new LinkedList();
            String message = "Invalid index: " + index;
            assertThrows(IndexOutOfBoundsException.class, () -> {
                linkedList.get(index);
            }, message);
        }

        @Test
        public void testGet() {
            int index = 2;
            LinkedList linkedList = new LinkedList();
            linkedList.add(1);
            assertEquals(1, linkedList.get(0));
            linkedList.add(2);
            linkedList.add(3);
            assertEquals(3, linkedList.get(2));
        }

        @Test
        public void indexOfThrowsException() {
            int index = -1;
            LinkedList linkedList = new LinkedList();
            assertThrows(ListIsEmptyException.class, () -> {
                linkedList.indexOf(index);
            });
        }

        @Test
        public void testIndexOf() {
            final int firstElement = 1;
            final int secondElement = 2;
            final int thirdElement = 0;
            LinkedList linkedList = new LinkedList();
            linkedList.add(firstElement);
            assertEquals(0, linkedList.indexOf(firstElement));
            linkedList.add(secondElement);
            assertEquals(1, linkedList.indexOf(secondElement));
            linkedList.add(thirdElement);
            assertEquals(0, linkedList.indexOf(thirdElement));
            assertEquals(2, linkedList.indexOf(secondElement));
            assertEquals(1, linkedList.indexOf(firstElement));
            assertEquals(-1, linkedList.indexOf(12));
        }

        @Test
        public void testRemoveThrowsException() {
            int data = 2;
            LinkedList linkedList = new LinkedList();
            assertThrows(ListIsEmptyException.class, () -> {
                linkedList.remove(data);
            });
        }

        @Test
        public void testRemove() {
            final int firstElement = 1;
            final int secondElement = 2;
            LinkedList linkedList = new LinkedList();
            linkedList.add(firstElement);
            assertTrue(linkedList.remove(firstElement));
            linkedList.add(firstElement);
            linkedList.add(secondElement);
            assertFalse(linkedList.remove(1000));
            assertTrue(linkedList.remove(secondElement));
        }

        @Test
        public void testRemoveFirst() {
            LinkedList linkedList = new LinkedList();
            linkedList.removeFirst();
            linkedList.add(1);
            linkedList.removeFirst();
        }

        @Test
        public void testPerform() {
            int operand = 5;
            Operation operation = new AddOperation(operand);
            LinkedList linkedList = new LinkedList();
            linkedList.perform(operation);
            linkedList.add(-5);
            linkedList.add(0);
            linkedList.add(5);
            linkedList.perform(operation);
            assertEquals(0, linkedList.get(0));
            assertEquals(5, linkedList.get(1));
            assertEquals(10, linkedList.get(2));
        }

        @Test
        public void testToArray() {
            LinkedList linkedList = new LinkedList();
            assertEquals(0, linkedList.toArray().length);
            linkedList.add(-1);
            linkedList.add(2);
            linkedList.add(0);
            linkedList.add(40);
            int[] array = linkedList.toArray();
            assertEquals(-1, array[0]);
            assertEquals(0, array[1]);
            assertEquals(2, array[2]);
            assertEquals(40, array[3]);
        }

        @Test
        public void testToString() {
            LinkedList linkedList = new LinkedList();
            assertEquals("Empty LinkedList", linkedList.toString());
            linkedList.add(1);
            assertEquals("[1]", linkedList.toString());
            linkedList.add(-1);
            linkedList.add(0);
            assertEquals("[-1, 0, 1]", linkedList.toString());
        }

        @Timeout(100)
        @RepeatedTest(10)
        public void testPerformAddOnLongLists() {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < 100000; i++) {
                linkedList.add(i);
            }
        }

        @Test
        public void testPerformRemoveFirstOnLongLists() {
            Assumptions.assumeTrue(Runtime.getRuntime().freeMemory() >= 10e9);
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < 100000; i++) {
                linkedList.add(i);
            }
            for (int i = 0; i < 100000; i++) {
                linkedList.removeFirst();
            }
            assertEquals(0, linkedList.length());

        }

    }

}

