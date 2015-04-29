package com.haitun.viewpager;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements OnPageChangeListener {

	private Button[] mTabs;
	private List<Fragment> list =new ArrayList<Fragment>();
	private ViewPager mpager;
	private int index;
	private int currentTabIndex;
	private Fragment first;
	private Fragment second;
	private Fragment three;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		init();
		initTab();
	}

	private void init() {

		mTabs = new Button[3];
		mTabs[0] = (Button) findViewById(R.id.btn_message);
		mTabs[1] = (Button) findViewById(R.id.btn_contract);
		mTabs[2] = (Button) findViewById(R.id.btn_set);
		mpager = (ViewPager) findViewById(R.id.viewpager);
		// 把第一个tab设为选中状态
		mTabs[0].setSelected(true);
	}
	private void initTab() {
		
		first=new Fragment_First();
		second=new Fragment_Second();
		three=new Fragment_Three();
		list.add(first);
		list.add(second);
		list.add(three);
		mpager.setAdapter(new myAdapter(getSupportFragmentManager()));
		mpager.setOnPageChangeListener(this);
		
	}
	/**
	 * button点击事件
	 * 
	 * @param view
	 */
	public void onTabSelect(View view) {
		switch (view.getId()) {
		case R.id.btn_message:
			index = 0;
			break;
		case R.id.btn_contract:
			index = 1;
			break;
		case R.id.btn_set:
			index = 2;
			break;
		}
		mpager.setCurrentItem(index, false);
		mTabs[currentTabIndex].setSelected(false);
		// 把当前tab设为选中状态
		mTabs[index].setSelected(true);
		currentTabIndex = index;
	}

	/**
	 * viewPager 的适配器
	 */
	class myAdapter extends FragmentPagerAdapter {

		public myAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			return list.get(arg0);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int index) {
		mTabs[currentTabIndex].setSelected(false);
		// 把当前tab设为选中状态
		mTabs[index].setSelected(true);
		currentTabIndex = index;
	}


}
