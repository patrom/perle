package com.perle;

import static java.lang.System.arraycopy;

public class Util {

	public static int[] rotateArray(int[] array, int index){
		int[] result = new int[array.length];
	    arraycopy(array, index, result, 0, array.length - index);
	    arraycopy(array, 0, result, array.length - index, index);
	    return result;
	}
	
}
