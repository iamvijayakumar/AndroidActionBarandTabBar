package com.example.customthemeactionbartab;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity implements TabListener {

	ViewPager viewPager;

	TapFragmentManager fragmentManger;
	android.app.ActionBar actionBar;

	String[] tabsName = { "News", "Top News" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getActionBar();
		fragmentManger = new TapFragmentManager(getSupportFragmentManager());
		viewPager.setAdapter(fragmentManger);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		for (String str : tabsName) {
			actionBar.addTab(actionBar.newTab().setText(str)
					.setTabListener(this));
		}

		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int tabPosition) {
				actionBar.setSelectedNavigationItem(tabPosition);

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

		viewPager.setCurrentItem(tab.getPosition());

	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	public class TapFragmentManager extends FragmentPagerAdapter {

		public TapFragmentManager(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int tab_position) {
			// TODO Auto-generated method stub

			if (tab_position == 0) {

				return new NewsFragment();
			} else {
				return new TopNewsFragment();
			}

		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return tabsName.length;
		}

	}
}
