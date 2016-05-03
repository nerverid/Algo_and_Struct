import java.util.*;

public class SplitCutString 
{
	String s = null;
	
	String setSplitCut(String text)
	{
		StringTokenizer str = new StringTokenizer(text);
		while (str.hasMoreTokens())
		{
			s = str.nextToken(":");
			System.out.println(s + " vot hren.");
		}
		return s;
	}
}
