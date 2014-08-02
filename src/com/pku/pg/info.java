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
//				jsonObject.put("RelativeName", "��˼��" + i);
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

		userName.setText(infoSharedPreferences.getString("UserName", "������δд��"));
		userPhone.setText(infoSharedPreferences
				.getString("UserPhone", "������δд��"));
		userHospital.setText(infoSharedPreferences.getString("Hospital",
				"������δд��"));

		// showAddDialog();

//		/* ���� *********************************************************** */
		mListviewVisors = (ListViewForScrollView) findViewById(R.id.info_list_Nurses); /* ����һ����̬���� */
//		mListItemVisors = new ArrayList<HashMap<String, Object>>(); /* �������д������ */
//		for (int i = 0; i < 10; i++) {
//			HashMap<String, Object> map_visors = new HashMap<String, Object>();
//			map_visors.put("ItemImage", R.drawable.choose);// ����ͼƬ
//			map_visors.put("ItemTitle", "����" + i);
//			map_visors.put("ItemText", "�ֻ���" + i);
//			mListItemVisors.add(map_visors);
//		}
//// mListItemVisors.remove(index);
		
//		 mSimpleAdapter_Nurses = new SimpleAdapter(this,
//				mListItemVisors, R.layout.list_nurses, new String[] {
//						"ItemImage", "ItemTitle", "ItemText" }, new int[] {
//						R.id.list_imgbtn_Nurse, R.id.list_title_Nurse,
//						R.id.list_info_Nurse }); // ���ݰ�
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
		
		
		mListItemVisors = new ArrayList<HashMap<String, Object>>(); /* �������д������ */
		if(aa.equals("")) {
			NurseName = "������ϵ��";
			NursePhone = "��δ�����Ϣ";
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
			map_visors.put("ItemImage", R.drawable.choose);// ����ͼƬ
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
						R.id.list_info_Nurse }); // ���ݰ�
		mListviewVisors.setAdapter(mSimpleAdapter_Nurses);
		/*end*/

		mListviewVisors.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				setTitle("��ѡ���˻�����Ա" + arg2);// ���ñ�������ʾ�������
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

//		/* ���� ************************************************************ */
//		mListviewRelateds = (ListViewForScrollView) findViewById(R.id.info_list_Related); /* ����һ����̬���� */
//		mListItemRelated = new ArrayList<HashMap<String, Object>>(); /* �������д������ */
//		for (int i = 0; i < 3; i++) {
//			HashMap<String, Object> map_relateds = new HashMap<String, Object>();
//			map_relateds.put("ItemImage", R.drawable.choose);// ����ͼƬ
//			map_relateds.put("ItemTitle", "����" + i);
//			map_relateds.put("ItemText", "�ֻ���" + i);
//			mListItemRelated.add(map_relateds);
//		}
//		SimpleAdapter mSimpleAdapter_Relateds = new SimpleAdapter(this,
//				mListItemRelated, R.layout.list_relateds, new String[] {
//						"ItemImage", "ItemTitle", "ItemText" }, new int[] {
//						R.id.list_imgbtn_Related, R.id.list_title_Related,
//						R.id.list_info_Related }); // ���ݰ�
//
//		mListviewRelateds.setAdapter(mSimpleAdapter_Relateds);
//
//		mListviewRelateds.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//					long arg3) {
//				// TODO Auto-generated method stub
//				setTitle("��ѡ��������:" + arg2);// ���ñ�������ʾ�������
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
			//========================================================================�û�ע��
			// �����Ի���
			LayoutInflater inflater_UserReg = getLayoutInflater();
			View layout_UserReg = inflater_UserReg.inflate(R.layout.user_reg_dialog,
					(ViewGroup) findViewById(R.id.user_reg_v01));
			regUserName = (EditText) layout_UserReg.findViewById(R.id.user_reg_EditText_name);
			regUserPhone = (EditText) layout_UserReg.findViewById(R.id.user_reg_EditText_phone);
			regUserHospital = (EditText) layout_UserReg.findViewById(R.id.user_reg_EditText_hospital);
			new AlertDialog.Builder(this)
					.setTitle("����дע����Ϣ")
					.setView(layout_UserReg)
					.setPositiveButton("ȷ��",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									// �����SharedPreferences

									 editor = infoSharedPreferences.edit();
									 editor.putString("UserName", regUserName.getText().toString());
									/* editor.putInt("UserPhone",
									 Integer.parseInt(regPhone.getText().toString()));*/
									 editor.putString("UserPhone", regUserPhone.getText().toString());
									 editor.putString("Hospital", regUserHospital.getText().toString());
									 editor.commit();
									

								}
							}).setNegativeButton("ȡ��", null).show();


			break;
		case R.id.info_imageview_AddNurses:
			//======================================================================            ����ע��
			LayoutInflater inflater_NurseReg = getLayoutInflater();
			View layout_NurseReg = inflater_NurseReg.inflate(R.layout.nurses_reg_dialog,
					(ViewGroup) findViewById(R.id.nurse_reg_v01));
			regNurseName = (EditText) layout_NurseReg.findViewById(R.id.reg_NurseName_EditText_name);
			regNursePhone = (EditText) layout_NurseReg.findViewById(R.id.reg_NursePhone_EditText_phone);

			new AlertDialog.Builder(this)
					.setTitle("����дע����Ϣ")
					.setView(layout_NurseReg)
					.setNegativeButton("ȡ��", null)
					.setPositiveButton("ȷ��",
							new DialogInterface.OnClickListener() {


								private JSONArray jsonArray;
								private JSONObject jsonObject;

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									/*�����Json*/  
									jsonObject = new JSONObject();

									try {
										jsonObject.put("NurseName", regNurseName.getText().toString());
										jsonObject.put("NursePhone", regNursePhone.getText().toString());
//										nurseName = jsonObject.getString("NurseName");
//										nursePhone = jsonObject.getString("NursePhone");
										Log.d("jsonObjectд��", regNurseName.getText().toString());
									} catch (JSONException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
//									/*JsonArray*/ 
									jsonArray = new JSONArray();
									jsonArray.put(jsonObject);
									
//									/*array�����SharedPreferences*/
									
									String jsonArrayStr = jsonArray.toString();
									String infoNurseReg =  infoSharedPreferences.getString("NursesInfo", "") + jsonArrayStr;
									
									editor = infoSharedPreferences.edit();
									editor.putString("NursesInfo",infoNurseReg);
									editor.commit();
									Log.i("����ע��arrstr",jsonArrayStr  );
									Log.i("����ע��infor",infoNurseReg  );
									Log.i("����ע��sp", infoSharedPreferences.getString("NursesInfo", "Nothing Doh!l"));
									/*��listview����ʾ����*/
									
//									mListItemVisors = new ArrayList<HashMap<String, Object>>(); /* �������д������ */
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
//										map_visors.put("ItemImage", R.drawable.choose);// ����ͼƬ
//										map_visors.put("ItemTitle", NurseName);
//										map_visors.put("ItemText", NursePhone);
//										mListItemVisors.add(map_visors);
//									}
//									// mListItemVisors.remove(index);
//									 mSimpleAdapter_Visors = new SimpleAdapter(this,
//											mListItemVisors, R.layout.list_nurses, new String[] {
//													"ItemImage", "ItemTitle", "ItemText" }, new int[] {
//													R.id.list_imgbtn_Nurse, R.id.list_title_Nurse,
//													R.id.list_info_Nurse }); // ���ݰ�
//									mListviewVisors.setAdapter(mSimpleAdapter_Nurses);
									
								}
							}).show();
			
			break;

		default:
			break;
		}
	}



}
