package com.example.rickandmortyapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.rickandmortyapp.data.remote.CharactersApi
import com.example.rickandmortyapp.repositories.remote.CharacterRepository
import com.example.rickandmortyapp.repositories.remote.CharacterRepositoryImpl
import com.example.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var repository: CharacterRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        runBlocking {
            withContext(Dispatchers.IO) {

                val result = repository.getAllCharacters()
                Log.d("CHARACTERS", "CHARACTERS....")
                result.data?.results?.forEach { character ->
                    Log.d("CHARACTER", character.name)
                } ?: Log.e("CHARACTERS","ERROR")
            }
        }

    }
}
