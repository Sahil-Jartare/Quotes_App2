package com.example.quotesapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quotesapp2.ui.theme.QuotesApp2Theme
import kotlin.math.round


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesApp2Theme {
                // A surface container using the 'background' color from the theme
                QuoteCardPreview()
            }
        }
    }
}

@Composable
fun QuotesApp2()
{
    QuotesList(
        quoteList = DataSource().loadQuotes(),
        authorList = DataSource().loadAuthors()
    )


}
@Composable
fun QuotesList(quoteList: List<Quote>, authorList : List<Author>, modifier : Modifier = Modifier)
{
    LazyColumn{
        items(quoteList)
        {
            val author: Author
            quote: Quote ->QuoteCard(quote = quote; author = author)
        }


    }
}
@Composable
fun QuoteCard(quote: Quote, author : Author, modifier: Modifier = Modifier)
{
    Card(modifier = Modifier.padding(15.dp), elevation = CardDefaults.cardElevation(
        defaultElevation = 10.dp))
    {
        Column(){
            Text(
                text = stringResource(id = quote.stringResourceId),
                modifier = modifier.padding(10.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = stringResource(id = author.stringResourceId),
                modifier = modifier.padding(10.dp),
                style = MaterialTheme.typography.headlineSmall
            )

        }
        Column(){
            Image(painter = painterResource(id = quote.imageResourceId),
                contentDescription = stringResource(id = quote.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp)
                    .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp)),

                contentScale = ContentScale.Crop
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun QuoteCardPreview(){
    QuotesApp2()
}