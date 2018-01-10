package com.argorithm.prmt;

import java.util.Scanner;

//알고리즘 - 다음 순열찾기
public class Permutation {

	public static boolean isNextPermutation(int[] a) {
		
		int i = a.length-1;
		//a[i-1] < a[i]를 구한다.
		while( i > 0 && a[i-1] >= a[i] ) {
			i -= 1;
		}
		
		//마지막 순열
		if( i<=0 ) {
			return false;
		}
		
		int j = a.length-1;
		//j[j] < a[i-1]를 구한다.
		while( a[j] <= a[i-1]) {
			j -= 1;
		}
		
		//a[j] 값과 a[i-1]값을 swap
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		//a[i] 밑으로 전부 swap
		j = a.length-1;
		while(i<j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i += 1;
			j -= 1;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for( int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		if( isNextPermutation(a) ) {
			for( int i=0; i<n; i++) {
				System.out.print(a[i]+" ");
			}
		} else {
			System.out.println("-1");
		}
	}
	
}
