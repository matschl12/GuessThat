package com.example.guessthat.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.guessthat.QuizViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun SelectiveQuiz(innerPadding: PaddingValues, viewModel: QuizViewModel){
    Column(modifier = Modifier
        .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(40.dp))
        Column {
            Button(onClick = { viewModel.changeQuestion() }) {
                Text(text = "Start", fontSize = 25.sp)
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Column {
            Text(text = "Score", fontSize = 25.sp)
        }
        Spacer(modifier = Modifier.height(40.dp))
        Column {
            Text(text = viewModel.question)
        }
        Spacer(modifier = Modifier.height(40.dp))
        Column{
            Row{
                Button(onClick = { /*TODO*/ }) {
                    Text(text = viewModel.answer1)
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = viewModel.answer2)
                }
            }
            Row{
                Button(onClick = { /*TODO*/ }) {
                    Text(text = viewModel.answer3)
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = viewModel.answer4)
                }
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        ProgressTimer()
    }
}

@Composable
fun KeyboardQuiz(innerPadding: PaddingValues){
    var input by remember { mutableStateOf("") }
    Column(modifier = Modifier
        .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Spacer(modifier = Modifier.height(40.dp))
        Column { 
            Text(text = "Question")
      }
        Spacer(modifier = Modifier.height(40.dp))
        Column {
            Row {
                TextField(value = input, onValueChange = {input = it} )
            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .align(Alignment.CenterHorizontally)) {
                Text(text = "Submit")
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        ProgressTimer()

    }
    
}

@Preview
@Composable
fun SelectivePreview(){
    //SelectiveQuiz()
}

@Composable
fun ProgressTimer() {
    var currentProgress by remember { mutableStateOf(0f) }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            loading = true
            scope.launch {
                loadProgress { progress ->
                    currentProgress = progress
                }
                loading = false
            }
        }, enabled = !loading) {
            Text("Start Loading")
        }

        if (loading) {
            LinearProgressIndicator(progress = {currentProgress}, modifier = Modifier.fillMaxWidth())
        }
    }

}

suspend fun loadProgress(updateProgress: (Float) -> Unit ){
    for (i in 1..100){
        updateProgress(i.toFloat() / 100)
        delay(80)
    }
}