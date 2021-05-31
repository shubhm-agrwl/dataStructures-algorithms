package com.shubham.lcMayChallenge;

public class ToLowerCase {

    public static void main(String[] args) {
        System.out.println(toLowerCase("HELLO"));
    }

    public static String toLowerCase(String s) {
        String lowerCase = "";
        for(char c : s.toCharArray()){
            lowerCase = lowerCase + ( c>='A'&& c<='Z' ? (char)(c+32) : c);
        }
        return lowerCase;
    }
}
