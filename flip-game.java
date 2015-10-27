You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        
        char[] cstr = s.toCharArray();
        
        for(int i=0;i<cstr.length-1; i++){
            if(cstr[i]==cstr[i+1] && cstr[i]=='+'){
                cstr[i]=cstr[i+1]='-';
                result.add(new String(cstr));
                cstr[i]=cstr[i+1]='+';
            }
        }
        return result;
    }
}
