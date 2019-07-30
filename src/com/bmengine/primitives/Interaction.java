package com.bmengine.primitives;

public class Interaction {

    private String requiredItem;
    private String requiredState;
    private String[] verbs;

    public Interaction(String requiredItem, String requiredState, String[] verbs){
        this.requiredItem = requiredItem;
        this.requiredState = requiredState;
        this.verbs = new String[verbs.length];
        for(int i = 0; i < verbs.length; i++) {this.verbs[i] = verbs[i];}
    }

    public void printInfo(){
        System.out.println("__interaction_");
        System.out.println("___required item : " + requiredItem);
        System.out.println("___required state : " + requiredState);
        System.out.println("___verbs : ");
        for (int i=0;i<verbs.length;i++){System.out.println("____verb : " + verbs[i]);}
    }

}
