// map存boolean就可以，表示是否重复
// entrySet不会tle, keyset会tle，太奇怪了。。。
public class TwoSum {
   HashMap<Integer, Boolean> map = new HashMap<>();

    public void add(int number) {
        if(map.containsKey(number)) map.put(number, true);
        else map.put(number, false);
    }

    public boolean find(int value) {
        for(Map.Entry<Integer, Boolean> entry : map.entrySet()){
            int i = entry.getKey();
            if(2*i == value){
                if(map.get(i)) return true;
            } else if(map.containsKey(value-i)) return true;
        }
        return false;
    }
}

