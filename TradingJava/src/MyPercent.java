/**
 * 
 * @author nerve
 *����� ��������� ��������� � ���� ����� � ��������� ������,
 *��������� : ������� �������, ���������� ����
 */
class MyPercent
{
	float x, y, z;
	String sz="";
	
	float setMyPercent (float a, float b)
	{
		x = a;
		y = b;
		return z = x *y/100;
	}
	
	String setMyPercent (float a, float b, int c)
	{
		z=a;
		for (int i=0; i<c; i++)
		{
			x = z*b/100;
			z += x;
			sz += "" + (i+1) + " ����: " + z + ", ������� �� ������� ����: " + x + ";"+ "\n";
		}
		return sz;
	}
}