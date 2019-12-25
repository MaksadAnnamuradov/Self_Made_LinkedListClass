package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestClassTest extends Object {
    private DoublyLinkedList test;

    @Before
    public void setUp(){
        test = new DoublyLinkedList();

        test.addToHead(1);
        test.addToHead(2);
        test.addToHead(3);
        test.addToHead(4);
        test.addToHead(5);
        test.addToHead(6);
    }

    @Test
    public void test() {

        assertEquals(6, test.getSize());

        //System.out.println(test.toString());
        assertEquals("[6, 5, 4, 3, 2, 1]", test.toString());

        //System.out.println(test.contains(2));
        assertEquals(true, test.contains(2));


        //System.out.println(test.peekFirst());
        assertEquals(6, test.peekFirst());

        //System.out.println(test.peekLast());
        assertEquals(1, test.peekLast());

        //System.out.println(test.removeAtIndex(0));
        assertEquals(6, test.removeAtIndex(0));


        //System.out.println(test.removeAtIndex(4));
        assertEquals(1, test.removeAtIndex(4));

        //System.out.println(test.toString());
        assertEquals("[5, 4, 3, 2]", test.toString());

        //System.out.println(test.indexOf(6));
        assertEquals(2, test.indexOf(3));
    }
        @ Test
        public void testPopBack(){
            test.addToHead(1);
            test.addToHead(2);
            test.addToHead(3);
            test.addToHead(4);
            test.addToHead(5);
            test.addToHead(6);

            assertEquals(1, test.popBack());
        }

        //System.out.println(test.popBack());


        //System.out.println(test.popFront());
    @Test
    public void testPopFront(){

        assertEquals(6, test.popFront());

        //System.out.println(test.toString());
        assertEquals("[5, 4, 3, 2, 1]", test.toString());
    }

    @Test
    public void RotateClockWise(){

        assertEquals(6, test.popFront());

         test.RotateClockWise(2, test.getHead());

        //System.out.println(test.toString());
        assertEquals("[2, 1, 5, 4, 3]", test.toString());

        test.RotateClockWise(3, test.getHead());

        //System.out.println(test.toString());
        assertEquals("[5, 4, 3, 2, 1]", test.toString());


        test.RotateClockWise(5, test.getHead());

        //System.out.println(test.toString());
        assertEquals("[5, 4, 3, 2, 1]", test.toString());

    }


    @Test
    public void RotateAntiClockWise(){

        assertEquals(6, test.popFront());

        test.RotateAntiClockWise(2, test.getHead());

        //System.out.println(test.toString());
        assertEquals("[3, 2, 1, 5, 4]", test.toString());

        test.RotateAntiClockWise(3, test.getHead());

        assertEquals("[2, 1, 5, 4, 3]", test.toString());


        test.RotateAntiClockWise(5, test.getHead());

        assertEquals("[2, 1, 5, 4, 3]", test.toString());

    }


    @Test
    public void ReverseLinkedLIst(){

        test.ReverseLinkedList(test.getHead());

        //test.SetTail(test.getHead());

        assertEquals("[1, 2, 3, 4, 5, 6]", test.toString());

        assertEquals(6, test.popBack());
    }

    @Test
    public void GetMiddle(){

       test.ReverseLinkedList(test.getHead());

        //System.out.println(test.popBack());
        test.popBack();
        test.popBack();
        test.popBack();
        test.popBack();
        assertEquals(1, test.getValueAtNode(test.GetMiddle(test.getHead())));

    }


}