package com.usatayamish.expertcourseunscramblegame

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.usatayamish.expertcourseunscramblegame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        ViewCompat.setOnApplyWindowInsetsListener(binding.rootLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setContentView(binding.root)

        val viewModel = GameViewModel(GameRepository.Base())

        binding.nextButton.setOnClickListener {
            val uiState: GameUiState = viewModel.next()
            uiState.update(binding = binding)
        }

        binding.checkButton.setOnClickListener {
            val uiState: GameUiState = viewModel.check(
                text = binding.inputEditText.text.toString()
            )
            uiState.update(binding = binding)
        }

        binding.skipButton.setOnClickListener {
            val uiState: GameUiState = viewModel.skip()
            uiState.update(binding = binding)
        }

        binding.inputEditText.addTextChangedListener {
            val uiState: GameUiState = viewModel.handleUserInput(
                text = it.toString()
            )
            uiState.update(binding = binding)
        }

        val uiState: GameUiState = viewModel.init()
        uiState.update(binding = binding)
    }


}