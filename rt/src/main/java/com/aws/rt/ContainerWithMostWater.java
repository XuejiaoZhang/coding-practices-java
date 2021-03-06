package com.example.topcoder;

//Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
//		Note: You may not slant the container and n is at least 2.

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int max = 0;
		for(int i = 0; i < height.length-1; i++){
			for(int j = i+1; j < height.length; j++) {
				int container = (j-i)* Math.min(height[i], height[j]);
				if (container >= max){
					max = container;
//					System.out.println(i);
//					System.out.println(j);
				}
			}
		}
		return max;
	}

	public static final void main(String[] args){
		ContainerWithMostWater c = new ContainerWithMostWater();
		int[] height = new int[]{1,8,6,2,5,4,8,3,7};
		int ret = c.maxArea(height);
		System.out.println(ret);
	}
}
