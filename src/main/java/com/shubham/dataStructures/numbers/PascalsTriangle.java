package com.shubham.dataStructures.numbers;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

  public static void main(String[] args) {
    System.out.println(generate2(5));
  }

  public static List<List<Integer>> generate2(int numRows) {

    List<List<Integer>> res = new ArrayList<>();

    if (numRows == 1) {
      List<Integer> r = new ArrayList<>(1);
      r.add(1);
      res.add(r);
      return res;
    }

    if (numRows >= 2) {
      List<Integer> r2 = new ArrayList<>(1);
      r2.add(1);
      res.add(r2);
      List<Integer> r = new ArrayList<>(2);
      r.add(1);
      r.add(1);
      res.add(r);
    }

    for (int i = 3; i <= numRows; i++) {
      List<Integer> prev = res.get(i - 2);
      List<Integer> r = new ArrayList<>();
      r.add(1);
      int j = 0;
      while (j < (i - 2)) {
        r.add(prev.get(j++) + prev.get(j++));
      }
      r.add(1);
      res.add(r);
    }
    return res;

  }

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<List<Integer>>();

    // First base case; if user requests zero rows, they get zero rows.
    if (numRows == 0) {
      return triangle;
    }

    // Second base case; first row is always [1].
    triangle.add(new ArrayList<>());
    triangle.get(0).add(1);

    for (int rowNum = 1; rowNum < numRows; rowNum++) {
      List<Integer> row = new ArrayList<>();
      List<Integer> prevRow = triangle.get(rowNum - 1);

      // The first row element is always 1.
      row.add(1);

      // Each triangle element (other than the first and last of each row)
      // is equal to the sum of the elements above-and-to-the-left and
      // above-and-to-the-right.
      for (int j = 1; j < rowNum; j++) {
        row.add(prevRow.get(j - 1) + prevRow.get(j));
      }

      // The last row element is always 1.
      row.add(1);

      triangle.add(row);
    }

    return triangle;
  }


  public List<Integer> getRow(int rowIndex) {

    List<Integer> res = new ArrayList<>();

    // First base case; if user requests zero rows, they get zero rows.
    if (rowIndex == 0) {
      res.add(1);
      return res;
    }

    List<Integer> prevRow = res;
    List<Integer> row = res;
    for (int rowNum = 1; rowNum <= rowIndex; rowNum++) {
      row = new ArrayList<>();

      // The first row element is always 1.
      row.add(1);

      // Each triangle element (other than the first and last of each row)
      // is equal to the sum of the elements above-and-to-the-left and
      // above-and-to-the-right.
      for (int j = 1; j < rowNum; j++) {
        row.add(prevRow.get(j - 1) + prevRow.get(j));
      }

      // The last row element is always 1.
      row.add(1);

      prevRow = row;
    }

    return row;
  }

}
