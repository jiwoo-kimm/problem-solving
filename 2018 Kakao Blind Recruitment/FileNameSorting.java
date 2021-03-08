// 2018 카카오 블라인드 채용
// 파일명 정렬
// 2021.03.08

import java.util.*;

class Solution {
    
    private static final int START = 0;
    private static final int END = 1;

    public String[] solution(String[] files) {
        List<FileName> result = parseFiles(files);
        result.sort(FileName::compareTo);
        return buildStringArray(result);
    }

    private List<FileName> parseFiles(String[] files) {
        List<FileName> result = new ArrayList<>();
        for (String file : files) {
            int[] indexOfNumber = getStartAndEndIndexOfNumber(file);
            String head = file.substring(0, indexOfNumber[START]);
            String number = file.substring(indexOfNumber[START], indexOfNumber[END] + 1);
            String tail = parseTail(file, indexOfNumber[END] + 1);
            FileName fileName = new FileName(head, number, tail);
            result.add(fileName);
        }
        return result;
    }

    private int[] getStartAndEndIndexOfNumber(String file) {
        boolean isCurrentCharNumber = false;
        int startOfNumber = 0, endOfNumber = 0;
        for (int i = 0; i < file.length(); i++) {
            if (file.charAt(i) >= '0' && file.charAt(i) <= '9') {
                if (!isCurrentCharNumber) {
                    startOfNumber = i;
                    isCurrentCharNumber = true;
                }
            } else {
                if (isCurrentCharNumber) {
                    endOfNumber = i - 1;
                    break;
                }
            }
        }
        if (endOfNumber == 0) endOfNumber = file.length() - 1;
        if (isNumberLongerThanLimit(startOfNumber, endOfNumber)) endOfNumber = startOfNumber + 4;
        return new int[]{startOfNumber, endOfNumber};
    }

    private boolean isNumberLongerThanLimit(int startOfNumber, int endOfNumber) {
        return endOfNumber - startOfNumber > 4;
    }

    private String parseTail(String file, int startIndex) {
        if (startIndex < file.length()) return file.substring(startIndex);
        else return "";
    }

    private String[] buildStringArray(List<FileName> sortedFiles) {
        String[] result = new String[sortedFiles.size()];
        for (int i = 0; i < sortedFiles.size(); i++)
            result[i] = sortedFiles.get(i).fileName();
        return result;
    }
}

class FileName {
    String head;
    String number;
    String tail;
    int numberValue;

    public FileName(String head, String number, String tail) {
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.numberValue = parseNumberValue(number);
    }

    private int parseNumberValue(String str) {
        int value = 0, digit = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            value += Integer.parseInt(str.charAt(i) + "") * digit;
            digit *= 10;
        }
        return value;
    }

    public String fileName() {
        return head + number + tail;
    }
    
    public static int compareTo(FileName o1, FileName o2) {
        if (o1.head.compareToIgnoreCase(o2.head) == 0)
            return Integer.compare(o1.numberValue, o2.numberValue);
        else
            return o1.head.compareToIgnoreCase(o2.head);
    }
}