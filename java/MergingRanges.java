import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Meeting implements Comparable<Meeting> {
    int startTime;
    int endTime;

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public Meeting(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "{" +
                startTime +
                "," + endTime +
                '}';
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.getStartTime() >= o.getStartTime()) {
            return 1;
        } else {
            return -1;
        }
    }
}


public class MergingRanges {
    public static List<Meeting> mergeRanges(List<Meeting> meetings) throws Exception {

        // merge meetings ranges
        if (meetings.isEmpty()) {
            return null;
        } else if (meetings.size() == 1) {
            if (meetings.get(0).getEndTime() >= meetings.get(0).getStartTime()) {
                return meetings;
            } else {
                throw new Exception("end time can't be greater than start time");
            }

        } else {
            meetings.sort(new Comparator<Meeting>() {
                public int compare(Meeting o1, Meeting o2) {
                    return o1.getStartTime() - o2.getStartTime();
                }
            });
            Meeting currentMeeting = meetings.get(0);
            List<Meeting> mergedMeetings = new ArrayList<Meeting>();
            for (int i = 0; i < meetings.size(); i++) {
                if (meetings.get(i).getEndTime() < meetings.get(i).getStartTime()) {
                    throw new Exception("end time can't be greater than start time");
                }
                if (meetings.get(i).getStartTime() <= currentMeeting.getEndTime()) {
                    currentMeeting.setEndTime(Math.max(meetings.get(i).getEndTime(), currentMeeting.getEndTime()));
                } else {
                    mergedMeetings.add(new Meeting(currentMeeting.getStartTime(), currentMeeting.getEndTime()));
                    currentMeeting.setEndTime(meetings.get(i).getEndTime());
                    currentMeeting.setStartTime(meetings.get(i).getStartTime());
                }
            }
            mergedMeetings.add(currentMeeting);
            return mergedMeetings;
        }
    }


    public static void main(String[] args) throws Exception {
        List<Meeting> k = new ArrayList<>();
        k.add(new Meeting(1, 3));
        k.add(new Meeting(2, 4));
//        k.add(new Meeting(5, 9));

        System.out.println(mergeRanges(k).toString());
    }
}
