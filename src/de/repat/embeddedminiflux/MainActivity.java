package de.repat.embeddedminiflux;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MainActivity extends Activity {

	private SharedPreferences prefs = null;
	private WebView webview = null;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		webview = (WebView) findViewById(R.id.webView);

		CookieSyncManager.createInstance(getBaseContext());
		CookieSyncManager.getInstance().startSync();

		WebSettings webSettings = webview.getSettings();
		webSettings.setJavaScriptEnabled(true);

		webview.setWebViewClient(new WebViewClient() {
			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Toast.makeText(MainActivity.this, "Oups", Toast.LENGTH_SHORT)
						.show();
			}

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}

			public void onPageFinished(WebView view, String url) {
				CookieSyncManager.getInstance().sync();
			}
		});

		prefs = getSharedPreferences("de.repat.embeddedminiflux", MODE_PRIVATE);
	}

	@Override
	protected void onResume() {
		super.onResume();

		if (prefs.getBoolean("firstrun", true)) {
			AlertDialog.Builder alert = new AlertDialog.Builder(this);

			alert.setTitle("Miniflux URL");
			alert.setMessage("Please enter your Miniflux URL");

			final EditText input = new EditText(this);
			input.setInputType(InputType.TYPE_TEXT_VARIATION_URI);
			alert.setView(input);

			alert.setPositiveButton("Ok",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							String minifluxURL = input.getText().toString();
							prefs.edit().putString("minifluxURL", minifluxURL)
									.commit();
							prefs.edit().putBoolean("firstrun", false).commit();

							webview.loadUrl(minifluxURL);
						}
					});

			alert.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							prefs.edit().putBoolean("firstrun", true).commit();
						}
					});

			alert.show();
		} else {
			String url = prefs.getString("minifluxURL", "");
			webview.loadUrl(url);
		}
	}
}
