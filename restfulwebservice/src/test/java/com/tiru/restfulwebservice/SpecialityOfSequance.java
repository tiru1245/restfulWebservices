package com.tiru.restfulwebservice;

import java.util.Arrays;
import java.util.Scanner;

public class SpecialityOfSequance {
	public static void main(String[] args) {
		
	
Scanner scan = new Scanner(System.in);
int n = scan.nextInt();
int k = scan.nextInt();
int arr[] = new int[n];
int i = 0;
while(n != 0){
    arr[i] = scan.nextInt();
    i++;
    n--;
}
Arrays.sort(arr);
int sum = 0;
for(int j = 0; j < (arr.length-k); j++){
    if(arr[j] < arr[arr.length-k]){
        sum += arr[j];
    } else {
        break;
    }
}
System.out.print(sum);
}
}
