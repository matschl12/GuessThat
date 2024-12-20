package com.example.guessthat.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.guessthat.QuizViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun SelectiveQuiz(innerPadding: PaddingValues, viewModel: QuizViewModel){
    var pressedButton by remember { mutableStateOf(false) }
    var changeQuestionButtonVisibility by remember { mutableStateOf(false) }
    val button1Color by viewModel.button1color.collectAsState()
    val button2Color by viewModel.button2color.collectAsState()
    val button3Color by viewModel.button3color.collectAsState()
    val button4Color by viewModel.button4color.collectAsState()

        Column(modifier = Modifier
            .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Spacer(modifier = Modifier.height(40.dp))
            Column {
                Text(text = "Score: " + viewModel.score,  fontSize = 25.sp)
            }
            Column {
                Text(text = "Question " + viewModel.questionNumText + "/8", fontSize = 25.sp)
            }
            Spacer(modifier = Modifier.height(40.dp))
            Column {
                Text(text = viewModel.question)
            }
            Spacer(modifier = Modifier.height(40.dp))
            Column{
                Row{
                    Button(onClick = {
                        viewModel.validateAnswer(1)
                        pressedButton = true
                        changeQuestionButtonVisibility = true
                    }, enabled = !pressedButton , colors = ButtonDefaults.buttonColors(disabledContainerColor = button1Color)) {
                        Text(text = viewModel.answer1)
                    }
                    Button(onClick = {
                        viewModel.validateAnswer(2)
                        pressedButton = true
                        changeQuestionButtonVisibility = true
                    }, enabled = !pressedButton, colors = ButtonDefaults.buttonColors(disabledContainerColor = button2Color)) {
                        Text(text = viewModel.answer2)
                    }
                }
                Row{
                    Button(onClick = {
                        viewModel.validateAnswer(3)
                        pressedButton = true
                        changeQuestionButtonVisibility = true
                    }, enabled = !pressedButton, colors = ButtonDefaults.buttonColors(disabledContainerColor = button3Color)) {
                        Text(text = viewModel.answer3)
                    }
                    Button(onClick = {
                        viewModel.validateAnswer(4)
                        pressedButton = true
                        changeQuestionButtonVisibility = true
                    }, enabled = !pressedButton, colors = ButtonDefaults.buttonColors(disabledContainerColor = button4Color)) {
                        Text(text = viewModel.answer4)
                    }
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            Row{
                if(changeQuestionButtonVisibility && viewModel.questionNum != 7)
                {
                    Button(onClick = {
                        viewModel.nextQuestion()
                        pressedButton = false
                        changeQuestionButtonVisibility = false
                    }) {
                        Text(text = "Next Question")
                    }
                }
                if(changeQuestionButtonVisibility && viewModel.questionNum == 7)
                {
                    Button(onClick = {
                        viewModel.startQuiz()
                        pressedButton = false
                        changeQuestionButtonVisibility = false
                    }) {
                        Text(text = "Restart Quiz")
                    }
                }
            }
            //ProgressTimer()
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
