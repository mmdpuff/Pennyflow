package com.mmdpuff.pennyflow.feature.setup

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mmdpuff.pennyflow.R
import com.mmdpuff.pennyflow.ui.theme.Inter
import com.mmdpuff.pennyflow.ui.theme.LocalAppColors

@Composable
fun SetupScreen(modifier: Modifier = Modifier, onContinue: () -> Unit) {
    val colors = LocalAppColors.current
    Scaffold { innerPadding ->
        Column(
            modifier
                .padding(innerPadding)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(colors.accent),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.appicon),
                        contentDescription = null,
                        tint = Color(0xff0B1220)
                    )
                }
                Spacer(Modifier.width(10.dp))
                Text(
                    "Penny flow",
                    fontSize = 22.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    color = colors.text
                )
            }

            Text(
                "A little clarity.\tA lot more freedom.",
                fontWeight = FontWeight.SemiBold,
                fontSize = 32.sp, color = colors.text, lineHeight = 30.sp
            )

            Text(
                "Start with your monthly take-home pay.\n" +
                        "I’ll help you see what’s truly yours to spend.",
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = colors.muted, lineHeight = 20.sp
            )

            Box(
                Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(22.dp))
                    .background(colors.surface)
                    .padding(20.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        "Monthly take-home pay",
                        color = colors.muted,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {


                        val inputStyle = TextStyle(
                            color = colors.text,
                            fontSize = 36.sp,
                            fontWeight = FontWeight.SemiBold,
                            lineHeight = 44.sp,
                            letterSpacing = 0.sp,
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        )

                        TextField(
                            state = rememberTextFieldState("20,000,000"),
                            lineLimits = TextFieldLineLimits.SingleLine,
                            contentPadding = PaddingValues(0.dp),
                            textStyle = inputStyle,
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                cursorColor = colors.text
                            ),
                            prefix = {
                                Text(
                                    text = "﷼ ",
                                    style = inputStyle
                                )
                            }
                        )
                    }
                    Spacer(
                        Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .background(colors.border)
                    )
                    Text(
                        "After tax, before life happens.",
                        color = colors.muted,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                }

            }

            Box(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(colors.accent)
                    .clickable(enabled = true, onClick = onContinue),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Let’s make a plan",
                    color = Color(0xff0B1220),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            }
        }
    }
}