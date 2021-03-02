/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme() {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val list = listOf(
        Pet(name = "labrador"),
        Pet(name = "rotweiler"),
        Pet(name = "great dane"),
        Pet(name = "labrador"),
        Pet(name = "labrador"),
        Pet(name = "labrador"),
    )
    Surface(color = MaterialTheme.colors.background) {
        Column {
            Text(
                text = "Doggos",
                style = typography.h1,
                modifier = Modifier.padding(top = 16.dp, start = 16.dp)
            )
            Spacer(modifier = Modifier.padding(16.dp))
            DoggoList(list)
        }
    }
}

//@Preview("Light Theme", widthDp = 360, heightDp = 360)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}


@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

@Composable
fun DoggoList(doggos: List<Pet> = emptyList()) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        items(doggos) { doggo ->
            ListItem(doggo)
        }
    }
}

//@Preview("Light Theme", widthDp = 360, heightDp = 400)
@Composable
fun ListItem(pet: Pet = Pet(name = "Labrador")) {
    Card(
        shape = RoundedCornerShape(10),
        border = BorderStroke(2.dp, MaterialTheme.colors.secondary),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.sample_doggo),
                contentDescription = null
            )
            Text(
                text = pet.name,
                style = typography.h1,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}