package com.example.ukulele

import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import com.example.ukulele.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SurfaceHolder.Callback{
    private lateinit var binding: ActivityMainBinding

    private var frets: Array<Float> = arrayOf(0f, 0f, 0f, 0f)
    private var strings:Array<Float> = arrayOf(0f, 0f, 0f, 0f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val holder = binding.surfaceView.holder
        holder.addCallback(this)
    }

    override fun surfaceCreated(p0: SurfaceHolder) {
        TODO("Not yet implemented")
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        val canvas = binding.surfaceView.holder.lockCanvas()
        canvas.drawColor(Color.rgb(115,66,41))
        val widthFret:Float = (height / 4).toFloat()
        val paint = Paint()
        paint.color = Color.rgb(42,42,42)
        paint.strokeWidth = 30f  //線の幅
        for (i in 1..4){
            canvas.drawLine(0f, widthFret*i, width.toFloat(), widthFret*i, paint)
            frets[i-1] = widthFret*i
        }

    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {
        TODO("Not yet implemented")
    }
}