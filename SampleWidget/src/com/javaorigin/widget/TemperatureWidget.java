package com.javaorigin.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.RemoteViews;

public class TemperatureWidget extends AppWidgetProvider {
	double temp=0;
	@Override
	
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		context.getApplicationContext().registerReceiver(this,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
		updateUI(context) ;
	}

	@Override
	public void onReceive(Context context, Intent intent) {		
		temp=intent.getIntExtra("temperature", 0)/10.0D;
		updateUI(context) ;
		//Git
		super.onReceive(context, intent);
		//Hai second push
	}

	private void updateUI(Context context) {
		RemoteViews thisViews = new RemoteViews(context.getApplicationContext()	.getPackageName(), R.layout.widget_layout);
		thisViews.setTextViewText(R.id.update, temp + "");
		//Git
		ComponentName thisWidget = new ComponentName(context,TemperatureWidget.class);
		AppWidgetManager.getInstance(context).updateAppWidget(thisWidget,thisViews);
	}
}
