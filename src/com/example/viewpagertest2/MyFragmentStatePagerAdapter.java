package com.example.viewpagertest2;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
	private FragmentManager fm;
	private ArrayList<Fragment> fList;

	public MyFragmentStatePagerAdapter(FragmentManager fm,
			ArrayList<Fragment> fList) {
		super(fm);
		this.fm = fm;
		this.fList = fList;
	}
	@Override
	public Fragment getItem(int i) {
		return fList.get(i);
	}

	@Override
	public int getCount() {
		return fList.size();
	}
	@Override
	public CharSequence getPageTitle(int position) {
		return "Page " + position;
	}

	public void addFragment() {
		fList.add(new Fragment0());
		notifyDataSetChanged();
	}

	public void removeFragment(int index) {
		fList.remove(index);
		notifyDataSetChanged();
	}

	public FragmentManager getFm() {
		return fm;
	}

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}
}