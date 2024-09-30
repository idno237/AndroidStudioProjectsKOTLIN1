package com.example.kotlin1

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin1.ui.theme.KOTLIN1Theme

//---------------------------------------------------------------------------------------
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KOTLIN1Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    //Greeting("Android ")
                    GreetingText(message = getString(R.string.happy_birthday_idriss), from = "From Emma", modifier = Modifier.padding(8.dp))


                }
            }
        }
    }
}

//---------------------------------------------------------------------------------------
@Composable
fun GreetingText(message: String, from: String,  modifier: Modifier = Modifier){
    Column(verticalArrangement = Arrangement.Center, modifier = modifier.padding(8.dp)) {
        Text(
            text = message,
            fontSize = 30.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
            )

    }
}

//---------------------------------------------------------------------------------------
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.androidparty)
   Box(modifier){
       Image(
           painter = image,
           contentDescription = null,
           contentScale = ContentScale.Crop,
           alpha = 0.5F


       )
       GreetingText(message = "Happy Birthday IDRISS!", from = "From Emma", modifier = Modifier
           .fillMaxSize()
           .padding(8.dp))
   }
}

//---------------------------------------------------------------------------------------
@Composable
fun GreetingImage2(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.bg_compose_background)
    Column(modifier){
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Fit

        )
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = message,
                fontSize = 24.sp, // Taille de police à 24sp
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp) // Marge intérieure de 16dp (haut, bas, début, fin)
            )
            Text(
                text = from,
                modifier = Modifier
                    .fillMaxWidth() // Prendre toute la largeur
                    .padding(start = 16.dp, end = 16.dp) // Marge intérieure de 16dp (début et fin)
                    .align(Alignment.Start),
                textAlign = TextAlign.Justify
            )
            Text(
                text = stringResource(R.string.Third_text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.Start),
                textAlign = TextAlign.Justify
            )
        }

    }
}

//---------------------------------------------------------------------------------------
@Composable
fun GreetingImage3(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.ic_task_completed)

    Box (modifier = modifier.fillMaxSize() )
    {
            Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), verticalArrangement = Arrangement.Center,  horizontalAlignment = Alignment.CenterHorizontally)
    {

        Spacer(modifier = Modifier.weight(1f)) // Pousser vers le bas

        Text(
            text = message,
            fontSize = 24.sp, // Taille de police à 24sp
            fontWeight = FontWeight.Bold, // Épaisseur de police Bold
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp) //  (haut : 24dp, bas : 8dp)
        )

        Text(
            text = from,
            fontSize = 16.sp, // Taille de police à 16sp
            modifier = Modifier.padding(16.dp) // Marge intérieure de 16dp (haut, bas, début, fin)
        )
    }
    }
}
//---------------------------------------------------------------------------------------
@Composable
fun QuadrantPrincipal() {
    Column(
        modifier = Modifier.fillMaxSize())
    {

        Row(modifier = Modifier.weight(1f))
        {
            Quadrant(title = "Text composable", description = stringResource(R.string.first_quadrant), modifier = Modifier.weight(1f), color = Color(0xFFEADDFF))
            Quadrant(title = "Image composable", description = stringResource(R.string.second_quadrant), modifier = Modifier.weight(1f), color = Color(0xFFD0BCFF))
        }

        Row(modifier = Modifier.weight(1f))
        {
            Quadrant(title = "Row composable", description = stringResource(R.string.third_quadrant), modifier = Modifier.weight(1f), color = Color(0xFFB69DF8))
            Quadrant(title = "Column composable", description = stringResource(R.string.fourth_quadrant), modifier = Modifier.weight(1f), color = Color(0xFF6EDFF))
        }

    }
    
}
                            //*****************//
@Composable
fun Quadrant(title: String, description: String,  color : Color, modifier: Modifier = Modifier)
{
    Box(modifier = modifier
        .fillMaxSize()
        .background(color),  contentAlignment = Alignment.Center)
    {

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth())
        {
            Text(text = title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp) )
            Text(text = description, fontSize = 16.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Justify)
        }



    }

}
//---------------------------------------------------------------------------------------
@Composable
fun CarteVisite(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        color = Color(0xFFd3ebd3), // Couleur de fond
        shape = RoundedCornerShape(16.dp))
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            /*verticalArrangement = Arrangement.SpaceEvenly*/)
        {

            Spacer(modifier = Modifier.height(100.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp))
            {

                Image(
                    painter = painterResource(id = R.drawable.android_logo),
                    contentDescription = "Android Logo",
                    modifier = Modifier.size(100.dp))

                Text(
                    text = "Jennifer Doe",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF000000))

                Text(
                    text = "Android Developer Extraordinaire",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF3cd682))

            }


            Spacer(modifier = Modifier.height(350.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Contact(icon = Icons.Default.Phone, info = "+11 (123) 444 555 666")
                Contact(icon = Icons.Default.Email, info = "jen.doe@android.com")
                Contact(icon = Icons.Default.Share, info = "@AndroidDev")

            }
        }
    }

}
                        //*****************//
@Composable
fun Contact(icon: androidx.compose.ui.graphics.vector.ImageVector, info: String)
{
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp))
    {

        Column( modifier = Modifier.width(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally)
        {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(0xFF3cd682),
                modifier = Modifier.size(24.dp))
        }

        Spacer(modifier = Modifier.width(8.dp))


        Column()
        {
            Text(
                text = info,
                fontSize = 16.sp,
                color = Color(0xFF000000))
        }
    }

}
//---------------------------------------------------------------------------------------
@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    KOTLIN1Theme {
        //GreetingText(message = "Happy Birthday IDRISS!", from = "From Emma", modifier = Modifier.padding(8.dp))
        //GreetingImage(message = stringResource(R.string.happy_birthday_text), from = "From Emma", modifier = Modifier.padding(8.dp))
        //GreetingImage2(message = stringResource(R.string.jetpack_compose_tutoriall), from = stringResource(R.string.second_text), modifier = Modifier.padding(8.dp))
        //GreetingImage3(message = "ALL tasks completed", from = "Nice work", modifier = Modifier.padding(8.dp))

        //Surface(color = MaterialTheme.colorScheme.background) { QuadrantPrincipal()}

        //CarteVisite()
    }
}
//---------------------------------------------------------------------------------------