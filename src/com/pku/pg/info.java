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
//		// jsonObject.put("RelativeName", "张思博" + i);
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
//		userName.setText(infoSharedPreferences.getString("UserName", "数据尚未写入"));
//		userPhone.setText(infoSharedPreferences
//				.getString("UserPhone", "数据尚未写入"));
//		userHospital.setText(infoSharedPreferences.getString("Hospital",
//				"数据尚未写入"));
//
//		spclear();
//
//		// showAddDialog();
//
//		// /* 护工 *********************************************************** */
//		mListviewNurses = (ListViewForScrollView) findViewById(R.id.info_list_Nurses); /* 定义一个动态数组 */
//		// mListItemNurses = new ArrayList<HashMap<String, Object>>(); /*
//		// 在数组中存放数据 */
//		// for (int i = 0; i < 10; i++) {
//		// HashMap<String, Object> map_nurses = new HashMap<String, Object>();
//		// map_nurses.put("ItemImage", R.drawable.choose);// 加入图片
//		// map_nurses.put("ItemTitle", "姓名" + i);
//		// map_nurses.put("ItemText", "手机号" + i);
//		// mListItemNurses.add(map_nurses);
//		// }
//		// // mListItemNurses.remove(index);
//
//		// mSimpleAdapter_Nurses = new SimpleAdapter(this,
//		// mListItemNurses, R.layout.list_nurses, new String[] {
//		// "ItemImage", "ItemTitle", "ItemText" }, new int[] {
//		// R.id.list_imgbtn_Nurse, R.id.list_title_Nurse,
//		// R.id.list_info_Nurse }); // 数据绑定
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
//		mListItemNurses = new ArrayList<HashMap<String, Object>>(); /* 在数组中存放数据 */
//		if (aa.equals("")) {
//			// final JSONObject jsonObject01 = null;
//			JSONObject jsonObject01 =  new JSONObject();
//			// NurseName = "尚无联系人";
//			// NursePhone = "尚未添加信息";
//			try {
//				
//				jsonObject01.put("NurseName", "可添加联系人");
//				jsonObject01.put("NursePhone", "可添加联系方式");
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
//			map_nurses.put("ItemImage", R.drawable.choose);// 加入图片
//			map_nurses.put("ItemTitle", NurseName);
//			map_nurses.put("ItemText", NursePhone);
//			mListItemNurses.add(map_nurses);
//			Log.e("====", "NurseName:" + NurseName + "NursePhon:" + NursePhone);
//		}
//		// mListItemNurses.remove(index);
//		mSimpleAdapter_Nurses = new SimpleAdapter(this, mListItemNurses,
//				R.layout.list_nurses, new String[] { "ItemImage", "ItemTitle",
//						"ItemText" }, new int[] { R.id.list_imgbtn_Nurse,
//						R.id.list_title_Nurse, R.id.list_info_Nurse }); // 数据绑定
//		mListviewNurses.setAdapter(mSimpleAdapter_Nurses);
//		/* end */
//
//		mListviewNurses.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//					long arg3) {
//				// TODO Auto-generated method stub
//				setTitle("你选择了护理人员" + arg2);// 设置标题栏显示点击的行
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
//		// /* 亲属 ************************************************************ */
//		// mListviewRelatives = (ListViewForScrollView)
//		// findViewById(R.id.info_list_Relative); /* 定义一个动态数组 */
//		// mListItemRelative = new ArrayList<HashMap<String, Object>>(); /*
//		// 在数组中存放数据 */
//		// for (int i = 0; i < 3; i++) {
//		// HashMap<String, Object> map_relatives = new HashMap<String, Object>();
//		// map_relatives.put("ItemImage", R.drawable.choose);// 加入图片
//		// map_relatives.put("ItemTitle", "姓名" + i);
//		// map_relatives.put("ItemText", "手机号" + i);
//		// mListItemRelative.add(map_relatives);
//		// }
//		// SimpleAdapter mSimpleAdapter_Relatives = new SimpleAdapter(this,
//		// mListItemRelative, R.layout.list_relatives, new String[] {
//		// "ItemImage", "ItemTitle", "ItemText" }, new int[] {
//		// R.id.list_imgbtn_Relative, R.id.list_title_Relative,
//		// R.id.list_info_Relative }); // 数据绑定
//		//
//		// mListviewRelatives.setAdapter(mSimpleAdapter_Relatives);
//		//
//		// mListviewRelatives.setOnItemClickListener(new OnItemClickListener() {
//		//
//		// @Override
//		// public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//		// long arg3) {
//		// // TODO Auto-generated method stub
//		// setTitle("你选择了亲友:" + arg2);// 设置标题栏显示点击的行
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
//			// ========================================================================用户注册
//			// 弹出对话框
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
//					.setTitle("请填写注册信息")
//					.setView(layout_UserReg)
//					.setPositiveButton("确定",
//							new DialogInterface.OnClickListener() {
//
//								@Override
//								public void onClick(DialogInterface dialog,
//										int which) {
//									// TODO Auto-generated method stub
//									// 保存进SharedPreferences
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
//							}).setNegativeButton("取消", null).show();
//
//			break;
//		case R.id.info_imageview_AddNurses:
//			// ======================================================================
//			// 护工注册
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
//					.setTitle("请填写注册信息")
//					.setView(layout_NurseReg)
//					.setNegativeButton("取消", null)
//					.setPositiveButton("确定",
//							new DialogInterface.OnClickListener() {
//
//								private JSONArray jsonArray;
//								private JSONObject jsonObject;
//
//								@Override
//								public void onClick(DialogInterface dialog,
//										int which) {
//									// TODO Auto-generated method stub
//									/* 保存进Json */
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
//										Log.d("jsonObject写入", regNurseName
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
//									// // /*array保存进SharedPreferences*/
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
//									Log.i("护工注册arrstr", jsonArrayStr);
//									Log.i("护工注册infor", infoNurseReg);
//									Log.i("护工注册sp", infoSharedPreferences
//											.getString("NursesInfo",
//													"Nothing Doh!l"));
//									/* 在listview中显示数据 */
//
//									// mListItemNurses = new
//									// ArrayList<HashMap<String, Object>>(); /*
//									// 在数组中存放数据 */
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
//									// R.drawable.choose);// 加入图片
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
//									// R.id.list_info_Nurse }); // 数据绑定
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

		userName.setText(infoSharedPreferences.getString("UserName", "数据尚未写入"));
		userPhone.setText(infoSharedPreferences
				.getString("UserPhone", "数据尚未写入"));
		userHospital.setText(infoSharedPreferences.getString("Hospital",
				"数据尚未写入"));

		// /* 护工 *********************************************************** */
		mListviewNurses = (ListViewForScrollView) findViewById(R.id.info_list_Nurses); /* 定义一个动态数组 */

		nursesStr = infoSharedPreferences.getString("NursesInfo", "");

		mListItemNurses = new ArrayList<HashMap<String, Object>>(); /* 在数组中存放数据 */
		if (nursesStr.equals("")) {
			NurseName = "尚无联系人";
			NursePhone = "尚未添加信息";
			HashMap<String, Object> map_nurses = new HashMap<String, Object>();
			map_nurses.put("ItemImage", R.drawable.choose);// 加入图片
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
					map_nurses.put("ItemImage", R.drawable.choose);// 加入图片
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
						R.id.list_title_Nurse, R.id.list_info_Nurse }); // 数据绑定
		mListviewNurses.setAdapter(mSimpleAdapter_Nurses);
		/* end */

		mListviewNurses.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				setTitle("你选择了护理人员" + arg2);// 设置标题栏显示点击的行
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
								.setTitle("确认删除?")
								.setPositiveButton("确定",
										new DialogInterface.OnClickListener() {

											@Override
											public void onClick(
													DialogInterface dialog,
													int which) {
												// TODO Auto-generated method
												// stub
												// 保存进SharedPreferences
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
										}).setNegativeButton("取消", null).show();

						return false;
					}
				});

		// /* 亲属 ************************************************************ */
		// mListviewRelatives = (ListViewForScrollView)
		// findViewById(R.id.info_list_Relative); /* 定义一个动态数组 */
		// mListItemRelative = new ArrayList<HashMap<String, Object>>(); /*
		// 在数组中存放数据 */
		// for (int i = 0; i < 3; i++) {
		// HashMap<String, Object> map_relatives = new HashMap<String, Object>();
		// map_relatives.put("ItemImage", R.drawable.choose);// 加入图片
		// map_relatives.put("ItemTitle", "姓名" + i);
		// map_relatives.put("ItemText", "手机号" + i);
		// mListItemRelative.add(map_relatives);
		// }
		// SimpleAdapter mSimpleAdapter_Relatives = new SimpleAdapter(this,
		// mListItemRelative, R.layout.list_relatives, new String[] {
		// "ItemImage", "ItemTitle", "ItemText" }, new int[] {
		// R.id.list_imgbtn_Relative, R.id.list_title_Relative,
		// R.id.list_info_Relative }); // 数据绑定
		//
		// mListviewRelatives.setAdapter(mSimpleAdapter_Relatives);
		//
		// mListviewRelatives.setOnItemClickListener(new OnItemClickListener() {
		//
		// @Override
		// public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
		// long arg3) {
		// // TODO Auto-generated method stub
		// setTitle("你选择了亲友:" + arg2);// 设置标题栏显示点击的行
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
			// ========================================================================用户注册
			// 弹出对话框
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
							}).setNegativeButton("取消", null).show();

			break;
		case R.id.info_imageview_AddNurses:
			// ======================================================================
			// 护工注册
			LayoutInflater inflater_NurseReg = getLayoutInflater();
			View layout_NurseReg = inflater_NurseReg.inflate(
					R.layout.nurses_reg_dialog,
					(ViewGroup) findViewById(R.id.nurse_reg_v01));
			regNurseName = (EditText) layout_NurseReg
					.findViewById(R.id.reg_NurseName_EditText_name);
			regNursePhone = (EditText) layout_NurseReg
					.findViewById(R.id.reg_NursePhone_EditText_phone);

			new AlertDialog.Builder(this)
					.setTitle("请填写注册信息")
					.setView(layout_NurseReg)
					.setNegativeButton("取消", null)
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									/* 保存进Json */
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
										Log.d("jsonObject写入", regNurseName
												.getText().toString());
										/* JsonArray */
										if (nursesJsonArray == null) {
											nursesJsonArray = new JSONArray();
										}
										nursesJsonArray.put(jsonObject);

										// /*array保存进SharedPreferences*/

										nursesStr = nursesJsonArray.toString();

										editor = infoSharedPreferences.edit();
										editor.putString("NursesInfo",
												nursesStr);
										editor.commit();
										Log.i("护工注册Str", nursesStr);
										Log.i("护工注册SP", infoSharedPreferences
												.getString("NursesInfo",
														"Nothing Doh!l"));
										if (mListItemNurses.get(0)
												.get("ItemTitle")
												.equals("尚无联系人")) {
											mListItemNurses.remove(0);
										}
										HashMap<String, Object> map_nurses = new HashMap<String, Object>();
										map_nurses.put("ItemImage",
												R.drawable.choose);// 加入图片
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
