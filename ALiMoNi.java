package testjava;

import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String line1 = br.readLine().trim();
        int n = Integer.parseInt(line1); 
        String line2 = br.readLine();
        String[] s = line2.trim().split(" ");
        int M = Integer.parseInt(s[0]);
        int col = Integer.parseInt(s[1]);
        int[][] mat = new int[M][col];

        String line = null;
        for(int i=0;i<M;i++){
        	line = br.readLine();
            String[] ss = line.trim().split(" ");
            mat[i][0] = Integer.parseInt(ss[0]);
            mat[i][1] = Integer.parseInt(ss[1]);      
        }    
        int[][] graph = new int[n][n];
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		graph[i][j]=0;
        	}
        }
        for(int i=0;i<M;i++) {
        	int temp_i = mat[i][0];
        	int temp_j = mat[i][1];
        	graph[temp_i][temp_j] = 1;
        }
        int[] num_i = new int[n];
        for(int i=0;i<n;i++) {
        	num_i[i] = 0;
        }
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		num_i[i]+=graph[i][j];
        	}
        }

        int[] max = new int[n];
        for(int i=0;i<n;i++) {
        	max[i]=0;
        }
        for(int i=0;i<n;i++) {
        	max[i] = num_i[i];
        	for(int j=0;j<n;j++) {
        		if(graph[i][j]==1) {
        			max[i]+=num_i[j];
        		}
        	}
        }
        
        int max_value = 0;
        for(int i=0;i<n;i++) {
        	if(max[i]>max_value) {
            	max_value=max[i];
            }
        }
        System.out.println(max_value);
        
    }

}
