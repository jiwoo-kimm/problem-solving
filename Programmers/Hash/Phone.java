// 프로그래머스 '전화번호 목록'
// 해시
// 2021.01.21, 2021.08.24

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {  
        Arrays.sort(phone_book);
        
        for (int i=0 ; i<phone_book.length-1 ; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }
        
        return true;
    }
}