package com.perle;

import java.util.Arrays;


public class CyclicSet {

	private int[] pcycle;
	private int[] icycle;
	private int[] cyclicSet;
	
	public CyclicSet(int[] pcycle, int[] icycle) {
		this.pcycle = pcycle;
		this.icycle = icycle;
		cyclicSet = new int[pcycle.length * 2];
		for (int i = 0, j = 0; i < cyclicSet.length; i=i+2, j++) {
			cyclicSet[i] = pcycle[j];
			cyclicSet[i + 1] = icycle[j];
		}
	}
	
	public int[] getCyclicSet(){
		return cyclicSet;
	}
	
	public int getLeftTonicSum(){
		return cyclicSet[0] + cyclicSet[1];
	}
	
	public int getRightTonicSum(){
		return cyclicSet[1] + cyclicSet[2];
	}
	
	public int[] getTonicSums(){
		int[] tonicSums = new int[2];
		tonicSums[0] = cyclicSet[0] + cyclicSet[1];
		tonicSums[1] = cyclicSet[1] + cyclicSet[2];
		return tonicSums;
	}
	
	public String getName(){
		return getPTonicSumName(getLeftTonicSum()) + getITonicSumName(getRightTonicSum());
	}

	private String getPTonicSumName(int tonicSum) {
		String name;
		if (tonicSum % 2 == 0) {
			name = "p" + tonicSum;
		}else{
			name = "i" + tonicSum;
		}
		return name;
	}
	
	private String getITonicSumName(int tonicSum) {
		String name;
		if (tonicSum % 2 == 0) {
			name = "i" + tonicSum;
		}else{
			name = "p" + tonicSum;
		}
		return name;
	}
	
	public static void main(String[] args) {
		CyclicSet cyclicSet = new CyclicSet(IntervalCycle.P_IC5, IntervalCycle.I_IC5);
		System.out.println(Arrays.toString(cyclicSet.getCyclicSet()));
		System.out.println(cyclicSet.getName()); 
		
		cyclicSet = new CyclicSet(IntervalCycle.P_IC1, IntervalCycle.I_IC1);
		System.out.println(Arrays.toString(cyclicSet.getCyclicSet()));
		System.out.println(cyclicSet.getName()); 
		
		cyclicSet = new CyclicSet(IntervalCycle.P_IC2, IntervalCycle.I_IC2);
		System.out.println(Arrays.toString(cyclicSet.getCyclicSet()));
		System.out.println(cyclicSet.getName()); 
		
	}
}
