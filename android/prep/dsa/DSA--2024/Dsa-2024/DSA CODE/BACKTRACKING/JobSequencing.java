import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {

    public class Job {
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p) {
            this.deadline = d;
            this.profit = p;
            this.id = i;
        }

    }

    public static void main(String[] args) {
        int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }
        Collections.sort(jobs,(obj1,obj2)->obj2.profit-obj1.profit);
    }
}