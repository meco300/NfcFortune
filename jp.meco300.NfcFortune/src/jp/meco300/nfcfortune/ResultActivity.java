package jp.meco300.nfcfortune;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.jp.meco300.nfcfortune.R;

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
		
		//画面に表示するコンポーネント
		TextView text = (TextView)findViewById(R.id.textview01_id);
		ImageView image = (ImageView)findViewById(R.id.imageview01_id);

		Intent intent = getIntent();
		
		//NFCのIdと日付をこねこねして乱数ぽいのをつくる
		int[] idIntList = intent.getIntArrayExtra("idIntList");
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
		int fortuneNum = Integer.parseInt(sdf.format(date));
		
		for(int id : idIntList){
			fortuneNum += id;
		}
		
		//割り切れたとこが今日の運勢
		String fortune = "運勢";
		if(fortuneNum % 5 == 0 ){
			fortune = "大吉";
			image.setImageResource(R.drawable.daikichi);
			
		}else if(fortuneNum % 4 == 0 ){
			fortune = "小吉";
			image.setImageResource(R.drawable.syokichi);

		}else if(fortuneNum % 3 == 0 ){
			fortune = "末吉";
			image.setImageResource(R.drawable.suekichi);

		}else if(fortuneNum % 2 == 0 ){
			fortune = "中吉";
			image.setImageResource(R.drawable.chuukichi);

		}else if(fortuneNum % 6 == 0 ){
			fortune = "凶";
			image.setImageResource(R.drawable.kyo);

		}else{
			fortune = "未知数";
			image.setImageResource(R.drawable.michisu);
			
		}
		Toast.makeText(getApplicationContext(), "今日の運勢は" + fortune + "です！", Toast.LENGTH_SHORT).show();
	}
}