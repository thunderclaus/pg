package com.pku.pg;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class info extends Activity implements OnClickListener {

	private ListViewForScrollView mListviewVisors;
	private ListViewForScrollView mListviewRelateds;
	private ScrollView infoScrollView;
	private ArrayList<HashMap<String, Object>> mListItemVisors;
	private ArrayList<HashMap<String, Object>> mListItemRelated;
	private SharedPreferences infoSharedPreferences;


	private TextView userName;
	private TextView userPhone;
	private TextView userHospital;
	private Context infoContext;
	private Editor editor;
	
	
	private SimpleAdapter mSimpleAdapter_Nurses;

	private String NurseName;
	private String NursePhone;
	private EditText regNurseName;
	private EditText regNursePhone;
	
	private EditText regUserName;
	private EditText regUserPhone;
	private EditText regUserHospital;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);

		infoScrollView = (ScrollView) findViewById(R.id.info_scrollview);
		infoScrollView.smoothScrollTo(0, 0);

		findViewById(R.id.info_btn_UserChange).setOnClickListener(this);
		findViewById(R.id.info_imageview_AddNurses).setOnClickListener(this);
		findViewById(R.id.info_imageview_AddRelated).setOnClickListener(this);

		infoContext = info.this;
		infoSharedPreferences = infoContext.getSharedPreferences("UserInfo",
				Context.MODE_PRIVATE);
		
		
//		for (int i = 0; i< 10; i++) {
//		JSONObjectjsonObject = new JSONObject();
//			String relativeName = "";
//			String phoneNum = "";
//			try {
//				jsonObject.put("RelativeName", "张思博" + i);
//				jsonObject.put("PhoneNum", "13261785958" + i);
//				relativeName = jsonObject.getString("RelativeName");
//				phoneNum = jsonObject.getString("PhoneNum");
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			jsonArray.put(jsonObject);
//			String jsonStr = jsonObject.toString();
//			Log.e("JSONOject", jsonStr);
//			Log.e("RelativeName", relativeName);
//			Log.e("PhoneNum", phoneNum);
//		}
//		String jsonArrayStr = jsonArray.toString();
//		Log.e("JSONArray", jsonArrayStr);
//		editor = infoSharedPreferences.edit();
//		editor.putString("RELATIVE", jsonArrayStr);
//		editor.commit();
//		String s = infoSharedPreferences.getString("RELATIVE", "");
//		Log.e("savedRELATIVE", s);

		userName = (TextView) findViewById(R.id.info_textview_UserName);
		userPhone = (TextView) findViewById(R.id.info_textview_UserPhone);
		userHospital = (TextView) findViewById(R.id.info_textview_UserHospital);

		userName.setText(infoSharedPreferences.getString("UserName", "数据尚未写入"));
		userPhone.setText(infoSharedPreferences
				.getString("UserPhone", "数据尚未写入"));
		userHospital.setText(infoSharedPreferences.getString("Hospital",
				"数据尚未写入"));

		// showAddDialog();

//		/* 护工 *********************************************************** */
		mListviewVisors = (ListViewForScrollView) findViewById(R.id.info_list_Nurses); /* 定义一个动态数组 */
//		mListItemVisors = new ArrayList<HashMap<String, Object>>(); /* 在数组中存放数据 */
//		for (int i = 0; i < 10; i++) {
//			HashMap<String, Object> map_visors = new HashMap<String, Object>();
//			map_visors.put("ItemImage", R.drawable.choose);// 加入图片
//			map_visors.put("ItemTitle", "姓名" + i);
//			map_visors.put("ItemText", "手机号" + i);
//			mListItemVisors.add(map_visors);
//		}
//// mListItemVisors.remove(index);
		
//		 mSimpleAdapter_Nurses = new SimpleAdapter(this,
//				mListItemVisors, R.layout.list_nurses, new String[] {
//						"ItemImage", "ItemTitle", "ItemText" }, new int[] {
//						R.id.list_imgbtn_Nurse, R.id.list_title_Nurse,
//						R.id.list_info_Nurse }); // 数据绑定
//		 mListviewVisors.setAdapter(mSimpleAdapter_Nurses);
//		mListviewVisors.setAdapter(mSimpleAdapter_Visors);
		
		
		//*test***************************************************************************************************************************JSON oncreate//
		String aa =   infoSharedPreferences.getString("NursesInfo", "");
		JSONArray jsonArray01 = null;
		
		try {
			jsonArray01 = new JSONArray(aa);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		mListItemVisors = new ArrayList<HashMap<String, Object>>(); /* 在数组中存放数据 */
		if(aa.equals("")) {
			NurseName = "尚无联系人";
			NursePhone = "尚未添加信息";
		}
		else {
		
		for (int i = 0; i <  jsonArray01.length(); i++) {
	try {
		NurseName = jsonArray01.getJSONObject(i).getString(
				"NurseName").toString();
		NursePhone =  jsonArray01.getJSONObject(i).getString(
				"NursePhone").toString();
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
		
			HashMap<String, Object> map_visors = new HashMap<String, Object>();
			map_visors.put("ItemImage", R.drawable.choose);// 加入图片
			map_visors.put("ItemTitle", NurseName);
			map_visors.put("ItemText", NursePhone);
			mListItemVisors.add(map_visors);
			Log.e("====","NurseName:"+NurseName+"NursePhon:"+NursePhone);
		}
		// mListItemVisors.remove(index);
		 mSimpleAdapter_Nurses = new SimpleAdapter(this,
				mListItemVisors, R.layout.list_nurses, new String[] {
						"ItemImage", "ItemTitle", "ItemText" }, new int[] {
						R.id.list_imgbtn_Nurse, R.id.list_title_Nurse,
						R.id.list_info_Nurse }); // 数据绑定
		mListviewVisors.setAdapter(mSimpleAdapter_Nurses);
		/*end*/

		mListviewVisors.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				setTitle("你选择了护理人员" + arg2);// 设置标题栏显示点击的行
			}
		});
		mListviewVisors
				.setOnItemLongClickListener(new OnItemLongClickListener() {

					@Override
					public boolean onItemLongClick(AdapterView<?> arg0,
							View arg1, int arg2, long arg3) {

						return false;
					}

				});

//		/* 亲属 ************************************************************ */
//		mListviewRelateds = (ListViewForScrollView) findViewById(R.id.info_list_Related); /* 定义一个动态数组 */
//		mListItemRelated = new ArrayList<HashMap<String, Object>>(); /* 在数组中存放数据 */
//		for (int i = 0; i < 3; i++) {
//			HashMap<String, Object> map_relateds = new HashMap<String, Object>();
//			map_relateds.put("ItemImage", R.drawable.choose);// 加入图片
//			map_relateds.put("ItemTitle", "姓名" + i);
//			map_relateds.put("ItemText", "手机号" + i);
//			mListItemRelated.add(map_relateds);
//		}
//		SimpleAdapter mSimpleAdapter_Relateds = new SimpleAdapter(this,
//				mListItemRelated, R.layout.list_relateds, new String[] {
//						"ItemImage", "ItemTitle", "ItemText" }, new int[] {
//						R.id.list_imgbtn_Related, R.id.list_title_Related,
//						R.id.list_info_Related }); // 数据绑定
//
//		mListviewRelateds.setAdapter(mSimpleAdapter_Relateds);
//
//		mListviewRelateds.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//					long arg3) {
//				// TODO Auto-generated method stub
//				setTitle("你选择了亲友:" + arg2);// 设置标题栏显示点击的行
//			}
//		});
//		mListviewRelateds
//				.setOnItemLongClickListener(new OnItemLongClickListener() {
//
//					@Override
//					public boolean onItemLongClick(AdapterView<?> arg0,
//							View arg1, int arg2, long arg3) {
//						// TODO Auto-generated method stub
//						return false;
//					}
//				});

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.info_btn_UserChange:
			//========================================================================用户注册
			// 弹出对话框
			LayoutInflater inflater_UserReg = getLayoutInflater();
			View layout_UserReg = inflater_UserReg.inflate(R.layout.user_reg_dialog,
					(ViewGroup) findViewById(R.id.user_reg_v01));
			regUserName = (EditText) layout_UserReg.findViewById(R.id.user_reg_EditText_name);
			regUserPhone = (EditText) layout_UserReg.findViewById(R.id.user_reg_EditText_phone);
			regUserHospital = (EditText) layout_UserReg.findViewById(R.id.user_reg_EditText_hospital);
			new AlertDialog.Builder(this)
					.setTitle("请填写注册信息")
					.setView(layout_UserReg)
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									// 保存进SharedPreferences

									 editor = infoSharedPreferences.edit();
									 editor.putString("UserName", regUserName.getText().toString());
									/* editor.putInt("UserPhone",
									 Integer.parseInt(regPhone.getText().toString()));*/
									 editor.putString("UserPhone", regUserPhone.getText().toString());
									 editor.putString("Hospital", regUserHospital.getText().toString());
									 editor.commit();
									

								}
							}).setNegativeButton("取消", null).show();


			break;
		case R.id.info_imageview_AddNurses:
			//======================================================================            护工注册
			LayoutInflater inflater_NurseReg = getLayoutInflater();
			View layout_NurseReg = inflater_NurseReg.inflate(R.layout.nurses_reg_dialog,
					(ViewGroup) findViewById(R.id.nurse_reg_v01));
			regNurseName = (EditText) layout_NurseReg.findViewById(R.id.reg_NurseName_EditText_name);
			regNursePhone = (EditText) layout_NurseReg.findViewById(R.id.reg_NursePhone_EditText_phone);

			new AlertDialog.Builder(this)
					.setTitle("请填写注册信息")
					.setView(layout_NurseReg)
					.setNegativeButton("取消", null)
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {


								private JSONArray jsonArray;
								private JSONObject jsonObject;

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									/*保存进Json*/  
									jsonObject = new JSONObject();

									try {
										jsonObject.put("NurseName", regNurseName.getText().toString());
										jsonObject.put("NursePhone", regNursePhone.getText().toString());
//										nurseName = jsonObject.getString("NurseName");
//										nursePhone = jsonObject.getString("NursePhone");
										Log.d("jsonObject写入", regNurseName.getText().toString());
									} catch (JSONException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
//									/*JsonArray*/ 
									jsonArray = new JSONArray();
									jsonArray.put(jsonObject);
									
//									/*array保存进SharedPreferences*/
									
									String jsonArrayStr = jsonArray.toString();
									String infoNurseReg =  infoSharedPreferences.getString("NursesInfo", "") + jsonArrayStr;
									
									editor = infoSharedPreferences.edit();
									editor.putString("NursesInfo",infoNurseReg);
									editor.commit();
									Log.i("护工注册arrstr",jsonArrayStr  );
									Log.i("护工注册infor",infoNurseReg  );
									Log.i("护工注册sp", infoSharedPreferences.getString("NursesInfo", "Nothing Doh!l"));
									/*在listview中显示数据*/
									
//									mListItemVisors = new ArrayList<HashMap<String, Object>>(); /* 在数组中存放数据 */
//									for (int i = 0; i <  jsonArray.length(); i++) {
//								try {
//									NurseName = jsonArray.getJSONObject(i).getString(
//											"NurseName");
//									NursePhone =  jsonArray.getJSONObject(i).getString(
//											"NursePhone");
//								} catch (JSONException e) {
//									// TODO Auto-generated catch block
//									e.printStackTrace();
//								}
//									
//										HashMap<String, Object> map_visors = new HashMap<String, Object>();
//										map_visors.put("ItemImage", R.drawable.choose);// 加入图片
//										map_visors.put("ItemTitle", NurseName);
//										map_visors.put("ItemText", NursePhone);
//										mListItemVisors.add(map_visors);
//									}
//									// mListItemVisors.remove(index);
//									 mSimpleAdapter_Visors = new SimpleAdapter(this,
//											mListItemVisors, R.layout.list_nurses, new String[] {
//													"ItemImage", "ItemTitle", "ItemText" }, new int[] {
//													R.id.list_imgbtn_Nurse, R.id.list_title_Nurse,
//													R.id.list_info_Nurse }); // 数据绑定
//									mListviewVisors.setAdapter(mSimpleAdapter_Nurses);
									
								}
							}).show();
			
			break;

		default:
			break;
		}
	}



}
