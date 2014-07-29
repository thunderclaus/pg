package com.pku.pg;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;

public class info extends Activity {
	
	private	ListViewForScrollView mListviewVisors;
//	private ListView mListviewVisors;
//	private ListView mListviewRelateds;
	private ListViewForScrollView mListviewRelateds;
private ScrollView infoScrollView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);
//		View headerView = getLayoutInflater().inflate( 
//		        R.layout.info, null); 
		
		infoScrollView = (ScrollView) findViewById(R.id.info_scrollview);
		infoScrollView.smoothScrollTo(0, 0);
		 
		/* 护工 ************************************************************/ 
		mListviewVisors = (ListViewForScrollView)findViewById(R.id.info_list_Visors);	/*定义一个动态数组*/      
		ArrayList<HashMap<String, Object>> mListItemVisors = new ArrayList<HashMap<String, Object>>();	/*在数组中存放数据*/
		 for(int i=0;i<10;i++)  
	        {  
	            HashMap<String, Object> map_visors = new HashMap<String, Object>();  
	            map_visors.put("ItemImage", R.drawable.choose);//加入图片 
	            map_visors.put("ItemTitle", "姓名"+i);  
	            map_visors.put("ItemText", "手机号"+i);  
	            mListItemVisors.add(map_visors);  
	        } 
		 SimpleAdapter mSimpleAdapter_Visors = new SimpleAdapter(this, mListItemVisors ,R.layout.list_visors, 
				 new String[] {"ItemImage","ItemTitle", "ItemText"}, new int[] {R.id.list_imgbtn_Visor, R.id.list_title_Visor, R.id.list_info_Visor}  
		             );		//数据绑定
		 
		// mListviewVisors.addHeaderView(headerView); 
		 mListviewVisors.setAdapter(mSimpleAdapter_Visors);
		 //setListViewHeightBasedOnChildren(mListviewVisors);
		 //setListViewHeight(mListviewVisors);
		 mListviewVisors.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				setTitle("你选择了护理人员"+arg2);//设置标题栏显示点击的行  
			}
		});
		 
		
		 /* 亲属  *************************************************************/ 
		 mListviewRelateds = (ListViewForScrollView) findViewById(R.id.info_list_Related);	/*定义一个动态数组*/      
			ArrayList<HashMap<String, Object>> mListItemRelated = new ArrayList<HashMap<String, Object>>();	/*在数组中存放数据*/
			 for(int i=0;i<3;i++)  
		        {  
		            HashMap<String, Object> map_relateds = new HashMap<String, Object>();  
		            map_relateds.put("ItemImage", R.drawable.choose);//加入图片 
		            map_relateds.put("ItemTitle", "姓名"+i);  
		            map_relateds.put("ItemText", "手机号"+i);  
		            mListItemRelated.add(map_relateds);  
		        } 
			 SimpleAdapter mSimpleAdapter_Relateds = new SimpleAdapter(this, mListItemRelated ,R.layout.list_relateds , 
					 new String[] {"ItemImage","ItemTitle", "ItemText"}, new int[] {R.id.list_imgbtn_Related, R.id.list_title_Related, R.id.list_info_Related}  
			             );		//数据绑定
			 
			 
			 mListviewRelateds.setAdapter(mSimpleAdapter_Relateds);
			 
			 mListviewRelateds.setOnItemClickListener(new OnItemClickListener( ) {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					// TODO Auto-generated method stub
					setTitle("你选择了亲友:"+arg2);//设置标题栏显示点击的行  
				}
			});
		 
			 
		 
	}
	
	

}
