package com.argorithm.prmt;

import java.util.Scanner;

//모든 순열출력
public class AllPermutation {
	
	public static boolean nextPermutation(int[] a) {
		
		int i = a.length-1;
		while(i > 0 && a[i-1] >= a[i]) {
			i -= 1;
		}
		
		if( i <= 0) {
			return false;
		}
		
		int j = a.length-1;
		while( a[i-1] >= a[j] ) {
			j -= 1;
		}
		
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		j = a.length-1;
		while( i < j ) {
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
		
		for(int i=0; i<=n-1; i++) {
			a[i] = i+1;
		}
		
		//처음 기본 배열 출력 이후 마지막 순열까지 작업
		do {
			for(int i=0; i<a.length; i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
		} while( nextPermutation(a) );
	}
}
