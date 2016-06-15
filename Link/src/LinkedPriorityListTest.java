import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LinkedPriorityListTest {

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionGetElementAtZeroWhenSizeIsZero() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.getElementAt(0);
		
	}
	
	@Test
	public void testInsertToLeft() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "New First");
		assertEquals("New First", list.getElementAt(0));
		assertEquals("First", list.getElementAt(1));
	}

	// Write short test methods to ensure methods throw exceptions
	// when they are supposed to throw new IllegalArgumentException();
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionGetElement() {
		LinkedPriorityList<Integer> list = new LinkedPriorityList<Integer>();
		list.getElementAt(-1);
		LinkedPriorityList<Integer> listt = new LinkedPriorityList<Integer>();
		listt.getElementAt(100);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetExceptionWhenEmpty() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.getElementAt(0); 
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetExceptionWhenIndexTooBig() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "B");
		list.insertElementAt(0, "A");
		list.getElementAt(2); // should throw an exception
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetExceptionWhenIndexTooSmall() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "B");
		list.insertElementAt(0, "A");
		list.getElementAt(-1); // should throw an exception
	}

	@Test
	public void testGet() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "A");
		list.insertElementAt(0, "B");
		list.insertElementAt(0, "C");
		// Assert that all three can be retrieved from the expected index
		assertEquals("C", list.getElementAt(0));
		assertEquals("B", list.getElementAt(1));
		assertEquals("A", list.getElementAt(2));
		list.insertElementAt(1, "A");
		assertEquals("A", list.getElementAt(1));
		assertEquals("B", list.getElementAt(2));
	}

	@Test
	public void testinsertAndget() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "second");
		list.insertElementAt(0, "new first");
		assertEquals(3, list.size());
		assertEquals("new first", list.getElementAt(0));
		assertEquals("First", list.getElementAt(1));
		assertEquals("second", list.getElementAt(2));
		LinkedPriorityList<String> listt= new LinkedPriorityList<String>();
		listt.insertElementAt(0, "First");
		listt.insertElementAt(0, "First");
		listt.insertElementAt(0, "First");
		listt.insertElementAt(0, "First");
		listt.insertElementAt(1, "second");
		assertEquals("second",listt.getElementAt(1));
		assertEquals("First",listt.getElementAt(2));
		assertEquals("First",listt.getElementAt(4));
		LinkedPriorityList<String> lis = new LinkedPriorityList<String>();
		lis.insertElementAt(0, "1");
		lis.insertElementAt(1, "2");
		lis.insertElementAt(2, "3");
		lis.insertElementAt(3, "4");
		assertEquals(4,lis.size());
		assertEquals("1",lis.getElementAt(0));
		assertEquals("2",lis.getElementAt(1));
		assertEquals("3",lis.getElementAt(2));
		assertEquals("4",lis.getElementAt(3));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInsertThrowsException() {
		LinkedPriorityList<Integer> list = new LinkedPriorityList<Integer>();
		list.insertElementAt(-1, 0);

	}
	@Test(expected = IllegalArgumentException.class)
	public void testInsertThrowsException2() {
		LinkedPriorityList<Integer> list = new LinkedPriorityList<Integer>();
		list.insertElementAt(1, 0);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetThrowsException() {
		LinkedPriorityList<Integer> list = new LinkedPriorityList<Integer>();
		list.getElementAt(-2);
		LinkedPriorityList<Object> listt = new LinkedPriorityList<Object>();
		listt.getElementAt(15);
	}

	@Test
	public void testsize() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(1, "New First");
		assertEquals(2, list.size());
	}

	@Test
	public void testsizewhenitis0() {
		LinkedPriorityList<String> list1 = new LinkedPriorityList<String>();
		assertEquals(0, list1.size());
	}
	@Test
	public void testisEmptyfalse() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "First");
		list.insertElementAt(0, "New First");
		assertEquals(false, list.isEmpty());
		

	}
	@Test
	public void testisEmptytrue() {
		LinkedPriorityList<String> list1 = new LinkedPriorityList<String>();
		assertEquals(true, list1.isEmpty());
	}
	@Test
	public void testtoArray() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "d");
		list.insertElementAt(0, "c");
		list.insertElementAt(0, "b");
		list.insertElementAt(0, "a");
		Object[] Jack = new Object[5];
		Jack = list.toArray();
		assertEquals("a", Jack[0]);
		assertEquals("b", Jack[1]);
		assertEquals("c", Jack[2]);
		assertEquals("d", Jack[3]);
	}

	@Test
	public void testtoArraywhennequals0() {
		LinkedPriorityList<String> error = new LinkedPriorityList<String>();
		assertTrue(error.isEmpty());
		assertEquals(0,error.toArray().length);
	
		
	}

	@Test
	public void testremoveElementAt() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "5");
		list.insertElementAt(0, "4");
		list.insertElementAt(0, "3");
		list.insertElementAt(0, "2");
		list.insertElementAt(0, "1");
		list.removeElementAt(2);
		assertEquals("1", list.getElementAt(0));
		assertEquals("2", list.getElementAt(1));
		assertEquals("4", list.getElementAt(2));
		assertEquals("5", list.getElementAt(3));
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testremoveExceptionWhenIndexTooBig() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "B");
		list.insertElementAt(0, "A");
		list.removeElementAt(2); // should throw an exception
	}

	@Test(expected = IllegalArgumentException.class)
	public void testremoveExceptionWhenIndexTooSmall() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "B");
		list.insertElementAt(0, "A");
		list.removeElementAt(-1); // should throw an exception
	}

	@Test(expected = IllegalArgumentException.class)
	public void testremoveThrowsException() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "5");
		list.insertElementAt(0, "4");
		list.insertElementAt(0, "3");
		list.insertElementAt(0, "2");
		list.insertElementAt(0, "1");
		list.removeElementAt(-2);
	
	}
	@Test(expected = IllegalArgumentException.class)
	public void testremoveThrowsException2() {
		LinkedPriorityList<String> listt = new LinkedPriorityList<String>();
		listt.insertElementAt(0, "a");
		listt.insertElementAt(0, "b");
		listt.insertElementAt(0, "b");
		listt.insertElementAt(0, "b");
		listt.insertElementAt(0, "v");
		listt.removeElementAt(15);
	}

	@Test
	public void testlowerPriorityOf() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "a");
		list.insertElementAt(0, "b");
		list.lowerPriorityOf(0);
		assertEquals("a", list.getElementAt(0));
		assertEquals("b", list.getElementAt(1));
		LinkedPriorityList<String> listt = new LinkedPriorityList<String>();
		listt.insertElementAt(0, "a");
		listt.insertElementAt(0, "b");
		listt.insertElementAt(0, "b");
		listt.insertElementAt(0, "b");
		listt.insertElementAt(0, "v");
		listt.lowerPriorityOf(3);
		assertEquals("a", listt.getElementAt(3));
		assertEquals("b", listt.getElementAt(4));
	}



	@Test(expected = IllegalArgumentException.class)
	public void testlowerPriorityOfThrowsException3() {
		LinkedPriorityList<String> lis = new LinkedPriorityList<String>();
		lis.insertElementAt(0, "a");
		lis.insertElementAt(0, "b");
		lis.insertElementAt(0, "b");
		lis.lowerPriorityOf(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testlowerPriorityOfThrowsException() {
		LinkedPriorityList<String> listt = new LinkedPriorityList<String>();
		listt.insertElementAt(0, "x");
		listt.insertElementAt(0, "b");
		listt.insertElementAt(0, "z");
		listt.lowerPriorityOf(3);
	}

	
	@Test
	public void testraisePriorityOf() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "a");
		list.insertElementAt(0, "b");
		list.insertElementAt(0, "b");
		list.raisePriorityOf(2);
		assertEquals("b", list.getElementAt(0));
		assertEquals("a", list.getElementAt(1));
		LinkedPriorityList<String> listt = new LinkedPriorityList<String>();
		listt.insertElementAt(0, "d");
		listt.insertElementAt(0, "c");
		listt.insertElementAt(0, "b");
		listt.insertElementAt(0, "a");
		listt.raisePriorityOf(3);
		assertEquals("c", listt.getElementAt(3));
		assertEquals("d", listt.getElementAt(2));
		
	}


		
	
	@Test(expected = IllegalArgumentException.class)
	public void testraisePriorityOfThrowsException1() {
		LinkedPriorityList<String> listt = new LinkedPriorityList<String>();
		listt.insertElementAt(0, "c");
		listt.insertElementAt(0, "b");
		listt.insertElementAt(0, "a");
		listt.raisePriorityOf(3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testraisePriorityOfThrowsException2() {
		LinkedPriorityList<String> lis = new LinkedPriorityList<String>();
		lis.insertElementAt(0, "a");
		lis.insertElementAt(0, "b");
		lis.insertElementAt(0, "b");
		lis.raisePriorityOf(-1);
	}
	@Test
	public void testmoveToLast() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "e");
		list.insertElementAt(0, "d");
		list.insertElementAt(0, "c");
		list.insertElementAt(0, "b");
		list.insertElementAt(0, "a");
		list.moveToLast(1);
		assertEquals("a", list.getElementAt(0));
		assertEquals("c", list.getElementAt(1));
		assertEquals("d", list.getElementAt(2));
		assertEquals("e", list.getElementAt(3));
		assertEquals("b", list.getElementAt(4));
		LinkedPriorityList<String> listt = new LinkedPriorityList<String>();
		listt.insertElementAt(0, "1");
		listt.insertElementAt(0, "2");
		listt.insertElementAt(0, "3");
		listt.insertElementAt(0, "4");
		listt.insertElementAt(0, "5");
		listt.moveToLast(2);
		assertEquals("5", listt.getElementAt(0));
		assertEquals("4", listt.getElementAt(1));
		assertEquals("2", listt.getElementAt(2));
		assertEquals("1", listt.getElementAt(3));
		assertEquals("3", listt.getElementAt(4));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testmoveToLastThrowsException() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "e");
		list.insertElementAt(0, "d");
		list.insertElementAt(0, "c");
		list.insertElementAt(0, "b");
		list.insertElementAt(0, "a");
		list.moveToLast(5);

	}
	@Test(expected = IllegalArgumentException.class)
	public void testmoveToLastThrowsException2() {
		LinkedPriorityList<String> listt = new LinkedPriorityList<String>();
		listt.insertElementAt(0, "1");
		listt.insertElementAt(0, "2");
		listt.insertElementAt(0, "3");
		listt.insertElementAt(0, "4");
		listt.moveToLast(-1);
	}

	@Test
	public void testmoveToTop() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "e");
		list.insertElementAt(0, "d");
		list.insertElementAt(0, "c");
		list.insertElementAt(0, "b");
		list.insertElementAt(0, "a");
		list.moveToTop(1);
		assertEquals("b", list.getElementAt(0));
		assertEquals("a", list.getElementAt(1));
		assertEquals("c", list.getElementAt(2));
		assertEquals("d", list.getElementAt(3));
		assertEquals("e", list.getElementAt(4));
		LinkedPriorityList<String> listt = new LinkedPriorityList<String>();
		listt.insertElementAt(0, "e");
		listt.insertElementAt(0, "d");
		listt.insertElementAt(0, "c");
		listt.insertElementAt(0, "b");
		listt.insertElementAt(0, "a");
		listt.moveToTop(2);
		assertEquals("c", listt.getElementAt(0));
		assertEquals("a", listt.getElementAt(1));
		assertEquals("b", listt.getElementAt(2));
		assertEquals("d", listt.getElementAt(3));
		assertEquals("e", listt.getElementAt(4));
		listt.moveToTop(0);
		assertEquals("c", listt.getElementAt(0));
		assertEquals("a", listt.getElementAt(1));
		assertEquals("b", listt.getElementAt(2));
		assertEquals("d", listt.getElementAt(3));
		assertEquals("e", listt.getElementAt(4));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testmoveToTopThrowsException() {
		LinkedPriorityList<String> list = new LinkedPriorityList<String>();
		list.insertElementAt(0, "e");
		list.insertElementAt(0, "d");
		list.insertElementAt(0, "c");
		list.insertElementAt(0, "b");
		list.insertElementAt(0, "a");
		list.moveToTop(5);
		

	}

	@Test(expected = IllegalArgumentException.class)
	public void testmoveToTopThrowsException2() {
		LinkedPriorityList<String> listt = new LinkedPriorityList<String>();
		listt.insertElementAt(0, "e");
		listt.insertElementAt(0, "d");
		listt.insertElementAt(0, "c");
		listt.insertElementAt(0, "b");
		listt.insertElementAt(0, "a");
		listt.moveToTop(-1);
	}
}
