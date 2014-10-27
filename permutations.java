public class Solution {
   public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> one = new ArrayList<Integer>();
        one.add(num[0]);
        list.add(one);

        for(int i=1;i<num.length;i++){
           list = insert(list, num[i]);
        }
        return list;
    }

    public ArrayList<ArrayList<Integer>> insert(ArrayList<ArrayList<Integer>>list, int num){
        ArrayList<ArrayList<Integer>> newlist = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<list.size();i++){
            for(int j=0;j<=list.get(i).size();j++){
                ArrayList<Integer> tmp = new ArrayList<Integer>(list.get(i));
                tmp.add(j,num);
                newlist.add(tmp);
            }
        }

        return newlist;
    }
}
