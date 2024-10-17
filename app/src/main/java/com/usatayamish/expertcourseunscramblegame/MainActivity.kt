package com.usatayamish.expertcourseunscramblegame


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.usatayamish.expertcourseunscramblegame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private lateinit var uiState: GameUiState
   private lateinit var binding: ActivityMainBinding
   private lateinit var viewModel: GameViewModel

   private val textWatcher = object : TextWatcher {
       override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

       override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

       override fun afterTextChanged(s: Editable?) {
           uiState = viewModel.handleUserInput(
               text = s.toString()
           )
           update.invoke()
       }

   }

    private val update: ()-> Unit = {
        uiState.update(
            binding.shuffledWordTextView,
            binding.inputView,
            binding.skipButton,
            binding.checkButton,
            binding.nextButton
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)
        ViewCompat.setOnApplyWindowInsetsListener(binding.rootLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setContentView(binding.root)

        viewModel = (application as UnscrambleApp).viewModel



        binding.nextButton.setOnClickListener {
            uiState = viewModel.next()
            update.invoke()
        }

        binding.checkButton.setOnClickListener {
            uiState = viewModel.check(
                text = binding.inputView.text()
            )
            update.invoke()
        }

        binding.skipButton.setOnClickListener {
            uiState = viewModel.skip()
            update.invoke()
        }


        uiState = viewModel.init(savedInstanceState == null)
    }


    override fun onResume() {
        super.onResume()
        binding.inputView.addTextChangedListener(textWatcher)
    }

    override fun onPause() {
        super.onPause()
        binding.inputView.removeTextChangedListener(textWatcher)
    }

}