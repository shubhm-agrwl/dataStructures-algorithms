package com.shubham.dataStructures.string;

import java.util.Arrays;
import java.util.Stack;

public class SimplyfyingPath {

  public static void main(String[] args) {
    System.out.println(simplifyPath("/a/./b/../../c/"));
    System.out.println(simplifyPath("/home//foo/"));
    System.out.println(simplifyPath("/a/../../b/../c//.//"));
    System.out.println(simplifyPath2("/a//b////c/d//././/.."));
  }

  public static String simplifyPath(String path) {
    StringBuilder res = new StringBuilder("/");

    path = path.replace("/./", "");
    String[] paths = path.split("/");

    for (String p : paths) {
      if (p.equals("..")) {
        res = new StringBuilder("/");
      } else {
        res.append(p);
        if (!p.isEmpty()) {
          res.append("/");
        }
      }
    }
    if (res.length() == 1) {
      return res.toString();
    }
    return res.toString().substring(0, res.length() - 1);
  }

  public static String simplifyPath2(String path) {
    Stack<String> stack = new Stack();
    for (String token : path.split("/")) {
      if (!stack.isEmpty() && "..".equals(token)) {
        stack.pop();
      } else if (!Arrays.asList(".", "", "..").contains(token)) {
        stack.push(token);
      }
    }

    return "/" + String.join("/", stack);
  }

}
