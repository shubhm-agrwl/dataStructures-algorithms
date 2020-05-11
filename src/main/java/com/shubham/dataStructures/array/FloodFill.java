package com.shubham.dataStructures.array;

  /*
   An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

  Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

  To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

  At the end, return the modified image.

  Example 1:

  Input:
  image = [[1,1,1],[1,1,0],[1,0,1]]
  sr = 1, sc = 1, newColor = 2
  Output: [[2,2,2],[2,2,0],[2,0,1]]
  Explanation:
  From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
  by a path of the same color as the starting pixel are colored with the new color.
  Note the bottom corner is not colored 2, because it is not 4-directionally connected
  to the starting pixel.

  Note:
  The length of image and image[0] will be in the range [1, 50].
  The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
  The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */

public class FloodFill {

  public static void main(String[] args) {
//    int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
//        {1, 1, 1, 1, 1, 1, 0, 0},
//        {1, 0, 0, 1, 1, 0, 1, 1},
//        {1, 2, 2, 2, 2, 0, 1, 0},
//        {1, 1, 1, 2, 2, 0, 1, 0},
//        {1, 1, 1, 2, 2, 2, 2, 0},
//        {1, 1, 1, 1, 1, 2, 1, 1},
//        {1, 1, 1, 1, 1, 2, 2, 1},
//    };
    int screen[][] = {{0, 0, 0},
        {0, 1, 1}
    };
    int x = 1, y = 1, newC = 1;
    floodFill(screen, x, y, newC);

    System.out.println("Updated screen after call to floodFill: ");
    for (int i = 0; i < screen.length; i++) {
      for (int j = 0; j < screen[0].length; j++) {
        System.out.print(screen[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int prevC = image[sr][sc];
    if (prevC != newColor){
      floodFillUtil(image, sr, sc, prevC, newColor);
    }
    return image;
  }

  private static void floodFillUtil(int[][] image, int sr, int sc, int prevC, int newColor) {
    System.out.println("Setting Color at " + sr + "," + sc);
    // Base cases
    if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
      return;
    }
    if (image[sr][sc] != prevC) {
      return;
    }

    // Replace the color at (x, y)
    image[sr][sc] = newColor;

    // Recur for north, east, south and west
    floodFillUtil(image, sr + 1, sc, prevC, newColor);
    floodFillUtil(image, sr - 1, sc, prevC, newColor);
    floodFillUtil(image, sr, sc + 1, prevC, newColor);
    floodFillUtil(image, sr, sc - 1, prevC, newColor);
  }

  private static void dfs(int[][] image, int r, int c, int color, int newColor) {
    if (image[r][c] == color) {
      image[r][c] = newColor;
      if (r >= 1) {
        dfs(image, r - 1, c, color, newColor);
      }
      if (c >= 1) {
        dfs(image, r, c - 1, color, newColor);
      }
      if (r + 1 < image.length) {
        dfs(image, r + 1, c, color, newColor);
      }
      if (c + 1 < image[0].length) {
        dfs(image, r, c + 1, color, newColor);
      }
    }
  }

}
