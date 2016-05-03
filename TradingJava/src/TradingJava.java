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
	// переменная вывода результата
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
		
		
		JButton recButton = new JButton ("Записать");
		recButton.addActionListener(new RecButListener());
		
		JButton calcButton = new JButton ("Расчитать");
		calcButton.addActionListener(new CalcButListener());
		
		JButton tipsButton = new JButton ("Совет на сегодня");
		tipsButton.addActionListener(new TipsDayListener());
			
		// переменные: начального капитала, капитал в конце периода, 
		// процент сегодня сколько нужно заработать, капитал в конце дня,
		// 
		frame.getContentPane().add(BorderLayout.CENTER, textarea);
		Box buttonsBox = new Box (BoxLayout.LINE_AXIS);
		buttonsBox.add(calcButton);
		buttonsBox.add(recButton);
		buttonsBox.add(tipsButton);
		frame.getContentPane().add(BorderLayout.SOUTH, buttonsBox);
		
		
	//  Как можно использовать внешний класс для построения строки
	//	StrBldPers StBP = new StrBldPers ();
	//	textarea.append(StBP.StrRet(JOptionPane.showInputDialog("Insert")));
		frame.setSize(350, 350);
		//Изменение размеров окна
		frame.setResizable(false);
		frame.setVisible(true);
	}

	
	class CalcButListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			dStartCapital = Float.parseFloat(JOptionPane.showInputDialog("Вводим начальный капитал:"));
			MyPercent MP = new MyPercent (); // создаем экземпляр класса, данный класс расчитывает сложные проценты
			
					
			/* Капитал на конец дня,
			 * будет составлять капитал на начало дня + капитал который
			 * необходимо заработать в данном случае 10%
			 */ 
		
			text2 =  "Начальный капитал: " + dStartCapital + ";"+ "\n"; 
			text2 += MP.setMyPercent(dStartCapital, 10, 10);
			textarea.setText(""); // Этой строкой очищаем текстовое поле
			textarea.append(text2); // Выводим результат в текстовое поле.
		}
	}


	//обработчик события для кнопки записи в файл
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
			JOptionPane.showMessageDialog(null, "Текст записан");
		}
	}
	
	class TipsDayListener  implements ActionListener
	{
		public  void actionPerformed (ActionEvent event)
		{
			/**
			 * Сначала нужно прочитать файл, затем спросить у пользователя какой день
			 * далее спросить какую сумму он заработал,
			 * вывести совет на сегодня.
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
			
			String textToDay=null; // переменная для генерации искомой строки 
			boolean isFinDay=false;
			isFinDay = text2.contains("итог");
			if (isFinDay== false) JOptionPane.showMessageDialog(null, "Торгуйте по системе!");
			
			int dayToDay = JOptionPane.YES_NO_OPTION;
			JOptionPane.showConfirmDialog(null, "Уже торговали сегодня?", "Совет", dayToDay);
			if (dayToDay == JOptionPane.YES_OPTION)
			{
				textToDay = "1 день итог: ";
				textToDay += JOptionPane.showInputDialog(null, "Вводим сколько заработал сегодня");
			}	
		}
	}
}
