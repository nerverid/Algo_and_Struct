import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.io.*;



class StrBldPers 
{
	String txt;
	StrBldPers ()
	{
		txt=null;
	}
	
	String StrRet (String txxt)
	{
		txt=txxt;
		return txt;
	}
}

public class TradingJava
{
	// ���������� ������ ����������
	String text2 = "";
	float dStartCapital, dEndCapital;
	JTextArea textarea = new JTextArea();
	
	public static void main(String[] args)
	{
		TradingJava trad = new TradingJava();
		trad.go();
	}
	
	public void go ()
	{
		JFrame frame = new JFrame ();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JButton recButton = new JButton ("��������");
		recButton.addActionListener(new RecButListener());
		
		JButton calcButton = new JButton ("���������");
		calcButton.addActionListener(new CalcButListener());
		
		JButton tipsButton = new JButton ("����� �� �������");
		tipsButton.addActionListener(new TipsDayListener());
			
		// ����������: ���������� ��������, ������� � ����� �������, 
		// ������� ������� ������� ����� ����������, ������� � ����� ���,
		// 
		frame.getContentPane().add(BorderLayout.CENTER, textarea);
		Box buttonsBox = new Box (BoxLayout.LINE_AXIS);
		buttonsBox.add(calcButton);
		buttonsBox.add(recButton);
		buttonsBox.add(tipsButton);
		frame.getContentPane().add(BorderLayout.SOUTH, buttonsBox);
		
		
	//  ��� ����� ������������ ������� ����� ��� ���������� ������
	//	StrBldPers StBP = new StrBldPers ();
	//	textarea.append(StBP.StrRet(JOptionPane.showInputDialog("Insert")));
		frame.setSize(350, 350);
		//��������� �������� ����
		frame.setResizable(false);
		frame.setVisible(true);
	}

	
	class CalcButListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			dStartCapital = Float.parseFloat(JOptionPane.showInputDialog("������ ��������� �������:"));
			MyPercent MP = new MyPercent (); // ������� ��������� ������, ������ ����� ����������� ������� ��������
			
					
			/* ������� �� ����� ���,
			 * ����� ���������� ������� �� ������ ��� + ������� �������
			 * ���������� ���������� � ������ ������ 10%
			 */ 
		
			text2 =  "��������� �������: " + dStartCapital + ";"+ "\n"; 
			text2 += MP.setMyPercent(dStartCapital, 10, 10);
			textarea.setText(""); // ���� ������� ������� ��������� ����
			textarea.append(text2); // ������� ��������� � ��������� ����.
		}
	}


	//���������� ������� ��� ������ ������ � ����
	class RecButListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			try 
			{
				FileWriter writer = new FileWriter ("Money.txt");
				writer.write(text2);
				writer.close();				
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "����� �������");
		}
	}
	
	class TipsDayListener  implements ActionListener
	{
		public  void actionPerformed (ActionEvent event)
		{
			/**
			 * ������� ����� ��������� ����, ����� �������� � ������������ ����� ����
			 * ����� �������� ����� ����� �� ���������,
			 * ������� ����� �� �������.
			 */
			try
			{
				File myFile = new File("Money.txt");
				FileReader fileReader = new FileReader (myFile);
				
				BufferedReader reader = new BufferedReader (fileReader);
				String line = null;
								
				while ((line = reader.readLine()) != null)
				{
					text2 = line;
					textarea.append(text2);
				}
				reader.close();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			
			SplitCutString scStr = new SplitCutString();
			scStr.setSplitCut(text2);
			
			String textToDay=null; // ���������� ��� ��������� ������� ������ 
			boolean isFinDay=false;
			isFinDay = text2.contains("����");
			if (isFinDay== false) JOptionPane.showMessageDialog(null, "�������� �� �������!");
			
			int dayToDay = JOptionPane.YES_NO_OPTION;
			JOptionPane.showConfirmDialog(null, "��� ��������� �������?", "�����", dayToDay);
			if (dayToDay == JOptionPane.YES_OPTION)
			{
				textToDay = "1 ���� ����: ";
				textToDay += JOptionPane.showInputDialog(null, "������ ������� ��������� �������");
			}	
		}
	}
}
