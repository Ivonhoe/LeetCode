class Solution {
    public int strToInt(String str) {
        int len = str.length();
        // str.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
        char[] charArray = str.toCharArray();
        int index =0;
        
        while(index<len&&charArray[index]==' '){
            index++;
        }
        if(index>len-1){
            return 0;
        }
        int sign = 1;
        if(charArray[index]=='+'){
            index++;
        }else if(charArray[index]=='-'){
            index++;
            sign = -1;
        }
        int ans = 0;
        while(index<len){
            if(charArray[index]<'0'||charArray[index]>'9'){
                break;
            }

            int pre = ans;
            ans = ans*10+sign*(charArray[index]-'0');
            // 判断溢出
            if(ans/10!=pre){
                ans = sign>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
                break;
            }
            index++;
        }

        return ans;
    }
}