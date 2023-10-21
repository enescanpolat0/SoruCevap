package com.enescanpolat.sorucevap.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.enescanpolat.sorucevap.R
import com.enescanpolat.sorucevap.databinding.ActivityMainBinding
import com.enescanpolat.sorucevap.domain.model.Message

class MainActivity : AppCompatActivity() {

    private lateinit var _binding:ActivityMainBinding
    private lateinit var chatGBTViewModel: ChatGBTViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=ActivityMainBinding.inflate(layoutInflater)
        val binding = _binding.root
        setContentView(binding)


        chatGBTViewModel = ViewModelProvider(this)[ChatGBTViewModel::class.java]

        val linearLayoutManager = LinearLayoutManager(this)
        _binding.recyclerView.layoutManager = linearLayoutManager

        chatGBTViewModel.messageList.observe(this){messages->
            val adapter = MessageAdapter(messages)
            _binding.recyclerView.adapter=adapter
        }

        _binding.sendBtn.setOnClickListener {
            val question = _binding.messageEditText.text.toString()
            chatGBTViewModel.addToChat(question,Message.SENT_BY_ME,chatGBTViewModel.getCurrentTimestamp())
            _binding.messageEditText.setText("")
            chatGBTViewModel.callApi(question)
        }


    }
}