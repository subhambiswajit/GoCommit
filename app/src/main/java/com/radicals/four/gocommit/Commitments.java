package com.radicals.four.gocommit;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Commitments {
    private String _sender;
    public Commitments(String sender){
        _sender = sender;
    }

    public ArrayList<CommitmentData> Get(String text){
        ArrayList<CommitmentData> lst = new ArrayList<CommitmentData>();
        ArrayList<String> Sentences = getSentences(text);
        for (int i = 0; i < Sentences.size(); i++) {
            String sentence = Sentences.get(i);
            CommitmentData commit = fetchCommitment(sentence);
            if(commit != null)
            {
                lst.add(commit);
            }
        }
        return lst;
    }

    private CommitmentData fetchCommitment(String sentence)
    {
        String[] words = sentence.split(" ");

        CommitmentData commitment = null;

        boolean isTimeAvailable = false;
        String timeInfoText = "";
        Date timeInfo = null;
        boolean isConjuctionAvailable = false;
        boolean isActionAvailable = false;


        ArrayList<String> timeWords = timeWords();
        ArrayList<String> conjuctions = conjunctions();
        ArrayList<String> actions = actionWords();

        for(int i=0;i<words.length;i++){
            String word = words[i].toLowerCase();
            if(!isTimeAvailable && timeWords.contains(word)) {
                isTimeAvailable = true;
                timeInfoText = word;
                // Time fetching algorithm needs to be written
                // Adding default date and time
                timeInfo = new Date();
                Calendar c = Calendar.getInstance();
                c.add(Calendar.DATE, 1);
                timeInfo = c.getTime();
                if(word == "am" || word == "pm"){

                }
            }
            if(conjuctions.contains(word))
            {
                isConjuctionAvailable = true;
            }
            if(actions.contains(word))
            {
                isActionAvailable = true;
            }
        }
        if(isConjuctionAvailable && isActionAvailable)
        {
            commitment = new CommitmentData(sentence, timeInfoText);
            if(isTimeAvailable)
            {
                TimeInfo info = new TimeInfo(true);
                info.Time = timeInfo;
                info.TimeText = timeInfoText;
                commitment.TimeInfo = info;
            }
        }
        return commitment;
    }

    private  ArrayList<String> timeWords()
    {
        ArrayList<String> lst = new ArrayList<String>();
        lst.add("am");
        lst.add("pm");
        lst.add("week");
        lst.add("weeks");
        lst.add("day");
        lst.add("today");
        lst.add("tomorrow");
        lst.add("tonight");
        lst.add("eod");
        lst.add("evening");
        lst.add("eob");
        lst.add("eta");
        lst.add("noon");
        lst.add("afternoon");
        lst.add("now");
        lst.add("monday");
        lst.add("tuesday");
        lst.add("wednesday");
        lst.add("thursday");
        lst.add("friday");
        lst.add("saturday");
        lst.add("sunday");
        lst.add("weekend");
        lst.add("month");
        lst.add("months");
        lst.add("quarter");
        lst.add("quarters");
        return lst;
    }

    private  ArrayList<String> conjunctions(){
        ArrayList<String> lst = new ArrayList<String>();
        lst.add("will");
        lst.add("do");
        lst.add("at");
        lst.add("have");
        lst.add("must");
        lst.add("could");
        lst.add("would");
        lst.add("should");
        lst.add("can");
        lst.add("may");
        lst.add("might");
        lst.add("next");
        lst.add("coming");
        lst.add("until");
        return lst;
    }

    private ArrayList<String> actionWords(){
        ArrayList<String> lst = new ArrayList<String>();
        lst.add("buy");
        lst.add("grab");
        lst.add("get");
        lst.add("pick");
        lst.add("leave");
        lst.add("come");
        lst.add("go");
        lst.add("have");
        lst.add("clean");
        lst.add("pay");
        lst.add("charge");
        lst.add("set");
        lst.add("scheduled");
        lst.add("right");
        lst.add("mail");
        lst.add("submit");
        lst.add("revert");
        lst.add("remember");
        lst.add("due");
        lst.add("plan");
        lst.add("drive");
        lst.add("pickup");
        lst.add("call");
        lst.add("send");
        return lst;
    }

    private ArrayList<String> getSentences(String text)
    {
        ArrayList<String> lst = new ArrayList<String>();
        String str = text;

        Pattern re = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)", Pattern.MULTILINE | Pattern.COMMENTS);
        Matcher reMatcher = re.matcher(str);
        while (reMatcher.find()) {
           lst.add(reMatcher.group());
        }
        return lst;
    }

    public class TimeInfo{
        public boolean IsAvailable;
        public String TimeText;
        public Date Time;
        public TimeInfo(boolean isAvailable)
        {
            IsAvailable = isAvailable;
        }
    }

}
