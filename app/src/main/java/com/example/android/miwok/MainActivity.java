/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //create link from numbers TextView and local variable
        TextView numbers_textView = (TextView) findViewById(R.id.numbers);

        //set onclick listener to numbers_textView
        numbers_textView.setOnClickListener(new View.OnClickListener() {
            //Override onClick to run Numbers Class
            @Override
            public void onClick(View v) {
                Intent numbers_Intent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbers_Intent);
            }
        });

        //create link from colors TextView and local variable
        TextView colors_textView = (TextView) findViewById(R.id.colors);

        //set onclick listener to colors_textView
        colors_textView.setOnClickListener(new View.OnClickListener() {
            //Override onClick to run Colors Class
            @Override
            public void onClick(View v) {
                Intent colors_Intent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(colors_Intent);
            }
        });

        //create link from family TextView and local variable
        TextView family_textView = (TextView) findViewById(R.id.family);

        //set onclick listener to family_textView
        family_textView.setOnClickListener(new View.OnClickListener() {
            //Override onClick to run family Class
            @Override
            public void onClick(View v) {
                Intent family_Intent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(family_Intent);
            }
        });

        //create link from phrases TextView and local variable
        final TextView phrases_textView = (TextView) findViewById(R.id.phrases);

        //set onclick listener to phrases_textView
        phrases_textView.setOnClickListener(new View.OnClickListener() {
            //Override onClick to run phrases Class
            @Override
            public void onClick(View v) {
                Intent phrases_Intent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(phrases_Intent);
            }
        });
    }
}