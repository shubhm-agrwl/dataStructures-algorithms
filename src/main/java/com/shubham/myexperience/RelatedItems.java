package com.shubham.myexperience;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RelatedItems {

  public static void main(String[] args) {

    // Program to print the related items that form a chain

    List<PairString> pairStrings = new ArrayList<>();
    PairString pairString = new PairString("item1", "item2");
    PairString pairString1 = new PairString("item3", "item4");
    PairString pairString2 = new PairString("item4", "item5");
    pairStrings.add(pairString);
    pairStrings.add(pairString1);
    pairStrings.add(pairString2);

    List<String> res = largestItemAssociation(pairStrings);

    if (res!=null){
      for (String r : res) {
        System.out.println(r);
      }
    }

  }

  private static List<String> largestItemAssociation(List<PairString> itemAssociation) {
    {
      // WRITE YOUR CODE HERE

      // RETURN "null" IF NO ITEM ASSOCIATION IS GIVEN
      if (itemAssociation.isEmpty()) {
        return null;
      }

      HashMap<String, String> association = new HashMap<>();
      List<String> res = new ArrayList<>();

      // Storing the PairString as Key Value Pair
      for (PairString pairString : itemAssociation) {
        association.put(pairString.first, pairString.second);
      }

      // TreeMap to store values of HashMap
      TreeMap<String, String> sorted = new TreeMap<>();
      // Copy all data from hashMap into TreeMap and storing it lexographically
      sorted.putAll(association);

      for (Map.Entry<String, String> entry : sorted.entrySet()) {

        // Defining a current list
        List<String> curList = new ArrayList<>();
        curList.add(entry.getKey());
        curList.add(entry.getValue());
        String assoc = sorted.get(entry.getValue());

        // If the value has a mapping, add to the curList and fetch further
        while (assoc != null) {
          curList.add(assoc);
          assoc = sorted.get(assoc);
        }

        // if the current list size is greater than the existing max list, replace the maxlist
        if (curList.size() > res.size()) {
          res = curList;
        }
      }

      return res;

    }

  }
}
