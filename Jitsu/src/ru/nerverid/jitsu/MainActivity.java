package ru.nerverid.jitsu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;

public class MainActivity extends Activity {

	  @Override
	    protected void onCreate(Bundle savedInstanceState) 
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        
	        Thread logoTimer = new Thread()
	        {
	        	public void run()
	        	{
	        		try
	        		{
	        			int logoTimer = 0;
	        			while(logoTimer < 5000)
	        			{
	        				sleep(100);
	        				logoTimer = logoTimer + 100;
	        			}
	        			startActivity(new Intent("android.intent.action.MYMAINSCREEN"));
	        		}
	        		catch (InterruptedException e)
	        		{
	        			e.printStackTrace();
	        		}
	        		finally
	        		{
	        			finish();
	        		}
	        	}
	        };
	        logoTimer.start();
	    }


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }

    
}
