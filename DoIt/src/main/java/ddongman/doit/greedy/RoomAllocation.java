package ddongman.doit.greedy;

import java.util.*;

public class RoomAllocation {
    private List<Meeting> meetings = new ArrayList<>();
    private List<Integer> counts;

    public int solution(int n, long[][] periods) {
        init(periods);

        allocationMeetingRoom();

        return Collections.max(counts);
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    private void init(long[][] periods) {
        this.meetings = new ArrayList<>();
        counts = new ArrayList<>();

        addMeeting(periods);
    }

    private void addMeeting(long[][] periods) {
        for (long[] period : periods) {
            this.meetings.add(new Meeting(period[0], period[1]));
        }

        this.meetings.sort((o1, o2) -> {
            if (!o1.getStartTime().equals(o2.getStartTime())) {
                return o1.getStartTime().compareTo(o2.getStartTime());
            } else {
                return o1.getPeriod().compareTo(o2.getPeriod());
            }
        });
    }

    private void allocationMeetingRoom() {

        int checker = getMeetings().size() - 1;
        for (int i = 0; i < meetings.size(); i++) {
            int count = 1;
            if (i == checker) {
                break;
            }

            Meeting beforeMeeting = getMeetings().get(i);

            for (int j = i + 1; j < meetings.size(); j++) {
                Meeting afterMeeting = getMeetings().get(j);
                if (beforeMeeting.getEndTime().compareTo(afterMeeting.getStartTime()) >= 0) {
                    continue;
                }

                checker = Math.min(checker, j);
                beforeMeeting = new Meeting(afterMeeting.getStartTime(), afterMeeting.getEndTime());
                count++;
            }

            counts.add(count);
        }
    }

    class Meeting {
        private final Long startTime;
        private final Long endTime;
        private final Long period;

        public Meeting(Long startTime, Long endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.period = endTime - startTime;
        }

        public Long getStartTime() {
            return startTime;
        }

        public Long getEndTime() {
            return endTime;
        }

        public Long getPeriod() {
            return period;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Meeting meeting)) return false;
            return Objects.equals(startTime, meeting.startTime) && Objects.equals(endTime, meeting.endTime);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startTime, endTime);
        }
    }
}
