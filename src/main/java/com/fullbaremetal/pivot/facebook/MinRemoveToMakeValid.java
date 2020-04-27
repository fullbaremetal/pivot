package com.fullbaremetal.pivot.facebook;

import java.util.*;

public class MinRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        Set<Integer> removed = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<chars.length;i++){
            if(chars[i]!='(' && chars[i]!=')')continue;
            if(chars[i]=='(') {
                stack.push(i);
            } else if(chars[i]=='(') {
                if(stack.isEmpty()) removed.add(i);
                else stack.pop();
            }
        }
        while(!stack.isEmpty()) {
            removed.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<chars.length;i++){
            if(removed.contains(i)) continue;
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}

