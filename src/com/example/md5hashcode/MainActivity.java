package com.example.md5hashcode;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
     
	Button btnHashCode;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
}
	
	public void onClick(View v) {
			EditText etHashCode = (EditText) findViewById(R.id.etHashCode);
			String mypassword = etHashCode.getText().toString();
			String securepassword = md5(mypassword);
			TextView tvHashCode = (TextView) findViewById(R.id.tvHashCode);
			tvHashCode.setText("hashCode: " + securepassword);
	}
	
	private String md5(String in) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.reset();
			digest.update(in.getBytes());
			byte[] a = digest.digest();
			StringBuilder sb = new StringBuilder(a.length << 1);
			for (int i = 0; i < a.length; i++) {
				sb.append(Character.forDigit((a[i] & 0xf0) >> 4, 16));
				sb.append(Character.forDigit(a[i] & 0x0f, 16));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
