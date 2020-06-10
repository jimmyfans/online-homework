package leetcode;

public class LC1644 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(translateNum(1));
	}

	public static int translateNum(int num) {
		String str=String.valueOf(num);
		if(str.length()==1) {
			return 1;
		}
		int[] dp=new int[str.length()];
		String temp=str.substring(0, 2);
		dp[0]=1;	//一位数只有一种情况
		dp[1]=(temp.compareTo("25")<=0&&temp.compareTo("10")>=0)?2:1;	//前两位数大于10且小与25有则有两种
		for(int i=2;i<str.length();i++) {
			temp=str.substring(i-1, i+1);
			if(temp.compareTo("25")<=0&&temp.compareTo("10")>=0) {
				dp[i]=dp[i-1]+dp[i-2];
			}
			else {
				dp[i]=dp[i-1];
			}
		}
		
		return dp[dp.length-1];
    }
}
