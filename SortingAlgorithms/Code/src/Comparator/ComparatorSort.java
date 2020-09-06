package Comparator;

import java.util.Arrays;
import java.util.Comparator;


public class ComparatorSort {
	public static void main(String[] args) {
		Student[] st = new Student[5];
		
		st[0] = new Student("Josh", 2);
		st[1] = new Student("Jack", 1);
		st[2] = new Student("Joe", 2);
		st[3] = new Student("Jay", 1);
		st[4] = new Student("Javad", 2);
		
		Arrays.sort(st, Student.BY_NAME);
		
		for(int i = 0; i < st.length; i++)
			System.out.println(st[i].name + " " + st[i].section);
	
		Arrays.sort(st, Student.BY_SECTION);
		
		for(int i = 0; i < st.length; i++)
			System.out.println(st[i].name + " " + st[i].section);		
	}
}


//Example of Sorting Technique
class sortwithComparator {
	public static void sort(Object[] a, Comparator comparator) {
		int N = a.length;
		for (int i = 0; i< N; i++)
			for (int j = i; j > 0 && less(comparator, a[j], a[j-1]); j--)
				exch(a, j, j-1);
	}
	
	public static boolean less(Comparator c, Object v, Object w) {
		return c.compare(v, w) < 0;
	}

	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}

//Example on How to Implement Comparator
class Student {
	public static final Comparator<Student> BY_NAME = new ByName();
	public static final Comparator<Student> BY_SECTION = new BySection();
	
	public final String name;
	public final int section;
	
	public Student(String name, int section) {
		this.name = name;
		this.section = section;
	}
	
	private static class ByName implements Comparator<Student> {
		public int compare(Student v, Student w) {
			return v.name.compareTo(w.name);
		}
	}
	
	private static class BySection implements Comparator<Student> {
		public int compare(Student v, Student w) {
			return v.section - w.section;
		}
	}	
}

//Example of order points used for Graham scan in convex hall
class Point2D {
	
	public final Comparator<Point2D> POLAR_ORDER = new PolarOrder();
	private final double x, y;
	
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	private static int ccw(Point2D a, Point2D b, Point2D c) {
		return 0;	
	}
	
	private class PolarOrder implements Comparator<Point2D> {
		public int compare(Point2D a, Point2D b) {
			double dy1 = a.y - y;
			double dy2 = a.y - y;
			
			if (dy1 == 0 && dy2 == 0) {}
			else if (dy1 >= 0 && dy2 < 0)	return -1;
			else if (dy2 >= 0 && dy1 < 0)	return 1;
			else return -ccw(Point2D.this, a, b);
			return 0;
		}
	}
}