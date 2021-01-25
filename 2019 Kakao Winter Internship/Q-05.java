// 2019 카카오 겨울 인턴십
// 호텔 방 배정
// 2021.01.25

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hotel {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, new long[]{1, 3, 4, 1, 3, 1})));
    }

    private static Map<Long, Long> allocated = new HashMap<>();

    public static long[] solution(long k, long[] room_number) {
        ArrayList<Long> answer = new ArrayList<>();
        for (long roomNumber : room_number) {
            long result = allocateRoom(roomNumber);
            allocated.put(result, result + 1);
            answer.add(result);
        }
        return answer.stream().mapToLong(Long::longValue).toArray();
    }

    private static long allocateRoom(long roomNumber) {
        if (allocated.get(roomNumber) == null) return roomNumber;
        allocated.put(roomNumber, allocateRoom(allocated.get(roomNumber)));
        return allocated.get(roomNumber);
    }
}