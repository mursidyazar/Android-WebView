package org.kod5.android;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends Activity {

	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) { // Bu metod uygulama
															// aç›ld›€›nda
															// çal›ﬂt›r›lan
															// metod.
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// webView'i tasar›mdakiyle ba€l›yoruz.
		webView = (WebView) findViewById(R.id.webView1);

		// webView'i JavaScript kodlar›n› çal›ﬂt›racak ﬂekilde set ediyoruz.
		webView.getSettings().setJavaScriptEnabled(true);

		// ‹ﬂlem yap›ld›€›n›n anlaﬂ›lmas› için ProgressDialog aç›yoruz.
		final ProgressDialog progressDialog = ProgressDialog.show(this, "KOD5",
				"Sayfa Yükleniyor...", true);
		
		webView.setWebViewClient(new WebViewClient() {

			// Sayfa Yüklenirken bir hata oluﬂursa kullan›c›y› uyar›yoruz.
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Toast.makeText(getApplicationContext(), "Sayfa Yüklenemedi!",
						Toast.LENGTH_SHORT).show();
			}

			// Sayfan›n yüklenme iﬂlemi bitti€inde progressDialog'u kapat›yoruz.
			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				if (progressDialog.isShowing())
					progressDialog.dismiss();
			}
		});

		//Web sayfam›z›n url'ini webView'e yüklüyoruz.
		webView.loadUrl("http://www.kod5.org");

	}
}
