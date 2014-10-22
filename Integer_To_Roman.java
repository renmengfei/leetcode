    public String intToRoman(int num) {
        int[] list = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<list.length;i++){
            while(num>=list[i]){  // pay attention to >=, equal is important
                num-=list[i];
                sb.append(getRoman(list[i]));
            }
        }
        return sb.toString();
        
        
    }
    
    public String getRoman(int digit){
        switch(digit){
            case 1: return "I";
            case 4: return "IV";
            case 5: return "V";
            case 9: return "IX";
            case 10: return "X";
            case 40: return "XL";
            case 50: return "L";
            case 90: return "XC";
            case 100: return "C";
            case 400: return "CD";
            case 500: return "D";
            case 900: return "CM";
            case 1000: return "M";
        }
        return "";
    }
