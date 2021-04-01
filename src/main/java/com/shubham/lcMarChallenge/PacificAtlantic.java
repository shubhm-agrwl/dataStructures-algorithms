package com.shubham.lcMarChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlantic {

  private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
  private int numRows;
  private int numCols;
  private int[][] landHeights;

  public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    // Check if input is empty
    if (matrix.length == 0 || matrix[0].length == 0) {
      return new ArrayList<>();
    }

    // Save initial values to parameters
    numRows = matrix.length;
    numCols = matrix[0].length;
    landHeights = matrix;
    boolean[][] pacificReachable = new boolean[numRows][numCols];
    boolean[][] atlanticReachable = new boolean[numRows][numCols];

    // Loop through each cell adjacent to the oceans and start a DFS
    for (int i = 0; i < numRows; i++) {
      dfs(i, 0, pacificReachable);
      dfs(i, numCols - 1, atlanticReachable);
    }
    for (int i = 0; i < numCols; i++) {
      dfs(0, i, pacificReachable);
      dfs(numRows - 1, i, atlanticReachable);
    }

    // Find all cells that can reach both oceans
    List<List<Integer>> commonCells = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        if (pacificReachable[i][j] && atlanticReachable[i][j]) {
          //commonCells.add(List);
        }
      }
    }
    return commonCells;
  }

  private void dfs(int row, int col, boolean[][] reachable) {
    // This cell is reachable, so mark it
    reachable[row][col] = true;
    for (int[] dir : DIRECTIONS) { // Check all 4 directions
      int newRow = row + dir[0];
      int newCol = col + dir[1];
      // Check if new cell is within bounds
      if (newRow < 0 || newRow >= numRows || newCol < 0 || newCol >= numCols) {
        continue;
      }
      // Check that the new cell hasn't already been visited
      if (reachable[newRow][newCol]) {
        continue;
      }
      // Check that the new cell has a higher or equal height,
      // So that water can flow from the new cell to the old cell
      if (landHeights[newRow][newCol] < landHeights[row][col]) {
        continue;
      }
      // If we've gotten this far, that means the new cell is reachable
      dfs(newRow, newCol, reachable);
    }
  }

  public List<List<Integer>> pacificAtlanticNotWorking(int[][] matrix) {
    // Check if input is empty
    if (matrix.length == 0 || matrix[0].length == 0) {
      return new ArrayList<>();
    }

    // Save initial values to parameters
    numRows = matrix.length;
    numCols = matrix[0].length;
    landHeights = matrix;

    // Setup each queue with cells adjacent to their respective ocean
    Queue<int[]> pacificQueue = new LinkedList<>();
    Queue<int[]> atlanticQueue = new LinkedList<>();
    for (int i = 0; i < numRows; i++) {
      pacificQueue.offer(new int[]{i, 0});
      atlanticQueue.offer(new int[]{i, numCols - 1});
    }
    for (int i = 0; i < numCols; i++) {
      pacificQueue.offer(new int[]{0, i});
      atlanticQueue.offer(new int[]{numRows - 1, i});
    }

    // Perform a BFS for each ocean to find all cells accessible by each ocean
    boolean[][] pacificReachable = bfs(pacificQueue);
    boolean[][] atlanticReachable = bfs(atlanticQueue);

    // Find all cells that can reach both oceans
    List<List<Integer>> commonCells = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        if (pacificReachable[i][j] && atlanticReachable[i][j]) {
          //commonCells.add(List.of(i, j));
        }
      }
    }
    return commonCells;
  }

  private boolean[][] bfs(Queue<int[]> queue) {
    boolean[][] reachable = new boolean[numRows][numCols];
    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      // This cell is reachable, so mark it
      reachable[cell[0]][cell[1]] = true;
      for (int[] dir : DIRECTIONS) { // Check all 4 directions
        int newRow = cell[0] + dir[0];
        int newCol = cell[1] + dir[1];
        // Check if new cell is within bounds
        if (newRow < 0 || newRow >= numRows || newCol < 0 || newCol >= numCols) {
          continue;
        }
        // Check that the new cell hasn't already been visited
        if (reachable[newRow][newCol]) {
          continue;
        }
        // Check that the new cell has a higher or equal height,
        // So that water can flow from the new cell to the old cell
        if (landHeights[newRow][newCol] < landHeights[cell[0]][cell[1]]) {
          continue;
        }
        // If we've gotten this far, that means the new cell is reachable
        queue.offer(new int[]{newRow, newCol});
      }
    }
    return reachable;
  }

  public List<List<Integer>> pacificAtlanticWorking(int[][] matrix) {
    if (matrix.length == 0) {
      return new ArrayList();
    }

    int R = matrix.length, C = matrix[0].length;

    boolean[][] pacific = new boolean[R][C];
    boolean[][] atlantic = new boolean[R][C];

    for (int i = 0; i < R; i++) {
      bfs(i, 0, matrix, pacific);
      bfs(i, C - 1, matrix, atlantic);
    }

    for (int j = 0; j < C; j++) {
      bfs(0, j, matrix, pacific);
      bfs(R - 1, j, matrix, atlantic);
    }

    List<List<Integer>> list = new ArrayList();
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          list.add(Arrays.asList(i, j));
        }
      }
    }

    return list;
  }

  private void bfs(int x, int y, int[][] matrix, boolean[][] visited) {
    int R = matrix.length, C = matrix[0].length;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{x, y});
    visited[x][y] = true;
    int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    while (q.size() > 0) {
      x = q.peek()[0];
      y = q.peek()[1];
      q.poll();

      for (int[] d : dir) {
        int nx = x + d[0];
        int ny = y + d[1];

        if (nx >= 0 && nx < R && ny >= 0 && ny < C && matrix[x][y] <= matrix[nx][ny]
            && !visited[nx][ny]) {
          q.add(new int[]{nx, ny});
          visited[nx][ny] = true;
        }
      }
    }
  }

}
