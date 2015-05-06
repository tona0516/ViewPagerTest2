package com.example.viewpagertest2;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class MainActivity extends FragmentActivity {
	ViewPager viewPager;
	MyFragmentStatePagerAdapter adapter;
	private int previousFragment = 0;
	private int currentFragment = 0; // 現在表示しているフラグメントを格納する
	private ArrayList<Fragment> fragmentList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setOffscreenPageLimit(10); // ここでメモリに貯めるフラグメント数を決める
		fragmentList = new ArrayList<Fragment>();
		fragmentList.add(new Fragment0());
		adapter = new MyFragmentStatePagerAdapter(getSupportFragmentManager(), fragmentList);
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				super.onPageSelected(position);
				previousFragment = currentFragment;
				currentFragment = position;
				Log.d("currentFragment", "" + currentFragment);
			}
		});

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.remove) {
			if (fragmentList.size() != 1) {
				// これだとラグがある
				// int current = viewPager.getCurrentItem();
				// fragmentList.remove(current);
				// adapter = new
				// MyFragmentStatePagerAdapter(getSupportFragmentManager(),
				// fragmentList);
				// viewPager.setAdapter(adapter);
				// viewPager.setCurrentItem(current, false);
				adapter.removeFragment(previousFragment);
				viewPager.setCurrentItem(previousFragment);

			} else {
				finish();
			}
		} else if (id == R.id.make) {
			adapter.addFragment();
		}
		return super.onOptionsItemSelected(item);
	}
}
