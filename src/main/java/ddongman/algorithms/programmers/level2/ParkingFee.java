package ddongman.algorithms.programmers.level2;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class ParkingFee {
    public int[] solution(int[] fees, String[] records) {
        LinkedHashMap<String, LocalTime> record = new LinkedHashMap<>();

        Map<String, Integer> parkingTime = Arrays.stream(records)
                .collect(Collectors.toMap(r -> r.split(" ")[1],
                        r -> 0,
                        (org, newer) -> org,
                        TreeMap::new));

        for (String r : records) {
            String[] s = r.split(" ");
            LocalTime time = LocalTime.parse(s[0]);
            String carNumber = s[1];
            String inOrOut = s[2];

            if (isIn(inOrOut)) {
                record.put(carNumber, time);
            } else {
                LocalTime inTime = record.get(carNumber);
                int parkTime = calcParkingTime(inTime, time);
                parkingTime.put(carNumber, parkingTime.get(carNumber) + parkTime);

                record.remove(carNumber);
            }
        }

        if (!record.isEmpty()) {
            for (String carNumber : record.keySet()) {
                LocalTime inTime = record.get(carNumber);
                LocalTime time = LocalTime.of(23, 59);
                int parkTime = calcParkingTime(inTime, time);
                parkingTime.put(carNumber, parkingTime.get(carNumber) + parkTime);
            }
        }

        return parkingTime.entrySet()
                .stream()
                .mapToInt(e -> {
                    if (e.getValue() <= fees[0]) {
                        return fees[1];
                    } else {
                        return fees[1] + (int)Math.ceil((float)(e.getValue() - fees[0]) / fees[2]) * fees[3];
                    }
                }).toArray();
    }

    private int calcParkingTime(LocalTime inTime, LocalTime outTime) {
        int hour = outTime.getHour() - inTime.getHour();
        int minute = outTime.getMinute() - inTime.getMinute();

        if (minute < 0) {
            minute += 60;
            hour -= 1;
        }

        return hour * 60 + minute;
    }

    private boolean isIn(String inOrOut) {
        return inOrOut.equals("IN");
    }
}
