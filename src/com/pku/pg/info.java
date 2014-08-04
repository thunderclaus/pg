//package com.pku.pg;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.SharedPreferences;
//import android.content.SharedPreferences.Editor;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.AdapterView.OnItemLongClickListener;
//import android.widget.EditText;
//import android.widget.ScrollView;
//import android.widget.SimpleAdapter;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class info extends Activity implements OnClickListener {
//
//	private ListViewForScrollView mListviewNurses;
//	private ListViewForScrollView mListviewRelatives;
//	private ScrollView infoScrollView;
//	private ArrayList<HashMap<String, Object>> mListItemNurses;
//	private ArrayList<HashMap<String, Object>> mListItemRelative;
//	private SharedPreferences infoSharedPreferences;
//
//	private TextView userName;
//	private TextView userPhone;
//	private TextView userHospital;
//	private Context infoContext;
//	private Editor editor;
//
//	private SimpleAdapter mSimpleAdapter_Nurses;
//
//	private String NurseName;
//	private String NursePhone;
//	private EditText regNurseName;
//	private EditText regNursePhone;
//
//	private EditText regUserName;
//	private EditText regUserPhone;
//	private EditText regUserHospital;
//	private JSONArray jsonArray;
//	private JSONArray jsonArray01;
//	protected JSONArray jsonArray02;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.info);
//
//		infoScrollView = (ScrollView) findViewById(R.id.info_scrollview);
//		infoScrollView.smoothScrollTo(0, 0);
//
//		findViewById(R.id.info_btn_UserChange).setOnClickListener(this);
//		findViewById(R.id.info_imageview_AddNurses).setOnClickListener(this);
//		findViewById(R.id.info_imageview_AddRelative).setOnClickListener(this);
//
//		infoContext = info.this;
//		infoSharedPreferences = infoContext.getSharedPreferences("UserInfo",
//				Context.MODE_PRIVATE);
//
//		// for (int i = 0; i< 10; i++) {
//		// JSONObjectjsonObject = new JSONObject();
//		// String relativeName = "";
//		// String phoneNum = "";
//		// try {
//		// jsonObject.put("RelativeName", "��˼��" + i);
//		// jsonObject.put("PhoneNum", "13261785958" + i);
//		// relativeName = jsonObject.getString("RelativeName");
//		// phoneNum = jsonObject.getString("PhoneNum");
//		// } catch (JSONException e) {
//		// // TODO Auto-generated catch block
//		// e.printStackTrace();
//		// }
//		// jsonArray.put(jsonObject);
//		// String jsonStr = jsonObject.toString();
//		// Log.e("JSONOject", jsonStr);
//		// Log.e("RelativeName", relativeName);
//		// Log.e("PhoneNum", phoneNum);
//		// }
//		// String jsonArrayStr = jsonArray.toString();
//		// Log.e("JSONArray", jsonArrayStr);
//		// editor = infoSharedPreferences.edit();
//		// editor.putString("RELATIVE", jsonArrayStr);
//		// editor.commit();
//		// String s = infoSharedPreferences.getString("RELATIVE", "");
//		// Log.e("savedRELATIVE", s);
//
//		userName = (TextView) findViewById(R.id.info_textview_UserName);
//		userPhone = (TextView) findViewById(R.id.info_textview_UserPhone);
//		userHospital = (TextView) findViewById(R.id.info_textview_UserHospital);
//
//		userName.setText(infoSharedPreferences.getString("UserName", "������δд��"));
//		userPhone.setText(infoSharedPreferences
//				.getString("UserPhone", "������δд��"));
//		userHospital.setText(infoSharedPreferences.getString("Hospital",
//				"������δд��"));
//
//		spclear();
//
//		// showAddDialog();
//
//		// /* ���� *********************************************************** */
//		mListviewNurses = (ListViewForScrollView) findViewById(R.id.info_list_Nurses); /* ����һ����̬���� */
//		// mListItemNurses = new ArrayList<HashMap<String, Object>>(); /*
//		// �������д������ */
//		// for (int i = 0; i < 10; i++) {
//		// HashMap<String, Object> map_nurses = new HashMap<String, Object>();
//		// map_nurses.put("ItemImage", R.drawable.choose);// ����ͼƬ
//		// map_nurses.put("ItemTitle", "����" + i);
//		// map_nurses.put("ItemText", "�ֻ���" + i);
//		// mListItemNurses.add(map_nurses);
//		// }
//		// // mListItemNurses.remove(index);
//
//		// mSimpleAdapter_Nurses = new SimpleAdapter(this,
//		// mListItemNurses, R.layout.list_nurses, new String[] {
//		// "ItemImage", "ItemTitle", "ItemText" }, new int[] {
//		// R.id.list_imgbtn_Nurse, R.id.list_title_Nurse,
//		// R.id.list_info_Nurse }); // ���ݰ�
//		// mListviewNurses.setAdapter(mSimpleAdapter_Nurses);
//		// mListviewNurses.setAdapter(mSimpleAdapter_Nurses);
//
//		// *test***************************************************************************************************************************JSON
//		// oncreate//
//		// jsonArray = new JSONArray();
//		jsonArray02 = new JSONArray();
//		String aa = infoSharedPreferences.getString("NursesInfo", "");
//		// JSONArray jsonArray01 = null;
//
//		try {
//			jsonArray01 = new JSONArray(aa);
//		} catch (JSONException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		mListItemNurses = new ArrayList<HashMap<String, Object>>(); /* �������д������ */
//		if (aa.equals("")) {
//			// final JSONObject jsonObject01 = null;
//			JSONObject jsonObject01 =  new JSONObject();
//			// NurseName = "������ϵ��";
//			// NursePhone = "��δ�����Ϣ";
//			try {
//				
//				jsonObject01.put("NurseName", "�������ϵ��");
//				jsonObject01.put("NursePhone", "�������ϵ��ʽ");
//				jsonArray01.put(jsonObject01);
//				NurseName = jsonArray01.getJSONObject(1)
//						.getString("NurseName").toString();
//				NursePhone = jsonArray01.getJSONObject(1)
//						.getString("NursePhone").toString();
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		} else {
//

//			for (int i = 0; i < jsonArray01.length(); i++) {
//				try {
//					NurseName = jsonArray01.getJSONObject(i)
//							.getString("NurseName").toString();
//					NursePhone = jsonArray01.getJSONObject(i)
//							.getString("NursePhone").toString();
//				} catch (JSONException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//
//			HashMap<String, Object> map_nurses = new HashMap<String, Object>();
//			map_nurses.put("ItemImage", R.drawable.choose);// ����ͼƬ
//			map_nurses.put("ItemTitle", NurseName);
//			map_nurses.put("ItemText", NursePhone);
//			mListItemNurses.add(map_nurses);
//			Log.e("====", "NurseName:" + NurseName + "NursePhon:" + NursePhone);
//		}
//		// mListItemNurses.remove(index);
//		mSimpleAdapter_Nurses = new SimpleAdapter(this, mListItemNurses,
//				R.layout.list_nurses, new String[] { "ItemImage", "ItemTitle",
//						"ItemText" }, new int[] { R.id.list_imgbtn_Nurse,
//						R.id.list_title_Nurse, R.id.list_info_Nurse }); // ���ݰ�
//		mListviewNurses.setAdapter(mSimpleAdapter_Nurses);
//		/* end */
//
//		mListviewNurses.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//					long arg3) {
//				// TODO Auto-generated method stub
//				setTitle("��ѡ���˻�����Ա" + arg2);// ���ñ�������ʾ�������
//			}
//		});
//		mListviewNurses
//				.setOnItemLongClickListener(new OnItemLongClickListener() {
//
//					@Override
//					public boolean onItemLongClick(AdapterView<?> arg0,
//							View arg1, int arg2, long arg3) {
//
//						return false;
//					}
//
//				});
//
//		// /* ���� ************************************************************ */
//		// mListviewRelatives = (ListViewForScrollView)
//		// findViewById(R.id.info_list_Relative); /* ����һ����̬���� */
//		// mListItemRelative = new ArrayList<HashMap<String, Object>>(); /*
//		// �������д������ */
//		// for (int i = 0; i < 3; i++) {
//		// HashMap<String, Object> map_relatives = new HashMap<String, Object>();
//		// map_relatives.put("ItemImage", R.drawable.choose);// ����ͼƬ
//		// map_relatives.put("ItemTitle", "����" + i);
//		// map_relatives.put("ItemText", "�ֻ���" + i);
//		// mListItemRelative.add(map_relatives);
//		// }
//		// SimpleAdapter mSimpleAdapter_Relatives = new SimpleAdapter(this,
//		// mListItemRelative, R.layout.list_relatives, new String[] {
//		// "ItemImage", "ItemTitle", "ItemText" }, new int[] {
//		// R.id.list_imgbtn_Relative, R.id.list_title_Relative,
//		// R.id.list_info_Relative }); // ���ݰ�
//		//
//		// mListviewRelatives.setAdapter(mSimpleAdapter_Relatives);
//		//
//		// mListviewRelatives.setOnItemClickListener(new OnItemClickListener() {
//		//
//		// @Override
//		// public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//		// long arg3) {
//		// // TODO Auto-generated method stub
//		// setTitle("��ѡ��������:" + arg2);// ���ñ�������ʾ�������
//		// }
//		// });
//		// mListviewRelatives
//		// .setOnItemLongClickListener(new OnItemLongClickListener() {
//		//
//		// @Override
//		// public boolean onItemLongClick(AdapterView<?> arg0,
//		// View arg1, int arg2, long arg3) {
//		// // TODO Auto-generated method stub
//		// return false;
//		// }
//		// });
//
//	}
//
//	@Override
//	public void onClick(View v) {
//		// TODO Auto-generated method stub
//		switch (v.getId()) {
//		case R.id.info_btn_UserChange:
//			// ========================================================================�û�ע��
//			// �����Ի���
//			LayoutInflater inflater_UserReg = getLayoutInflater();
//			View layout_UserReg = inflater_UserReg.inflate(
//					R.layout.user_reg_dialog,
//					(ViewGroup) findViewById(R.id.user_reg_v01));
//			regUserName = (EditText) layout_UserReg
//					.findViewById(R.id.user_reg_EditText_name);
//			regUserPhone = (EditText) layout_UserReg
//					.findViewById(R.id.user_reg_EditText_phone);
//			regUserHospital = (EditText) layout_UserReg
//					.findViewById(R.id.user_reg_EditText_hospital);
//			new AlertDialog.Builder(this)
//					.setTitle("����дע����Ϣ")
//					.setView(layout_UserReg)
//					.setPositiveButton("ȷ��",
//							new DialogInterface.OnClickListener() {
//
//								@Override
//								public void onClick(DialogInterface dialog,
//										int which) {
//									// TODO Auto-generated method stub
//									// �����SharedPreferences
//
//									editor = infoSharedPreferences.edit();
//									editor.putString("UserName", regUserName
//											.getText().toString());
//									/*
//									 * editor.putInt("UserPhone",
//									 * Integer.parseInt
//									 * (regPhone.getText().toString()));
//									 */
//									editor.putString("UserPhone", regUserPhone
//											.getText().toString());
//									editor.putString("Hospital",
//											regUserHospital.getText()
//													.toString());
//									editor.commit();
//
//								}
//							}).setNegativeButton("ȡ��", null).show();
//
//			break;
//		case R.id.info_imageview_AddNurses:
//			// ======================================================================
//			// ����ע��
//			LayoutInflater inflater_NurseReg = getLayoutInflater();
//			View layout_NurseReg = inflater_NurseReg.inflate(
//					R.layout.nurses_reg_dialog,
//					(ViewGroup) findViewById(R.id.nurse_reg_v01));
//			regNurseName = (EditText) layout_NurseReg
//					.findViewById(R.id.reg_NurseName_EditText_name);
//			regNursePhone = (EditText) layout_NurseReg
//					.findViewById(R.id.reg_NursePhone_EditText_phone);
//
//			new AlertDialog.Builder(this)
//					.setTitle("����дע����Ϣ")
//					.setView(layout_NurseReg)
//					.setNegativeButton("ȡ��", null)
//					.setPositiveButton("ȷ��",
//							new DialogInterface.OnClickListener() {
//
//								private JSONArray jsonArray;
//								private JSONObject jsonObject;
//
//								@Override
//								public void onClick(DialogInterface dialog,
//										int which) {
//									// TODO Auto-generated method stub
//									/* �����Json */
//									jsonObject = new JSONObject();
//
//									try {
//										jsonObject.put("NurseName",
//												regNurseName.getText()
//														.toString());
//										jsonObject.put("NursePhone",
//												regNursePhone.getText()
//														.toString());
//										// nurseName =
//										// jsonObject.getString("NurseName");
//										// nursePhone =
//										// jsonObject.getString("NursePhone");
//										Log.d("jsonObjectд��", regNurseName
//												.getText().toString());
//									} catch (JSONException e) {
//										// TODO Auto-generated catch block
//										e.printStackTrace();
//									}
//
//									// /*JsonArray*/
//									// =========================
//									// jsonArray.put(jsonObject);
//									//
//									// // /*array�����SharedPreferences*/
//									//
//									// String jsonArrayStr =
//									// jsonArray.toString();
//									// jsonArray01.put(jsonObject);
//									// String jsonArrayStr = jsonArray01
//									// .toString();
//									// String infoNurseReg =
//									// infoSharedPreferences
//									// .getString("NursesInfo", "")
//									// + jsonArrayStr;
//									//
//									// editor = infoSharedPreferences.edit();
//									// editor.putString("NursesInfo",
//									// infoNurseReg);
//									// editor.commit();
//									//
//									jsonArray01.put(jsonObject);
//									String jsonArrayStr = jsonArray01
//											.toString();
//									String infoNurseReg = jsonArrayStr
//											+ infoSharedPreferences.getString(
//													"NursesInfo", "");
//
//									editor = infoSharedPreferences.edit();
//									editor.putString("NursesInfo", infoNurseReg);
//									editor.commit();
//
//									Log.i("����ע��arrstr", jsonArrayStr);
//									Log.i("����ע��infor", infoNurseReg);
//									Log.i("����ע��sp", infoSharedPreferences
//											.getString("NursesInfo",
//													"Nothing Doh!l"));
//									/* ��listview����ʾ���� */
//
//									// mListItemNurses = new
//									// ArrayList<HashMap<String, Object>>(); /*
//									// �������д������ */
//									// for (int i = 0; i < jsonArray.length();
//									// i++) {
//									// try {
//									// NurseName =
//									// jsonArray.getJSONObject(i).getString(
//									// "NurseName");
//									// NursePhone =
//									// jsonArray.getJSONObject(i).getString(
//									// "NursePhone");
//									// } catch (JSONException e) {
//									// // TODO Auto-generated catch block
//									// e.printStackTrace();
//									// }
//									//
//									// HashMap<String, Object> map_nurses = new
//									// HashMap<String, Object>();
//									// map_nurses.put("ItemImage",
//									// R.drawable.choose);// ����ͼƬ
//									// map_nurses.put("ItemTitle", NurseName);
//									// map_nurses.put("ItemText", NursePhone);
//									// mListItemNurses.add(map_nurses);
//									// }
//									// // mListItemNurses.remove(index);
//									// mSimpleAdapter_Nurses = new
//									// SimpleAdapter(this,
//									// mListItemNurses, R.layout.list_nurses,
//									// new String[] {
//									// "ItemImage", "ItemTitle", "ItemText" },
//									// new int[] {
//									// R.id.list_imgbtn_Nurse,
//									// R.id.list_title_Nurse,
//									// R.id.list_info_Nurse }); // ���ݰ�
//									// mListviewNurses.setAdapter(mSimpleAdapter_Nurses);
//
//								}
//							}).show();
//
//			break;
//
//		default:
//			break;
//		}
//	}
//
//	public void spclear() {
//		SharedPreferences.Editor editor = infoSharedPreferences.edit();
//		editor.clear();
//		editor.commit();
//	}
//
//}

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
import android.content.Intent;
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

	private ListViewForScrollView mListviewNurses;
	private ListViewForScrollView mListviewRelatives;
	private ScrollView infoScrollView;
	private ArrayList<HashMap<String, Object>> mListItemNurses;
	private ArrayList<HashMap<String, Object>> mListItemRelative;
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
	private String nursesStr;
	private JSONArray nursesJsonArray;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);

		infoScrollView = (ScrollView) findViewById(R.id.info_scrollview);
		infoScrollView.smoothScrollTo(0, 0);

		findViewById(R.id.info_btn_UserChange).setOnClickListener(this);
		findViewById(R.id.info_imageview_AddNurses).setOnClickListener(this);
		findViewById(R.id.info_imageview_AddRelative).setOnClickListener(this);

		infoContext = info.this;
		infoSharedPreferences = infoContext.getSharedPreferences("UserInfo",
				Context.MODE_PRIVATE);
		// spclear();

		userName = (TextView) findViewById(R.id.info_textview_UserName);
		userPhone = (TextView) findViewById(R.id.info_textview_UserPhone);
		userHospital = (TextView) findViewById(R.id.info_textview_UserHospital);

		userName.setText(infoSharedPreferences.getString("UserName", "������δд��"));
		userPhone.setText(infoSharedPreferences
				.getString("UserPhone", "������δд��"));
		userHospital.setText(infoSharedPreferences.getString("Hospital",
				"������δд��"));

		// /* ���� *********************************************************** */
		mListviewNurses = (ListViewForScrollView) findViewById(R.id.info_list_Nurses); /* ����һ����̬���� */

		nursesStr = infoSharedPreferences.getString("NursesInfo", "");

		mListItemNurses = new ArrayList<HashMap<String, Object>>(); /* �������д������ */
		if (nursesStr.equals("")) {
			NurseName = "������ϵ��";
			NursePhone = "��δ�����Ϣ";
			HashMap<String, Object> map_nurses = new HashMap<String, Object>();
			map_nurses.put("ItemImage", R.drawable.choose);// ����ͼƬ
			map_nurses.put("ItemTitle", NurseName);
			map_nurses.put("ItemText", NursePhone);
			mListItemNurses.add(map_nurses);
			Log.e("====", "NurseName:" + NurseName + "NursePhon:" + NursePhone);
		} else {
			try {
				nursesJsonArray = new JSONArray(nursesStr);
				for (int i = 0; i < nursesJsonArray.length(); i++) {
					NurseName = nursesJsonArray.getJSONObject(i)
							.getString("NurseName").toString();
					NursePhone = nursesJsonArray.getJSONObject(i)
							.getString("NursePhone").toString();
					HashMap<String, Object> map_nurses = new HashMap<String, Object>();
					map_nurses.put("ItemImage", R.drawable.choose);// ����ͼƬ
					map_nurses.put("ItemTitle", NurseName);
					map_nurses.put("ItemText", NursePhone);
					mListItemNurses.add(map_nurses);
					Log.e("====", "NurseName:" + NurseName + "NursePhon:"
							+ NursePhone);
				}
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		mSimpleAdapter_Nurses = new SimpleAdapter(this, mListItemNurses,
				R.layout.list_nurses, new String[] { "ItemImage", "ItemTitle",
						"ItemText" }, new int[] { R.id.list_imgbtn_Nurse,
						R.id.list_title_Nurse, R.id.list_info_Nurse }); // ���ݰ�
		mListviewNurses.setAdapter(mSimpleAdapter_Nurses);
		/* end */

		mListviewNurses.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				setTitle("��ѡ���˻�����Ա" + arg2);// ���ñ�������ʾ�������
			}
		});
		mListviewNurses
				.setOnItemLongClickListener(new OnItemLongClickListener() {
					private int position;

					@Override
					public boolean onItemLongClick(AdapterView<?> arg0,
							View arg1, int arg2, long arg3) {
						// TODO Auto-generated method stub
						position = arg2;
						new AlertDialog.Builder(infoContext)
								.setTitle("ȷ��ɾ��?")
								.setPositiveButton("ȷ��",
										new DialogInterface.OnClickListener() {

											@Override
											public void onClick(
													DialogInterface dialog,
													int which) {
												// TODO Auto-generated method
												// stub
												// �����SharedPreferences
												JSONArray newJSONArray = new JSONArray();
												for (int i = 0; i < nursesJsonArray
														.length(); i++) {
													if (i != position) {
														try {
															newJSONArray
																	.put(nursesJsonArray
																			.getJSONObject(i));
														} catch (JSONException e) {
															// TODO
															// Auto-generated
															// catch block
															e.printStackTrace();
														}
													}
												}
												nursesJsonArray = newJSONArray;
												if (nursesJsonArray.length() == 0) {
													nursesStr = "";
												} else {
													nursesStr = nursesJsonArray
															.toString();
												}
												editor = infoSharedPreferences
														.edit();
												editor.putString("NursesInfo",
														nursesStr);
												editor.commit();
												mListItemNurses
														.remove(position);
												mSimpleAdapter_Nurses
														.notifyDataSetChanged();
											}
										}).setNegativeButton("ȡ��", null).show();

						return false;
					}
				});

		// /* ���� ************************************************************ */
		// mListviewRelatives = (ListViewForScrollView)
		// findViewById(R.id.info_list_Relative); /* ����һ����̬���� */
		// mListItemRelative = new ArrayList<HashMap<String, Object>>(); /*
		// �������д������ */
		// for (int i = 0; i < 3; i++) {
		// HashMap<String, Object> map_relatives = new HashMap<String, Object>();
		// map_relatives.put("ItemImage", R.drawable.choose);// ����ͼƬ
		// map_relatives.put("ItemTitle", "����" + i);
		// map_relatives.put("ItemText", "�ֻ���" + i);
		// mListItemRelative.add(map_relatives);
		// }
		// SimpleAdapter mSimpleAdapter_Relatives = new SimpleAdapter(this,
		// mListItemRelative, R.layout.list_relatives, new String[] {
		// "ItemImage", "ItemTitle", "ItemText" }, new int[] {
		// R.id.list_imgbtn_Relative, R.id.list_title_Relative,
		// R.id.list_info_Relative }); // ���ݰ�
		//
		// mListviewRelatives.setAdapter(mSimpleAdapter_Relatives);
		//
		// mListviewRelatives.setOnItemClickListener(new OnItemClickListener() {
		//
		// @Override
		// public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
		// long arg3) {
		// // TODO Auto-generated method stub
		// setTitle("��ѡ��������:" + arg2);// ���ñ�������ʾ�������
		// }
		// });
		// mListviewRelatives
		// .setOnItemLongClickListener(new OnItemLongClickListener() {
		//
		// @Override
		// public boolean onItemLongClick(AdapterView<?> arg0,
		// View arg1, int arg2, long arg3) {
		// // TODO Auto-generated method stub
		// return false;
		// }
		// });

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.info_btn_UserChange:
			// ========================================================================�û�ע��
			// �����Ի���
			LayoutInflater inflater_UserReg = getLayoutInflater();
			View layout_UserReg = inflater_UserReg.inflate(
					R.layout.user_reg_dialog,
					(ViewGroup) findViewById(R.id.user_reg_v01));
			regUserName = (EditText) layout_UserReg
					.findViewById(R.id.user_reg_EditText_name);
			regUserPhone = (EditText) layout_UserReg
					.findViewById(R.id.user_reg_EditText_phone);
			regUserHospital = (EditText) layout_UserReg
					.findViewById(R.id.user_reg_EditText_hospital);
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
									editor.putString("UserName", regUserName
											.getText().toString());
									/*
									 * editor.putInt("UserPhone",
									 * Integer.parseInt
									 * (regPhone.getText().toString()));
									 */
									editor.putString("UserPhone", regUserPhone
											.getText().toString());
									editor.putString("Hospital",
											regUserHospital.getText()
													.toString());
									editor.commit();

									refresh();

								}
							}).setNegativeButton("ȡ��", null).show();

			break;
		case R.id.info_imageview_AddNurses:
			// ======================================================================
			// ����ע��
			LayoutInflater inflater_NurseReg = getLayoutInflater();
			View layout_NurseReg = inflater_NurseReg.inflate(
					R.layout.nurses_reg_dialog,
					(ViewGroup) findViewById(R.id.nurse_reg_v01));
			regNurseName = (EditText) layout_NurseReg
					.findViewById(R.id.reg_NurseName_EditText_name);
			regNursePhone = (EditText) layout_NurseReg
					.findViewById(R.id.reg_NursePhone_EditText_phone);

			new AlertDialog.Builder(this)
					.setTitle("����дע����Ϣ")
					.setView(layout_NurseReg)
					.setNegativeButton("ȡ��", null)
					.setPositiveButton("ȷ��",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									/* �����Json */
									JSONObject jsonObject = new JSONObject();
									NurseName = regNurseName.getText()
											.toString();
									NursePhone = regNursePhone.getText()
											.toString();
									try {
										jsonObject.put("NurseName", NurseName);
										jsonObject
												.put("NursePhone", NursePhone);
										// nurseName =
										// jsonObject.getString("NurseName");
										// nursePhone =
										// jsonObject.getString("NursePhone");
										Log.d("jsonObjectд��", regNurseName
												.getText().toString());
										/* JsonArray */
										if (nursesJsonArray == null) {
											nursesJsonArray = new JSONArray();
										}
										nursesJsonArray.put(jsonObject);

										// /*array�����SharedPreferences*/

										nursesStr = nursesJsonArray.toString();

										editor = infoSharedPreferences.edit();
										editor.putString("NursesInfo",
												nursesStr);
										editor.commit();
										Log.i("����ע��Str", nursesStr);
										Log.i("����ע��SP", infoSharedPreferences
												.getString("NursesInfo",
														"Nothing Doh!l"));
										if (mListItemNurses.get(0)
												.get("ItemTitle")
												.equals("������ϵ��")) {
											mListItemNurses.remove(0);
										}
										HashMap<String, Object> map_nurses = new HashMap<String, Object>();
										map_nurses.put("ItemImage",
												R.drawable.choose);// ����ͼƬ
										map_nurses.put("ItemTitle", NurseName);
										map_nurses.put("ItemText", NursePhone);
										mListItemNurses.add(map_nurses);
										mSimpleAdapter_Nurses
												.notifyDataSetChanged();
									} catch (JSONException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

								}
							}).show();

			break;

		default:
			break;
		}
	}

	private void refresh() {
		finish();
		Intent intent = new Intent(info.this, info.class);
		startActivity(intent);
	}

	public void spclear() {
		SharedPreferences.Editor editor = infoSharedPreferences.edit();
		editor.clear();
		editor.commit();
	}

}
