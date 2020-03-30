package com.example.bmicalculator.Data;

public class Questions {

    public String[] mQuestions = {
            "Can you have COVID-19 and show no symptoms?",
            "Can one get coronavirus for a second time?",
            "How long can the virus survive on surfaces?",
            "Is this just a new strain of cold or flu?",
            "Why is sheltering in place important right now?",
            "What makes COVID-19 worrisome for medical professionals?",
            "What has been the biggest misconception about this pandemic?",
    };

    private String[][] mChoices = {
            {"no", "yes", "hmm maybe", "I have no idea"},
            {"no", "yes", "hmm maybe", "I have no idea"},
            {"1 day", "1 week", "it depends", "1 month"},
            {"no", "yes", "hmm maybe", "I have no idea"},
            {"I have no idea", "to reduce coronavirus infections", "to have a fun in home",
                    "governments want to hide something"},
            {"everything", "I have no idea", "yes", "time of incubation"},
            {"everything", "that we can win with pandemic", "that you will not be infected",
                    "I have no idea"}
    };

    private String[] corecctAnswers = {
            "I have no idea",
            "no",
            "it depends",
            "no",
            "to reduce coronavirus infections",
            "everything",
            "that you will not be infected"
    };

    public String getQuestion(int a){
        return mQuestions[a];
    }

    public String getChoice1(int a){
        return mChoices[a][0];
    }

    public String getChoice2(int a){
        return mChoices[a][1];
    }
    public String getChoice3(int a){
        return mChoices[a][2];
    }
    public String getChoice4(int a){
        return mChoices[a][3];
    }

    public String getCorrectAnswer(int a){
        return corecctAnswers[a];
    }
}
