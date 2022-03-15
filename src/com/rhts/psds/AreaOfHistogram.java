package com.rhts.psds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class AreaOfHistogram {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(2,1,5,6,2,3));
        System.out.println(area(a));
    }
/*
* this will push the max value index int the top
* when ever there is a value less than the top it will compute the total area before that element
* that will be the previous topIndexValue * (width till previous value or the left pointer)
* if the stack is empty i will be the width
*
* */
    private static int area(ArrayList<Integer> a) {
        int maxArea = 0;
        Stack<Integer> indexes = new Stack<>();
        int n = a.size();
        int i = 0;
        while(!indexes.empty() || i<n) {
            if(i<n && (indexes.empty() || a.get(i) > a.get(indexes.peek()))) {
                indexes.push(i++);
            } else {
                int topIndex = indexes.pop();
//                this will give you the left pointer
                int width = indexes.empty() ? i : (i-indexes.peek()-1);
                int area = a.get(topIndex) * width;
                if(area>maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
