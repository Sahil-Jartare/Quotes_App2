package com.example.quotesapp2

class DataSource()
{
    fun loadQuotes(): List<Quote>{ //List initialization
        return listOf<Quote>(
            Quote(R.string.quotes1, R.drawable.image1),
            Quote(R.string.quotes2, R.drawable.image2),
            Quote(R.string.quotes3, R.drawable.image3),
            Quote(R.string.quotes4, R.drawable.image4),
            Quote(R.string.quotes5, R.drawable.image5),
            Quote(R.string.quotes6, R.drawable.image6),
            Quote(R.string.quotes7, R.drawable.image7),
            Quote(R.string.quotes8, R.drawable.image8),
            Quote(R.string.quotes9, R.drawable.image9),
            Quote(R.string.quotes10, R.drawable.image10)

        )
    }
    fun loadAuthors(): List<Author>{
        return listOf<Author>(
            Author(R.string.author1),
            Author(R.string.author2),
            Author(R.string.author3),
            Author(R.string.author4),
            Author(R.string.author5),
            Author(R.string.author6),
            Author(R.string.author7),
            Author(R.string.author8),
            Author(R.string.author9),
            Author(R.string.author10),



        )
    }

}