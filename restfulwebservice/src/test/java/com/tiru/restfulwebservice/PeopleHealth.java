package com.tiru.restfulwebservice;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PeopleHealth {
public static void main(String[] args) throws IOException {
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     PrintWriter out=new PrintWriter(System.out);
    int  t=Integer.parseInt(br.readLine());
	while(t-->0) {
		String input[]=br.readLine().split(" ");
		long n=Integer.parseInt(input[0]);
		long  m=Integer.parseInt(input[1]);
		long a[]=new long[(int) n+1];
		long b[]=new long[(int) m+1];
		long c[]=new long[(int) n+1];
		input=br.readLine().split(" ");
		for(int i=1;i<n+1;i++) {
			a[i]=Integer.parseInt(input[i-1]);
			c[i]=-1;
		}
		input=br.readLine().split(" ");
		for(int i=1;i<m+1;i++) {
			 b[i]=Integer.parseInt(input[i-1]);
			
		}
		
		for(int i=1;i<m+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(j%i==0) {
					if(c[j]==-1) {
						if(a[j]-b[i]<=0) {
							c[j]=i;
						}
					
					}
				}
			}
		}
		for(int i=1;i<n+1;i++) {
			System.out.println(c[i]);
		}
	}
}
static class Reader 
{ 
	final private int BUFFER_SIZE = 1 << 16; 
	private DataInputStream din; 
	private byte[] buffer; 
	private int bufferPointer, bytesRead; 

	public Reader() 
	{ 
		din = new DataInputStream(System.in); 
		buffer = new byte[BUFFER_SIZE]; 
		bufferPointer = bytesRead = 0; 
	} 

	public Reader(String file_name) throws IOException 
	{ 
		din = new DataInputStream(new FileInputStream(file_name)); 
		buffer = new byte[BUFFER_SIZE]; 
		bufferPointer = bytesRead = 0; 
	} 

	public String readLine() throws IOException 
	{ 
		byte[] buf = new byte[64]; // line length 
		int cnt = 0, c; 
		while ((c = read()) != -1) 
		{ 
			if (c == '\n') 
				break; 
			buf[cnt++] = (byte) c; 
		} 
		return new String(buf, 0, cnt); 
	} 

	public int nextInt() throws IOException 
	{ 
		int ret = 0; 
		byte c = read(); 
		while (c <= ' ') 
			c = read(); 
		boolean neg = (c == '-'); 
		if (neg) 
			c = read(); 
		do
		{ 
			ret = ret * 10 + c - '0'; 
		} while ((c = read()) >= '0' && c <= '9'); 

		if (neg) 
			return -ret; 
		return ret; 
	} 

	public long nextLong() throws IOException 
	{ 
		long ret = 0; 
		byte c = read(); 
		while (c <= ' ') 
			c = read(); 
		boolean neg = (c == '-'); 
		if (neg) 
			c = read(); 
		do { 
			ret = ret * 10 + c - '0'; 
		} 
		while ((c = read()) >= '0' && c <= '9'); 
		if (neg) 
			return -ret; 
		return ret; 
	} 

	public double nextDouble() throws IOException 
	{ 
		double ret = 0, div = 1; 
		byte c = read(); 
		while (c <= ' ') 
			c = read(); 
		boolean neg = (c == '-'); 
		if (neg) 
			c = read(); 

		do { 
			ret = ret * 10 + c - '0'; 
		} 
		while ((c = read()) >= '0' && c <= '9'); 

		if (c == '.') 
		{ 
			while ((c = read()) >= '0' && c <= '9') 
			{ 
				ret += (c - '0') / (div *= 10); 
			} 
		} 

		if (neg) 
			return -ret; 
		return ret; 
	} 

	private void fillBuffer() throws IOException 
	{ 
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
		if (bytesRead == -1) 
			buffer[0] = -1; 
	} 

	private byte read() throws IOException 
	{ 
		if (bufferPointer == bytesRead) 
			fillBuffer(); 
		return buffer[bufferPointer++]; 
	} 

	public void close() throws IOException 
	{ 
		if (din == null) 
			return; 
		din.close(); 
	} 
}
}



