// (1) path remove 有一点tricky
// (2) “000” invalid，需要排除    
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        helper(result, "", s, 0);
        return result;
    }
    
    public void helper(List<String> result, String path, String s, int level){
        if(level==4){
            if(s.isEmpty()){
                result.add(new String(path.substring(0,path.length()-1)));
            }
            return;
        }
        for(int i = 1; i<=s.length() && i<=3;i++){
            String digit = s.substring(0,i);
            if(valid(digit)){
                path+=digit+".";
                helper(result, path, s.substring(i,s.length()), level+1);
                path=path.substring(0, path.length()-digit.length()-1);
            }
            
        }
    }
    
    public boolean valid(String s){
        if(s.startsWith("0") && s.length()>1) return false;//000
        int tmp = Integer.parseInt(s);
        return tmp>=0 && tmp<=255;
    }
