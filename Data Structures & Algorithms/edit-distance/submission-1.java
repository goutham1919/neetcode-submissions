class Solution {
    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length()+1];
        
        for(int i=0;i<word2.length()+1;i++){
            dp[i]=word2.length()-i;
        }

        for(int i=word1.length()-1;i>=0;i--){
            int[] newdp=new int[word2.length()+1];
            newdp[word2.length()]=word1.length()-i;
            for(int j=word2.length()-1;j>=0;j--){
                if(word1.charAt(i)==word2.charAt(j)){
                    newdp[j]=dp[j+1];
                }else{
                    newdp[j]=1+Math.min(newdp[j+1],Math.min(dp[j],dp[j+1]));
                }
            }
            dp=newdp;
        }

        return dp[0];
    }
}