package com.janni.botlabs.jananiseva;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.DataSetObserver;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class ChatBot extends AppCompatActivity {


    private static final String TAG = "ChatActivity";
    private static final String ChatBotUrl = "http://ritwik-api.mybluemix.net/jananiconversation";


    private ChatArrayAdapter chatArrayAdapter;
    private ImageView sendButton,mic;
    private EditText chatText;
    private ListView messageListView;
    private boolean side = true;
    final int REQ_CODE_SPEECH_INPUT=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_chat_bot);

        getWindow().setBackgroundDrawableResource(R.drawable.chatbotback);

        mic =(ImageView)findViewById(R.id.mic);
        chatText = (EditText) findViewById(R.id.chatText);
        sendButton = (ImageView) findViewById(R.id.sendButton);
        messageListView = (ListView) findViewById(R.id.messageListView);

        chatArrayAdapter = new ChatArrayAdapter(getApplicationContext(), R.layout.right);
        messageListView.setAdapter(chatArrayAdapter);

        chatText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(chatText.getText().toString().length()>0){
                    mic.setVisibility(View.GONE);
                    sendButton.setVisibility(View.VISIBLE);
                }
                else{
                    mic.setVisibility(View.VISIBLE);
                    sendButton.setVisibility(View.GONE);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(chatText.getText().toString().length()>0){
                    mic.setVisibility(View.GONE);
                    sendButton.setVisibility(View.VISIBLE);
                }
                else{
                    mic.setVisibility(View.VISIBLE);
                    sendButton.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(chatText.getText().toString().length()>0){
                    mic.setVisibility(View.GONE);
                    sendButton.setVisibility(View.VISIBLE);
                }
                else{
                    mic.setVisibility(View.VISIBLE);
                    sendButton.setVisibility(View.GONE);
                }
            }

        });

        chatText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    return sendChatMessageToTheScreen();
                }
                return false;
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(chatText.getText().toString().length()>0) {
                    sendChatMessageToTheScreen();
                }
            }
        });

        messageListView.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        messageListView.setAdapter(chatArrayAdapter);


        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });

        //to scroll the list view to bottom on data change
        chatArrayAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                messageListView.setSelection(chatArrayAdapter.getCount() - 1);
            }
        });

    }

    private boolean sendChatMessageToTheScreen() {
        chatArrayAdapter.add(new ChatMessage(side, chatText.getText().toString()));
        String data = chatText.getText().toString().trim();
        data = data.replaceAll(" ","%20");
        String url = ChatBotUrl + data;
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest request = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject baseJsonResponse) {
                        if (null != baseJsonResponse) {
                            try {
                                String response = baseJsonResponse.getString("response");
                                sendChatMessageFromTheCall(response);
                                //handle your response
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);

        chatText.setText("");
        return true;
    }





    private boolean sendChatMessageFromTheCall(String reply) {
        chatArrayAdapter.add(new ChatMessage(!side,reply));
        return true;
    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speak Up");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),"speech_not_supported",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if ((resultCode == RESULT_OK) && (null != data)) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    chatText.setText(result.get(0));
                    if(chatText.getText().toString().length()>0){
                        sendChatMessageToTheScreen();
                        chatText.setText("");
                    }
                }
                break;

            }
        }

    }


}
