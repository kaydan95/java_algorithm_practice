package com.example.view.BJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;



class subin_location{
    int Location;
    int Time;
    public subin_location(int Location, int Time){
        this.Location = Location;
        this.Time = Time;
    }
}

public class BJoon12851 {

    static Queue<subin_location> queue = new LinkedList<>();
    static boolean checked[];
    static int dir[] = {2, -1, 1};
    static int cnt = 0;
    static int subin, ys;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String F = br.readLine();
        String[] FF = F.split(" ");

        subin = Integer.parseInt(FF[0]);
        ys = Integer.parseInt(FF[1]);

        checked = new boolean[100001];

        System.out.println(finding_ys());
        System.out.println(cnt);
        
    }

    private static int finding_ys(){
        queue.add(new subin_location(subin, 0));
        checked[subin] = true;

        int moving[] = new int[3];
        while(!queue.isEmpty()){
            subin_location start_point = queue.poll();
            checked[start_point.Location] = true;

            for(int i=0; i<dir.length; i++){
                if(i == 0){
                    moving[i] = start_point.Location * dir[i];
                } else  moving[i] = start_point.Location + dir[i];
            }

            if(start_point.Location == ys){
                ans = Math.min(ans, start_point.Time);
                if(ans != start_point.Time) break;
                cnt+=1;
            }

            for(int i=0; i<moving.length; i++){
                if(moving[i]>=0 && moving[i]<=100000 && !checked[moving[i]]){
                    queue.add(new subin_location(moving[i], start_point.Time+1));
                }
            }
        }return ans;
    }

}