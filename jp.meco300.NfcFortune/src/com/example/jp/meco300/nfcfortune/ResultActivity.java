package com.example.jp.meco300.nfcfortune;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends Activity{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		//��ʂɕ\������R���|�[�l���g
		TextView text = (TextView)findViewById(R.id.textview01_id);
		ImageView image = (ImageView)findViewById(R.id.imageview01_id);

		Intent intent = getIntent();
		
		//NFC��Id�Ɠ��t�����˂��˂��ė����ۂ��̂�����
		int[] idIntList = intent.getIntArrayExtra("idIntList");
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
		int fortuneNum = Integer.parseInt(sdf.format(date));
		
		for(int id : idIntList){
			fortuneNum += id;
		}
		
		//����؂ꂽ�Ƃ��������̉^��
		String fortune = "�^��";
		if(fortuneNum % 5 == 0 ){
			fortune = "��g";
			image.setImageResource(R.drawable.daikichi);
			
		}else if(fortuneNum % 4 == 0 ){
			fortune = "���g";
			image.setImageResource(R.drawable.syokichi);

		}else if(fortuneNum % 3 == 0 ){
			fortune = "���g";
			image.setImageResource(R.drawable.suekichi);

		}else if(fortuneNum % 2 == 0 ){
			fortune = "���g";
			image.setImageResource(R.drawable.chuukichi);

		}else if(fortuneNum % 6 == 0 ){
			fortune = "��";
			image.setImageResource(R.drawable.kyo);

		}else{
			fortune = "���m��";
			image.setImageResource(R.drawable.michisu);
			
		}
		Toast.makeText(getApplicationContext(), "�����̉^����" + fortune + "�ł��I", Toast.LENGTH_SHORT).show();
	}
}