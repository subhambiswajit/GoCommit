//package com.radicals.four.gocommit;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class Commitments {
//    private String _source;
//    public Commitments(String source){
//        _source = source;
//    }
//
//    public ArrayList<String> Get(String text){
//        ArrayList<String> lst = new ArrayList<String>();
//        ArrayList<String> Sentences = getSentences(text);
//        for (int i = 0; i < Sentences.size(); i++) {
//            String sentence = Sentences.get(i);
//
//        }
//    }
//
//    private ArrayList<String> getSentences(String text)
//    {
//        ArrayList<String> lst = new ArrayList<String>();
//        String str = text;
//
//        Pattern re = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)", Pattern.MULTILINE | Pattern.COMMENTS);
//        Matcher reMatcher = re.matcher(str);
//        while (reMatcher.find()) {
//           lst.add(reMatcher.group());
//        }
//        return lst;
//    }
//
//    private ArrayList<String> getCommitment(String sentence){
//
//    }
//
//}
