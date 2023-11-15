/**
 * Purpose: Implements a "growable" array for Strings
 * @Author: 611092
 * 
 * 
 */


package lab3_3;

public class MyStringList 
{
	private final int INITIAL_LENGTH = 2;
	private String[] strArray; 
	private int size;
	
	public MyStringList() {
		strArray = new String[INITIAL_LENGTH];
		size = 0;

	}
	
	public void add(String s){
		if(size == strArray.length) 
			resize(); 
		strArray[size] = s;
		size++;
	}
	
	public String get(int i){
		if(i < 0 || i >= strArray.length) {
			System.out.println("Out of bound");
		}
		return strArray[i];
	}
	
	public boolean find(String s){
		for(int i = 0; i < strArray.length; i++) {
			if(strArray[i].equals(s)) return true;
		}
		return false;
	}
	
	public void insert(String s, int pos){
		if(pos < 0 || pos > size) {
			System.out.println("Invalid position");
			return;
		}
		else if(pos == size) add(s);
		else if(strArray.length == size) {
			resize();
			insertAt(s, pos);
		} else {
			insertAt(s, pos);
		}	
	}
	
	public void insertAt(String s, int pos) {
		for(int i = pos; i < size; i++) {
			String temp = strArray[i];
			strArray[i] = s;
			s = temp;
		}
		size++;
	}
	
	public boolean remove(String s){
		for (int i = 0; i < strArray.length; i++) {
			if (strArray[i].equals(s)) {
				for (int j = i; j < strArray.length - 1; j++) {
					strArray[j] = strArray[j + 1];
				}
				strArray[strArray.length - 1] = null;
				size--;
				return true;
			}
		}
		return false;
	}
	
	private void resize(){
		String[] newStrArray = new String[strArray.length * 2];
		System.arraycopy(strArray, 0, newStrArray, 0, strArray.length);
		strArray = newStrArray;
		System.out.println("Resizing...");
	}
	
	public String toString(){
		String value = "[";
		for(int i = 0; i < size; i++) {
			if (i<size-1) value = value + strArray[i] + ", ";
			else value = value + strArray[i];
		}
		value += "]";
		return value;
	}
	
	public int size() {
		return size;
	}

	public static void main(String[] args){

		MyStringList l = new MyStringList();
		l.add("Bob");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Steve");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Susan");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Mark");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Dave");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.remove("Mark");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.remove("Bob");
		System.out.println("The list of size " + l.size() + " is " + l);
	}
}