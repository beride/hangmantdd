

public class ShowTennisGame {
    public static String showResult(int playerA,int playerB){
        String wordList[] = {"Love", "Fifteen", "Thirty", "Forty", "All", "Deuce"};

        String result = "";

        int temp = playerA - playerB;
        if (temp == 0){
            if (playerA < 3){
                result = wordList[playerA] + " " + wordList[4];
            }else {
                result = wordList[5];
            }
        }

        if (temp > 0 && playerA < 4 && playerB == 0) {
            result = wordList[temp] + " " + wordList[0];
        } else if (playerA >= 4 && temp >= 2) {
            return "A Win";
        } else if (playerA >= 4 && temp == 1) {
            return "A Advance";
        }else if(playerA < 4 && playerB < 4 && temp > 0){
            result = wordList[playerA] + " " + wordList[playerB];
        }

        return result;
    }
}
