package com.shubham.dataStructures.ddArray;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class KWeakestRows {

  public int[] kWeakestRows(int[][] mat, int k) {
    Map<Integer,Integer> map=new HashMap<>();
    int res[]=new int[k];
    for(int i=0;i<mat.length;i++){
      int count=0;
      for(int j=0;j<mat[i].length;j++){
        if(mat[i][j]==1)
          count++;
        else break;
      }
      map.put(i,count);
    }

    List<Entry<Integer,Integer>> list=new LinkedList<Entry<Integer,Integer>>(map.entrySet());

    Collections.sort(list,new Comparator<Entry<Integer,Integer>>(){
      public int compare(Map.Entry<Integer,Integer> a,Map.Entry<Integer,Integer> b){
        if(a.getValue()==b.getValue())
          return a.getKey()-b.getKey();
        return a.getValue()-b.getValue();
      }
    });
    int i=0;
    for(Map.Entry<Integer,Integer> mp:list)
    {
      res[i++]=mp.getKey();
      if(i==k)
        return res;
    }
    return res;
  }

}
