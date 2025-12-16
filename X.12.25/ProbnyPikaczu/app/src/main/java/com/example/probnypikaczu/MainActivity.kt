package com.example.probnypikaczu

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.probnypikaczu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seekBar: SeekBar?,
                progress: Int,
                fromUser: Boolean
            ) {
                binding.imageCountText.text = getString(R.string.image_count, progress)
                binding.imageCountHeader.text = when (progress) {
                    1 -> {
                        getString(R.string.oneImage)
                    }

                    in 2..<5 -> {
                        getString(R.string.twotofourImages, progress)
                    }

                    else -> {
                        getString(R.string.overFiveImages, progress)
                    }
                }

                binding.imagesContainer.removeAllViews()

                for (i in 0 until progress) {
                    val imageView = ImageView(this@MainActivity)
                    imageView.setImageResource(R.drawable.pikaczu)

                    val params = LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1f
                    )
                    params.setMargins(8,8,8,8)
                    imageView.layoutParams = params
                    
                    binding.imagesContainer.addView(imageView)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }
}