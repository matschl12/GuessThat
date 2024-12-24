package com.example.guessthat.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
    var time by remember { mutableStateOf("") }
    var oldScore by remember { mutableStateOf(0) }
    val gameType by viewModel.gameType.collectAsState()
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
                        viewModel.validateAnswer(1, time.toFloat())
                        pressedButton = true
                        changeQuestionButtonVisibility = true
                    }, enabled = !pressedButton , colors = ButtonDefaults.buttonColors(disabledContainerColor = button1Color)) {
                        Text(text = viewModel.answer1)
                    }
                    Button(onClick = {
                        viewModel.validateAnswer(2, time.toFloat())
                        pressedButton = true
                        changeQuestionButtonVisibility = true
                    }, enabled = !pressedButton, colors = ButtonDefaults.buttonColors(disabledContainerColor = button2Color)) {
                        Text(text = viewModel.answer2)
                    }
                }
                Row{
                    Button(onClick = {
                        viewModel.validateAnswer(3, time.toFloat())
                        pressedButton = true
                        changeQuestionButtonVisibility = true
                    }, enabled = !pressedButton, colors = ButtonDefaults.buttonColors(disabledContainerColor = button3Color)) {
                        Text(text = viewModel.answer3)
                    }
                    Button(onClick = {
                        viewModel.validateAnswer(4, time.toFloat())
                        pressedButton = true
                        changeQuestionButtonVisibility = true
                    }, enabled = !pressedButton, colors = ButtonDefaults.buttonColors(disabledContainerColor = button4Color)) {
                        Text(text = viewModel.answer4)
                    }
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            Row{
                if ( time == "0.0" && viewModel.questionNum != 7)
                {
                    pressedButton = true
                    Button(onClick = {
                        viewModel.nextQuestion()
                        pressedButton = false
                        changeQuestionButtonVisibility = false
                        time = "1.0"
                        oldScore = viewModel.score
                    }) {
                        Text(text = "Next Question")
                    }
                }
                if(changeQuestionButtonVisibility && viewModel.questionNum != 7)
                {
                    pressedButton = true
                    Button(onClick = {
                        viewModel.nextQuestion()
                        pressedButton = false
                        changeQuestionButtonVisibility = false
                        time = "1.0"
                        oldScore = viewModel.score
                    }) {
                        Text(text = "Next Question")
                    }
                }
                if(time == "0.0" && viewModel.questionNum == 7)
                {
                    pressedButton = true
                    Button(onClick = {
                        viewModel.startQuiz(gameType)
                        pressedButton = false
                        changeQuestionButtonVisibility = false
                        time = "1.0"
                        oldScore = viewModel.score
                    }) {
                        Text(text = "Restart Quiz")
                    }
                }
                if(changeQuestionButtonVisibility && viewModel.questionNum == 7 )
                {
                    pressedButton = true
                    Button(onClick = {
                        viewModel.startQuiz(gameType)
                        pressedButton = false
                        changeQuestionButtonVisibility = false
                        time = "1.0"
                        oldScore = viewModel.score
                    }) {
                        Text(text = "Restart Quiz")
                    }
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            Row{
                if(!pressedButton)
                {
                     ProgressTimer {progress ->
                         time = progress.toString()
                     }
                }
            }
            Row {
                    Text(text = "Remaining Time " + time)
                }
            Row {
                if(changeQuestionButtonVisibility)
                {
                    Text(text = "Points made this round " + (viewModel.score - oldScore))
                }
            }
        }
}



@Composable
fun KeyboardQuiz(innerPadding: PaddingValues, viewModel: QuizViewModel){
    var input by remember { mutableStateOf("") }
    var changeQuestionButtonVisibility by remember { mutableStateOf(false) }
    var submitButtonVisibility by remember { mutableStateOf(true) }
    var textFieldEnabled by remember { mutableStateOf(true) }
    val gameType by viewModel.gameType.collectAsState()
    var time by remember { mutableStateOf("") }
    var oldScore by remember { mutableStateOf(0) }


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
        Column {
            Row {

                TextField(value = input, onValueChange = {input = it}, enabled = textFieldEnabled )
            }
                Button(onClick = {
                    viewModel.validateEstimation(input,time.toFloat())
                    changeQuestionButtonVisibility = true
                    submitButtonVisibility = false
                    textFieldEnabled = false
                }, modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                    enabled = submitButtonVisibility) {
                    Text(text = "Submit")
                }
            if(submitButtonVisibility == false && input != "")
            {
                Text(text = "Die richtige Antwort lautet " +viewModel.solution)
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row{
            if (time == "0.0" && viewModel.questionNum != 7)
            {
                submitButtonVisibility = false
                Button(onClick = {
                    viewModel.nextQuestion()
                    changeQuestionButtonVisibility = false
                    submitButtonVisibility = true
                    textFieldEnabled = true
                    input = ""
                    time = "1.0"
                    oldScore = viewModel.score
                }) {
                    Text(text = "Next Question")
                }
            }
            if(changeQuestionButtonVisibility && viewModel.questionNum != 7)
            {
                Button(onClick = {
                    viewModel.nextQuestion()
                    changeQuestionButtonVisibility = false
                    submitButtonVisibility = true
                    textFieldEnabled = true
                    input = ""
                    oldScore = viewModel.score
                }) {
                    Text(text = "Next Question")
                }
            }
            if (time == "0.0" && viewModel.questionNum == 7)
            {
                submitButtonVisibility = false
                Button(onClick = {
                    viewModel.startQuiz(gameType)
                    changeQuestionButtonVisibility = false
                    submitButtonVisibility = true
                    textFieldEnabled = true
                    input = ""
                    time = "1.0"
                    oldScore = viewModel.score
                }) {
                    Text(text = "Restart Quiz")
                }
            }
            if(changeQuestionButtonVisibility && viewModel.questionNum == 7)
            {
                Button(onClick = {
                    viewModel.startQuiz(gameType)
                    changeQuestionButtonVisibility = false
                    submitButtonVisibility = true
                    textFieldEnabled = true
                    input = ""
                    oldScore = viewModel.score
                }) {
                    Text(text = "Restart Quiz")
                }
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row{
            if(submitButtonVisibility)
            {
                ProgressTimer {progress ->
                    time = progress.toString()
                }
            }
        }
        Row {
            Text(text = "Remaining Time " + time)
        }
        Row {
            if(changeQuestionButtonVisibility)
            {
                Text(text = "Points made this round " + (viewModel.score - oldScore))
            }

        }
    }
    
}

@Preview
@Composable
fun SelectivePreview(){
    //SelectiveQuiz()
}

@Composable
fun ProgressTimer(onProgressChange: (Float) -> Unit) {
    var currentProgress by remember { mutableStateOf(0f) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit)
    {
        scope.launch {
            loadProgress { progress ->
                val transformedProgress = 8 * (1 - progress)
                currentProgress = transformedProgress
                onProgressChange(transformedProgress)
            }
        }
    }

    LinearProgressIndicator(
        progress = {1 -  currentProgress / 8f},
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

suspend fun loadProgress(updateProgress: (Float) -> Unit ){
    for (i in 1..100){
        updateProgress(i.toFloat() / 100)
        delay(80)
    }
}
