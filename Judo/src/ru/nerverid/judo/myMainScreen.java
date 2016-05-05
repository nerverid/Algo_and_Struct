package ru.nerverid.judo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class myMainScreen extends Activity
{
	protected void onCreate (Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	 
    public void onClick (View view)
    {
    	Intent intent = new Intent (myMainScreen.this, Technics.class);
    	startActivity(intent);
    }
}
