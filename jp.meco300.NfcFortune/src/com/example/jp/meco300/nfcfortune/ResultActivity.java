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
		
		//‰æ–Ê‚É•\¦‚·‚éƒRƒ“ƒ|[ƒlƒ“ƒg
		TextView text = (TextView)findViewById(R.id.textview01_id);
		ImageView image = (ImageView)findViewById(R.id.imageview01_id);

		Intent intent = getIntent();
		
		//NFC‚ÌId‚Æ“ú•t‚ğ‚±‚Ë‚±‚Ë‚µ‚Ä—”‚Û‚¢‚Ì‚ğ‚Â‚­‚é
		int[] idIntList = intent.getIntArrayExtra("idIntList");
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
		int fortuneNum = Integer.parseInt(sdf.format(date));
		
		for(int id : idIntList){
			fortuneNum += id;
		}
		
		//Š„‚èØ‚ê‚½‚Æ‚±‚ª¡“ú‚Ì‰^¨
		String fortune = "‰^¨";
		if(fortuneNum % 5 == 0 ){
			fortune = "‘å‹g";
			image.setImageResource(R.drawable.daikichi);
			
		}else if(fortuneNum % 4 == 0 ){
			fortune = "¬‹g";
			image.setImageResource(R.drawable.syokichi);

		}else if(fortuneNum % 3 == 0 ){
			fortune = "––‹g";
			image.setImageResource(R.drawable.suekichi);

		}else if(fortuneNum % 2 == 0 ){
			fortune = "’†‹g";
			image.setImageResource(R.drawable.chuukichi);

		}else if(fortuneNum % 6 == 0 ){
			fortune = "‹¥";
			image.setImageResource(R.drawable.kyo);

		}else{
			fortune = "–¢’m”";
			image.setImageResource(R.drawable.michisu);
			
		}
		Toast.makeText(getApplicationContext(), "¡“ú‚Ì‰^¨‚Í" + fortune + "‚Å‚·I", Toast.LENGTH_SHORT).show();
	}
}