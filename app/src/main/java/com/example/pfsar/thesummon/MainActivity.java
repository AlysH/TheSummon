package com.example.pfsar.thesummon;

import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import static android.nfc.NfcAdapter.FLAG_READER_NFC_A;
import static android.nfc.NfcAdapter.FLAG_READER_NFC_B;
import static android.nfc.NfcAdapter.FLAG_READER_NFC_F;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "NfcDemo";

    private TextView mTextView;
    private NfcAdapter mNfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        mTextView = (TextView) findViewById(R.id.Text_View);
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        mNfcAdapter.enableReaderMode(this, new NfcAdapter.ReaderCallback() {
            @Override
            public void onTagDiscovered(Tag tag) {
                Toast.makeText(MainActivity.this, "TAG received", Toast.LENGTH_SHORT).show();
            }
        },FLAG_READER_NFC_A|FLAG_READER_NFC_B|FLAG_READER_NFC_F,
                new Bundle());
        mTextView.setText(R.string.explanation);

        if (mNfcAdapter == null) {
            Toast.makeText(this,"This device does not support NFC", Toast.LENGTH_LONG).show();
            return;
        }

        if(!mNfcAdapter.isEnabled()) {
            mTextView.setText("NFC is disabled.");
        } else {

        }

        handleIntent(getIntent());
    }



    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(intent.getAction())) {
            Parcelable[] rawMessages =
                    intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
            if (rawMessages != null) {
                NdefMessage[] messages = new NdefMessage[rawMessages.length];
                for (int i = 0; i < rawMessages.length; i++) {
                    messages[i] = (NdefMessage) rawMessages[i];
                }
                // Process the messages array.
            }
        }
    }

    private void handleIntent(Intent intent) {
        if (intent != null)
            mTextView.setText("NFCTag recveived");
    }
}