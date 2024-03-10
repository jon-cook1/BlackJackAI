import java.util.*;

public class Bot{
  int trainingRuns;
  int totalRuns = 0;

  HashMap<Integer,HashMap<Integer,int[]>> decisionTree = new HashMap<Integer,HashMap<Integer,int[]>>();

  Bot(int trainingRuns){
    this.trainingRuns = trainingRuns;
    buildMap();
  }

  void buildMap(){
    for (int i=2; i<12; i++){
      HashMap<Integer,int[]> tempMap = new HashMap<Integer,int[]>();

      for (int k=4; k<22; k++){
        int[] tempArr = {800000,800000};
        tempMap.put(k,tempArr);
      }

      decisionTree.put(i,tempMap);
    }


  }
  void printChoices(){
    System.out.println("AI Decision Tree:");
    for (Map.Entry<Integer, HashMap<Integer, int[]>> dealerEntry : decisionTree.entrySet()) {
        int dealerCard = dealerEntry.getKey();
        HashMap<Integer, int[]> playerSums = dealerEntry.getValue();
        for (Map.Entry<Integer, int[]> playerEntry : playerSums.entrySet()) {
            int playerSum = playerEntry.getKey();
            int[] decisions = playerEntry.getValue();
            String action = (decisions[0] > decisions[1]) ? "Hit" : "Stay";
            System.out.printf("Dealer Card: %d, Player Sum: %d, Decision: %s\n", dealerCard, playerSum, action);
        }
    }
}
}
