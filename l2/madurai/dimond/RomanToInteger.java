package dimond;

public class RomanToInteger {

	public static void main(String[] args) {
		String romanLetter[][] = {{"I","1"}, {"V","5"}, {"X","10"}, {"L","50"}, {"C","100"}, {"D","500"}, {"M","1000"}  };
		
		String s = "MLX";
		int sum =0,curPos=-1;
		
		for(int i=s.length()-1 ; i>=0 ; i--)
		{
			int j=0;
			while(j< romanLetter.length) {
				
				if(s.charAt(i) == romanLetter[j][0].charAt(0)) {
					sum = j>= curPos ? sum + Integer.parseInt(romanLetter[j][1]) : sum - Integer.parseInt(romanLetter[j][1]);
					curPos = j;
					break;
				}
				j++;
			}
		}
		System.out.println(sum);
		
	}

}
