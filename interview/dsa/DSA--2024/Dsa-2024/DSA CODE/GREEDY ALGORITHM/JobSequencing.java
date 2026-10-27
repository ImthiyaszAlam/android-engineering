import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class JobSequencing {

    public static class Job {
        int jobId;
        int deadLine;
        int profit;

        Job(int i, int d, int p) {
            this.jobId = i;
            this.deadLine = d;
            this.profit = p;
        }

    }

    public static void main(String[] args) {
        int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (obj1, ob2) -> ob2.profit - obj1.profit);

        ArrayList<Integer>seq = new ArrayList<>();
        int time = 0;
        for(int i=0;i<jobs.size();i++){
            Job currentJob = jobs.get(i);
            if (currentJob.deadLine>time) {
                seq.add(currentJob.jobId);
                time++;
            }
        }

        System.out.println("total job: "+seq.size());
        System.out.println(seq);
    }
}
