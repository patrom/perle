package com.perle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AxisDyadArray {

	private CyclicSet topCyclicSet;
	private CyclicSet bottomCyclicSet;
	private int[] topCycle;
	private int[] bottomCycle;
	
	public AxisDyadArray(CyclicSet topCyclicSet, int startTopCyclicSet, CyclicSet bottomCyclicSet, int startBottomCyclicSet) {
		if(topCyclicSet.getCyclicSet().length < startTopCyclicSet || bottomCyclicSet.getCyclicSet().length < startBottomCyclicSet){
			throw new IllegalArgumentException("cyclic set out of bound");
		}
		this.topCyclicSet = topCyclicSet;
		this.bottomCyclicSet = bottomCyclicSet;
		topCycle = topCyclicSet.getCyclicSet();
		bottomCycle = bottomCyclicSet.getCyclicSet();
		
		if (startTopCyclicSet != 0) {
			this.topCycle = Util.rotateArray(topCyclicSet.getCyclicSet(), startTopCyclicSet);
		}
		if (startBottomCyclicSet != 0) {
			this.bottomCycle = Util.rotateArray(bottomCyclicSet.getCyclicSet(), startBottomCyclicSet);
		}
	}
	
	public String getName() {
		return topCyclicSet.getName() + "/" + bottomCyclicSet.getName();
	}
	
	public String getIntervalSystem(){
		return topCyclicSet.getCyclicInterval() + "," + bottomCyclicSet.getCyclicInterval();
	}
	
	public List<Integer> getAxisDyadChord(int axisDyadPosition){
		List<Integer> pitchClasses = new ArrayList<>();
		pitchClasses.add(topCycle[axisDyadPosition - 1]);
		pitchClasses.add(topCycle[axisDyadPosition]);
		pitchClasses.add(topCycle[axisDyadPosition + 1]);
		pitchClasses.add(bottomCycle[axisDyadPosition - 1]);
		pitchClasses.add(bottomCycle[axisDyadPosition]);
		pitchClasses.add(bottomCycle[axisDyadPosition + 1]);
		return pitchClasses;
	}
	
	public List<Integer> getCyclicChord(int axisDyadPosition){
		if (!isAxisDyadPosition(axisDyadPosition)) {
			throw new IllegalArgumentException("Not an axis dyad position");
		}
		List<Integer> pitchClasses = new ArrayList<>();
		pitchClasses.add(topCycle[axisDyadPosition - 1]);
		pitchClasses.add(topCycle[axisDyadPosition + 1]);
		pitchClasses.add(bottomCycle[axisDyadPosition - 1]);
		pitchClasses.add(bottomCycle[axisDyadPosition + 1]);
		return pitchClasses;
	}
	
	public List<Integer> getSumTetraChordLeft(int axisDyadPosition){
		if (!isAxisDyadPosition(axisDyadPosition)) {
			throw new IllegalArgumentException("Not an axis dyad position");
		}
		List<Integer> pitchClasses = new ArrayList<>();
		pitchClasses.add(topCycle[axisDyadPosition - 1]);
		pitchClasses.add(topCycle[axisDyadPosition]);
		pitchClasses.add(bottomCycle[axisDyadPosition - 1]);
		pitchClasses.add(bottomCycle[axisDyadPosition]);
		return pitchClasses;
	}
	
	public List<Integer> getSumTetraChordRight(int axisDyadPosition){
		if (!isAxisDyadPosition(axisDyadPosition)) {
			throw new IllegalArgumentException("Not an axis dyad position");
		}
		List<Integer> pitchClasses = new ArrayList<>();
		pitchClasses.add(topCycle[axisDyadPosition]);
		pitchClasses.add(topCycle[axisDyadPosition + 1]);
		pitchClasses.add(bottomCycle[axisDyadPosition]);
		pitchClasses.add(bottomCycle[axisDyadPosition + 1]);
		return pitchClasses;
	}
	
	public String printArray(){
		StringBuilder builder = new StringBuilder();
		builder.append(Arrays.toString(topCycle));
		builder.append(System.getProperty("line.separator"));
		builder.append(Arrays.toString(bottomCycle));
		return builder.toString();
	}
	
	private boolean isAxisDyadPosition(int position){
		return position % 2 == 1 && topCycle.length > position;
	}
	
	public static void main(String[] args) {
		AxisDyadArray axisDyadArray = new AxisDyadArray(new CyclicSet(IntervalCycle.P_IC5, 0), 1,
				new CyclicSet(IntervalCycle.P_IC1, 0), 0);
		System.out.println(axisDyadArray.getName());
		System.out.println(axisDyadArray.getIntervalSystem());
		System.out.println(axisDyadArray.printArray());
		System.out.println(axisDyadArray.getAxisDyadChord(3));
	}
	
}
