package com.example.myapplication.core.ui
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Icon
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.compose.material3.ExperimentalMaterial3Api


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentInfoScreen () {
    //FOR TEXTFIELDS
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var middle by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var section by remember { mutableStateOf("") }
    val datePickerState = rememberDatePickerState()
    var showDialog by remember { mutableStateOf(false) }
    //BAHALA NA
    var isSubmitted by remember { mutableStateOf(false) }
    var firstNameErrors by remember { mutableStateOf("") }
    var lastNameErrors by remember { mutableStateOf("") }
    var middleErrors by remember { mutableStateOf("") }
    var selectedDateErrors by remember { mutableStateOf("") }
    var ageErrors by remember { mutableStateOf("") }
    var yearErrors by remember { mutableStateOf("") }
    var sectionErrors by remember { mutableStateOf("") }

    fun validateForm(): Boolean {
        firstNameErrors = ""
        lastNameErrors = ""
        middleErrors = ""
        selectedDateErrors = ""
        ageErrors = ""
        yearErrors = ""
        sectionErrors = ""

        var isValid = true

        if (firstName.trim().isEmpty()) {
            firstNameErrors = "First Name is Required"
            isValid = false
        }
        if (lastName.trim().isEmpty()) {
            lastNameErrors = "First Name is Required"
            isValid = false
        }
        if (middle.trim().isEmpty()) {
            middleErrors = "First Name is Required"
            isValid = false
        }
        //Birth
        if (selectedDate.trim().isEmpty()) {
            selectedDate = "First Name is Required"
            isValid = false
        }
        if (age.trim().isEmpty()) {
            ageErrors = "First Name is Required"
            isValid = false
        }
        if (year.trim().isEmpty()) {
            yearErrors = "First Name is Required"
            isValid = false
        }
        if (section.trim().isEmpty()) {
            sectionErrors = "First Name is Required"
            isValid = false
        }
        return isValid
    }

    if (showDialog) {
        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        val selectedMillis = datePickerState.selectedDateMillis
                        if (selectedMillis != null) {
                            val formatter =
                                SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
                            selectedDate = formatter.format(Date(selectedMillis))
                        }
                        showDialog = false
                    }
                ) {
                    Text("OK")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Spacer(Modifier.height(24.dp))

            Text(
                text = "Registration Form",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(30.dp))

            Column {
                OutlinedTextField(
                    isError = firstNameErrors.isNotEmpty(),
                    supportingText = {
                        if (firstNameErrors.isNotEmpty()){
                            Text(firstNameErrors)

                        }
                    },

                    value = firstName,
                    onValueChange = { firstName = it },
                    label = { Text(text = "Enter First Name") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )


                Spacer(Modifier.height(5.dp))

                Column {
                    OutlinedTextField(
                        isError = lastNameErrors.isNotEmpty(),
                        supportingText = {
                            if (lastNameErrors.isNotEmpty()){
                                Text(lastNameErrors)

                            }
                        },

                        value = lastName,
                        onValueChange = { lastName = it },
                        label = { Text(text = "Enter Last Name") },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    Column {
                        OutlinedTextField(
                            isError = middle.isNotEmpty(),
                            supportingText = {
                                if (middle.isNotEmpty()){
                                    Text(middleErrors)

                                }
                            },

                            value = middle,
                            onValueChange = { middle = it },
                            label = { Text(text = "Enter Middle Name") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Column {
                            OutlinedTextField(
                                isError = sectionErrors.isNotEmpty(),
                                supportingText = {
                                    if (selectedDate.isNotEmpty()){
                                        Text(selectedDateErrors)

                                    }
                                },

                                value = selectedDate,
                                onValueChange = { },
                                label = { Text(text = "Birthday (MM/DD/YYYY)") },
                                placeholder = { Text("MM/DD/YYYY") },
                                trailingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.DateRange,
                                        contentDescription = "Select Date",
                                        modifier = Modifier.clickable { showDialog = true }
                                    )
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { showDialog = true },
                                readOnly = true
                            )
                        }



                        Column {

                            OutlinedTextField(
                                isError = age.isNotEmpty(),
                                supportingText = {
                                    if (ageErrors.isNotEmpty()){
                                        Text(ageErrors)

                                    }
                                },

                                value = age,
                                onValueChange = { age = it },
                                label = { Text(text = "Enter Age") },
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(Modifier.height(5.dp))

                            Column {
                                OutlinedTextField(
                                    isError = yearErrors.isNotEmpty(),
                                    supportingText = {
                                        if (yearErrors.isNotEmpty()){
                                            Text(yearErrors)

                                        }
                                    },

                                    value = year,
                                    onValueChange = { year = it },
                                    label = { Text(text = "Enter Year") },
                                    singleLine = true,
                                    modifier = Modifier.fillMaxWidth()
                                )

                                Column {
                                    OutlinedTextField(
                                        value = section,
                                        onValueChange = { section = it },
                                        label = { Text(text = "Enter section") },
                                        singleLine = true,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                    Spacer(modifier = Modifier.height(0.dp))

                                    Column(
                                        modifier = Modifier.fillMaxSize(), // Make the Column take the whole screen
                                        verticalArrangement = Arrangement.Center, // Center content vertically
                                        horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
                                    ) {

                                        Button(
                                            onClick = {
                                                val valid = validateForm()
                                                if (valid){
                                                    isSubmitted = true
                                                }
                                            },
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            shape = CutCornerShape(20.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color(0xFFF54927),
                                                contentColor = MaterialTheme.colorScheme.onPrimary,
                                            ),

                                            ) {
                                            Text(text = "Submit")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
@Composable
fun WelcomeScreen(){}


@Composable
@Preview(showBackground = true)
fun StudentInfoScreenPreview(){

    MyApplicationTheme {
        StudentInfoScreen()

    }
}
