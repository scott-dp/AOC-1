package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Solution.readInputAndSaveToList("src/main/resources/input.txt");
    System.out.println(Solution.sortAndSumDifferences());
    System.out.println(Solution.findFirstListNumbersAppearancesInSecondList());
  }
}

class Solution{
  private static List<Integer> leftVals = new ArrayList<>();
  private static List<Integer> rightVals = new ArrayList<>();
  public static void readInputAndSaveToList(String path) {
    try(BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] vals = line.split("\s\s\s");
        leftVals.add(Integer.parseInt(vals[0]));
        rightVals.add(Integer.parseInt(vals[1]));
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public static int sortAndSumDifferences() {
    Collections.sort(leftVals);
    Collections.sort(rightVals);
    int sum = 0;
    for(int i = 0; i < leftVals.size(); i++) {
      sum+= Math.abs(leftVals.get(i)-rightVals.get(i));
    }
    return sum;
  }

  public static int findFirstListNumbersAppearancesInSecondList() {
    HashMap<Integer, Integer> numAppearances = new HashMap<>();
    for (int i:leftVals) numAppearances.put(i, 0);
    for (int i:rightVals) {
      if (numAppearances.containsKey(i)) numAppearances.put(i, numAppearances.get(i)+1);
    }
    int sum = 0;
    for(Map.Entry<Integer, Integer> entry : numAppearances.entrySet()) {
      sum += entry.getKey()*entry.getValue();
    }
    return sum;
  }
}