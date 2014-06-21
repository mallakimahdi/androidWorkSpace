package com.example.listviewsorte;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;
import android.app.ListFragment;
import android.os.Bundle;

public class myFragment extends ListFragment 
{
	@Override
	public void onActivityCreated(Bundle savedInstanceState) 
	{
		super.onActivityCreated(savedInstanceState);
		
		Random random = new Random();
		ArrayList<struct> arrays = new ArrayList<struct>();
		for(int i=0 ; i<10000 ; i++)
        {
        	struct stru = new struct();
        	
        	stru.setId(i);
        	stru.setVisitLat((int) (random.nextDouble()*1000));
        	stru.setVisitLong((int) (random.nextDouble()*1000));
        	stru.setSend(random.nextBoolean() ? 1 : 0);
        	stru.setMasfa(random.nextBoolean());
        	
        	GregorianCalendar gc = new GregorianCalendar();
        	
        	gc.set(gc.YEAR, randBetween(2003, 2014));
        	gc.set(gc.DAY_OF_YEAR, randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR)));
            
        	stru.setGc(gc);
        	
        	arrays.add(stru);
        }
		
		Adapter adapter = new Adapter(getActivity().getBaseContext(), arrays);
		setListAdapter(adapter);
	}
	
	private int randBetween(int start, int end) 
	{
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
