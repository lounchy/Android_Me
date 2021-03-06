/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    // TODO (1) Create a layout file that displays one body part image named fragment_body_part.xml
        // This layout should contain a single ImageView

    // TODO (2) Create a new class called BodyPartFragment to display an image of an Android-Me body part
        // In this class, you'll need to implement an empty constructor and the onCreateView method
        // TODO (3) Show the first image in the list of head images
            // Soon, you'll update this image display code to show any image you want



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);



        // TODO (5) Create a new BodyPartFragment instance and display it using the FragmentManager
        if (savedInstanceState == null){

            Bundle b = getIntent().getExtras();
            int headIndex = b.getInt("headIndex");
            int bodyIndex = b.getInt("bodyIndex");
            int legIndex = b.getInt("legIndex");

            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setImageIds(AndroidImageAssets.getHeads());
            headFragment.setListIndex(headIndex);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();

            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setImageIds(AndroidImageAssets.getBodies());
            bodyFragment.setListIndex(bodyIndex);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit();

            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setImageIds(AndroidImageAssets.getLegs());
            legFragment.setListIndex(legIndex);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }

    }
}
