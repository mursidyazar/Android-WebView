package org.kod5.android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

@SuppressLint({ "NewApi", "ShowToast" })
public class MainActivity extends Activity {

	//Spinner içerisine koyaca€›m›z verileri tan›ml›yoruz.
	private String[] iller={"‹STANBUL","ANKARA"};
	private String[] ilceler0={"ADALAR","ARNAVUTKÖY","ATAﬁEH‹R","AVCILAR","BA⁄CILAR","BAHÇEL‹EVLER","BAKIRKÖY","BAﬁAKﬁEH‹R","BAYRAMPAﬁA","BEﬁ‹KTAﬁ","BEYL‹KDÜZÜ","BEYO⁄LU","BÜYÜKÇEKMECE","BEYKOZ","ÇATALCA","ÇEKMEKÖY","ESENLER","ESENYURT","EYÜP","FAT‹H","GAZ‹OSMANPAﬁA","GÜNGÖREN","KADIKÖY","KA⁄ITHANE","KARTAL","KÜÇÜKÇEKMECE","MALTEPE","PEND‹K","SANCAKTEPE","SARIYER","S‹L‹VR‹","SULTANBEYL‹","SULTANGAZ‹","ﬁ‹LE","ﬁ‹ﬁL‹","TUZLA","ÜSKÜDAR","ÜMRAN‹YE","ZEYT‹NBURNU"};
	private String[] ilceler1={"AKYURT","ALTINDA⁄","AYAﬁ","BALA","BEYPAZARI","ÇAMLIDERE","ÇANKAYA","ÇUBUK","ELMADA⁄","ET‹MESGUT","EVREN","GÖLBAﬁI","GÜDÜL","HAYMANA","KALEC‹K","KAZAN","KEÇ‹ÖREN","KIZILCAHAMAM","MAMAK","NALLIHAN","POLATLI","PURSAKLAR","S‹NCAN","ﬁEREFL‹KOÇH‹SAR","YEN‹MAHALLE"};
	
	//Spinner'lar› ve Adapter'lerini tan›ml›yoruz.
	private Spinner spinnerIller;
	private Spinner spinnerIlceler;
	private ArrayAdapter<String> dataAdapterForIller; 
	private ArrayAdapter<String> dataAdapterForIlceler;
	
	
	@Override // Bu metod uygulama aç›ld›€›nda çal›ﬂt›r›lan metod.
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//xml k›sm›nda haz›rlad›€›m›z spinnerlar› burda tan›mlad›klar›m›zla eﬂleﬂtiriyoruz.
		spinnerIller = (Spinner) findViewById(R.id.spinner1);
		spinnerIlceler = (Spinner) findViewById(R.id.spinner2);
		 
        //Spinner'lar için adapterleri haz›rl›yoruz. 
        dataAdapterForIller = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, iller);
        dataAdapterForIlceler = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ilceler0);
        
        //Listelenecek verilerin görünümünü belirliyoruz.
        dataAdapterForIller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForIlceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 
        //Haz›rlad›€›m›z Adapter'leri Spinner'lara ekliyoruz.
        spinnerIller.setAdapter(dataAdapterForIller);
        spinnerIlceler.setAdapter(dataAdapterForIlceler);
        
        // Listelerden bir eleman seçildi€inde yap›lacaklar› tan›ml›yoruz.
		spinnerIller.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				//Hangi il seçilmiﬂse onun ilçeleri adapter'e ekleniyor.
				if(parent.getSelectedItem().toString().equals(iller[0])) 
					dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,ilceler0);
				else if(parent.getSelectedItem().toString().equals(iller[1]))
					dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,ilceler1);
				
				dataAdapterForIlceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinnerIlceler.setAdapter(dataAdapterForIlceler);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
		
		spinnerIlceler.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent, View view,
							int position, long id) {
						//Seçilen il ve ilçeyi ekranda gösteriyoruz.
						Toast.makeText(getBaseContext(), ""+spinnerIller.getSelectedItem().toString()+"\n"+parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
					}
				});
	}

	
}
