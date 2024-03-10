//v1
import java.util.*;

//v2
//implement logarithmic point regression

//v3
//soft hands


public class newbjai{
  static Random rand = new Random();

  public static void main(String[] args){
    Bot ai = new Bot(100000000);
    train(ai);
    ai.printChoices();
  }

  static void train(Bot ai){
    while (ai.totalRuns < ai.trainingRuns){
      int playersum = rand.nextInt(18) + 4;
      if (playersum == 22)
        playersum = 12;

      int dealerUp = rand.nextInt(9) + 2;
      int dealerDown = rand.nextInt(9) + 2;

      while (true){
        int[] choices = ai.decisionTree.get(dealerUp).get(playersum);
        int decision = rand.nextInt(choices[0]+choices[1]);
        if (decision > choices[0]){

          int dealerSum = dealerLogic(dealerUp,dealerDown);
          if (dealerSum > 21 || dealerSum < playersum){
            ai.decisionTree.get(dealerUp).get(playersum)[0]--;
            ai.decisionTree.get(dealerUp).get(playersum)[1]++;
          }
          else if (playersum < dealerSum){
            ai.decisionTree.get(dealerUp).get(playersum)[1]--;
            ai.decisionTree.get(dealerUp).get(playersum)[0]++;
          }
          break;
        }
        int newcard = rand.nextInt(9) + 2;
        playersum += newcard;
        if (playersum > 21){
          ai.decisionTree.get(dealerUp).get(playersum-newcard)[0]--;
          ai.decisionTree.get(dealerUp).get(playersum-newcard)[1]++;
          break;
        }
        else{
          ai.decisionTree.get(dealerUp).get(playersum-newcard)[1]--;
          ai.decisionTree.get(dealerUp).get(playersum-newcard)[0]++;
        }
      }
      ai.totalRuns++;
      if (ai.totalRuns%10000000 == 0)
        System.out.println(ai.totalRuns);
    }
  }

  static int dealerLogic(int dealerUp, int dealerDown){
    //stands on soft 17

    int aceCount = 0;
    int sum = dealerUp + dealerDown;
    if (dealerUp == 11)
      aceCount++;
    if (dealerDown == 11)
      aceCount++;

    if (sum == 22){
      sum-=10;
      aceCount--;
    }

    while (sum < 17){
      int newCard = new Random().nextInt(9) + 2; //generate a new card value
      sum += newCard;

      if (newCard == 11) //if new card is an Ace
        aceCount++;

      while (sum > 21 && aceCount > 0){ //if sum exceeds 21 and there's an Ace, count Ace as 1 instead of 11
        sum -= 10;
        aceCount--;
      }
    }

    return sum;
  }


}
