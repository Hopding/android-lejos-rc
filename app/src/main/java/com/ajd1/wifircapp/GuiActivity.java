package com.ajd1.wifircapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import bluetoothapp.ajd2.com.wifirc.R;


public class GuiActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String IP = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        setContentView(R.layout.activity_gui);

        final WifiRCClient wifiRcClient = new WifiRCClient(IP, 9999);

        final Button forwardButton = (Button) findViewById(R.id.forward_button);
        forwardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new WiFiComm(wifiRcClient, "FORWARD").execute();
            }
        });

        final Button reverseButton = (Button) findViewById(R.id.reverse_button);
        reverseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new WiFiComm(wifiRcClient, "REVERSE").execute();
            }
        });

        final Button stopButton = (Button) findViewById(R.id.stop_button);
        stopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new WiFiComm(wifiRcClient, "STOP").execute();
            }
        });

        final Button rightButton = (Button) findViewById(R.id.right_button);
        rightButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new WiFiComm(wifiRcClient, "RIGHT").execute();
            }
        });

        final Button leftButton = (Button) findViewById(R.id.left_button);
        leftButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new WiFiComm(wifiRcClient, "LEFT").execute();
            }
        });

        final Button exitButton = (Button) findViewById(R.id.exit_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new WiFiComm(wifiRcClient, "EXIT").execute();
            }
        });

        final Button honkButton = (Button) findViewById(R.id.honk_button);
        honkButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new WiFiComm(wifiRcClient, "HONK").execute();
            }
        });

        final Button fireButton = (Button) findViewById(R.id.fire_button);
        fireButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    new WiFiComm(wifiRcClient, "FIRE").execute();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    new WiFiComm(wifiRcClient, "STOPFIRE").execute();
                }
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gui, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class WiFiComm extends AsyncTask<String, String, Void> {
        WifiRCClient wifiClient;
        String direction;
        public WiFiComm (WifiRCClient wifiRCClient, String command) {
            wifiClient = wifiRCClient;
            direction = command;
        }

        @Override
        protected Void doInBackground(String... params) {
            if (direction == "FORWARD") {
                try {
                    wifiClient.WifiForward();
                } catch (IOException e) {
                    Log.i("WIFIAPPMESSAGE", "Problem sending message" + e.getMessage());
                }
            }

            if (direction == "REVERSE") {
                try {
                    wifiClient.WifiReverse();
                } catch (IOException e) {
                    Log.i("WIFIAPPMESSAGE", "Problem sending message" + e.getMessage());
                }
            }

            if (direction == "STOP") {
                try {
                    wifiClient.WifiStop();
                } catch (IOException e) {
                    Log.i("WIFIAPPMESSAGE", "Problem sending message" + e.getMessage());
                }
            }

            if (direction == "RIGHT") {
                try {
                    wifiClient.WifiRight();
                } catch (IOException e) {
                    Log.i("WIFIAPPMESSAGE", "Problem sending message" + e.getMessage());
                }
            }

            if (direction == "LEFT") {
                try {
                    wifiClient.WifiLeft();
                } catch (IOException e) {
                    Log.i("WIFIAPPMESSAGE", "Problem sending message" + e.getMessage());
                }
            }

            if (direction == "EXIT") {
                try {
                    wifiClient.WifiExit();
                } catch (IOException e) {
                    Log.i("WIFIAPPMESSAGE", "Problem sending message" + e.getMessage());
                }
            }

            if (direction == "HONK") {
                try {
                    wifiClient.WifiHonk();
                } catch (IOException e) {
                    Log.i("WIFIAPPMESSAGE", "Problem sending message" + e.getMessage());
                }
            }

            if (direction == "FIRE") {
                try {
                    wifiClient.WifiFire();
                } catch (IOException e) {
                    Log.i("WIFIAPPMESSAGE", "Problem sending message" + e.getMessage());
                }
            }

            if (direction == "STOPFIRE") {
                try {
                    wifiClient.WifiStopFire();
                } catch (IOException e) {
                    Log.i("WIFIAPPMESSAGE", "Problem sending message" + e.getMessage());
                }
            }
            return null;
        }

    }
}

