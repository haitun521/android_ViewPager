package com.haitun.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_First extends Fragment implements OnClickListener{
	
	private Button btn;
	private TextView tv;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root=inflater.inflate(R.layout.fragment1, container, false);
		btn=(Button) root.findViewById(R.id.frag_btn);
		btn.setOnClickListener(this);
		tv=(TextView) root.findViewById(R.id.text_view);
		return root;
	}
	/**
	 * Âß¼­µÄ´¦Àí
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		
		super.onActivityCreated(savedInstanceState);
		tv.setText("123");
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "123", Toast.LENGTH_SHORT).show();
	}

}
