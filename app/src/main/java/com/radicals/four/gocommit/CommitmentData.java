package com.radicals.four.gocommit;

import java.util.ArrayList;
import java.util.List;

public class CommitmentData {
    public String TaskName;
    public String Time;
    public Commitments.TimeInfo TimeInfo;
    public CommitmentData(String taskname, String time) {
        this.TaskName = taskname;
        this.Time = time;
    }
    public static ArrayList<CommitmentData> GetSampleData() {
        ArrayList<CommitmentData> returnList = new ArrayList<CommitmentData>();
        returnList.add(new CommitmentData("I will send the email by today", "today"));
        returnList.add(new CommitmentData("Submit IDF ", "August 7th"));
        returnList.add(new CommitmentData("Plan for pot lunch", "Friday"));
        return returnList;

    }
}
