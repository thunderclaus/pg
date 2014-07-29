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
		 
		/* ���� ************************************************************/ 
		mListviewVisors = (ListViewForScrollView)findViewById(R.id.info_list_Visors);	/*����һ����̬����*/      
		ArrayList<HashMap<String, Object>> mListItemVisors = new ArrayList<HashMap<String, Object>>();	/*�������д������*/
		 for(int i=0;i<10;i++)  
	        {  
	            HashMap<String, Object> map_visors = new HashMap<String, Object>();  
	            map_visors.put("ItemImage", R.drawable.choose);//����ͼƬ 
	            map_visors.put("ItemTitle", "����"+i);  
	            map_visors.put("ItemText", "�ֻ���"+i);  
	            mListItemVisors.add(map_visors);  
	        } 
		 SimpleAdapter mSimpleAdapter_Visors = new SimpleAdapter(this, mListItemVisors ,R.layout.list_visors, 
				 new String[] {"ItemImage","ItemTitle", "ItemText"}, new int[] {R.id.list_imgbtn_Visor, R.id.list_title_Visor, R.id.list_info_Visor}  
		             );		//���ݰ�
		 
		// mListviewVisors.addHeaderView(headerView); 
		 mListviewVisors.setAdapter(mSimpleAdapter_Visors);
		 //setListViewHeightBasedOnChildren(mListviewVisors);
		 //setListViewHeight(mListviewVisors);
		 mListviewVisors.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				setTitle("��ѡ���˻�����Ա"+arg2);//���ñ�������ʾ�������  
			}
		});
		 
		
		 /* ����  *************************************************************/ 
		 mListviewRelateds = (ListViewForScrollView) findViewById(R.id.info_list_Related);	/*����һ����̬����*/      
			ArrayList<HashMap<String, Object>> mListItemRelated = new ArrayList<HashMap<String, Object>>();	/*�������д������*/
			 for(int i=0;i<3;i++)  
		        {  
		            HashMap<String, Object> map_relateds = new HashMap<String, Object>();  
		            map_relateds.put("ItemImage", R.drawable.choose);//����ͼƬ 
		            map_relateds.put("ItemTitle", "����"+i);  
		            map_relateds.put("ItemText", "�ֻ���"+i);  
		            mListItemRelated.add(map_relateds);  
		        } 
			 SimpleAdapter mSimpleAdapter_Relateds = new SimpleAdapter(this, mListItemRelated ,R.layout.list_relateds , 
					 new String[] {"ItemImage","ItemTitle", "ItemText"}, new int[] {R.id.list_imgbtn_Related, R.id.list_title_Related, R.id.list_info_Related}  
			             );		//���ݰ�
			 
			 
			 mListviewRelateds.setAdapter(mSimpleAdapter_Relateds);
			 
			 mListviewRelateds.setOnItemClickListener(new OnItemClickListener( ) {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					// TODO Auto-generated method stub
					setTitle("��ѡ��������:"+arg2);//���ñ�������ʾ�������  
				}
			});
		 
			 
		 
	}
	
	

}
