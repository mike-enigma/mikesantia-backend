package com.borrowing.utils;

import java.util.Random;

public class Utility {
    public static String generateIdLength10(){
        String abjad="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int targetLength=10;
        StringBuilder stringBuilder=new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < targetLength; i++) {
            stringBuilder.append(abjad.charAt(random.nextInt()));
        }
        return stringBuilder.toString();
    }
    public static String generateIdLength5(){
        String randomAbjad="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int targetLength=5;
        StringBuilder stringBuilder=new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < targetLength; i++) {
            stringBuilder.append(randomAbjad.charAt(random.nextInt()));
        }
        return stringBuilder.toString();
    }
    public static Integer generateCollectStatusId(){
        int length=11;
        int math = (int) Math.pow(10,length-1);
        return math + new Random().nextInt(9*math);
    }
}
