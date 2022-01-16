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
        paint.color = Color.BLACK
        canvas.drawRect(0f, 0f, width.toFloat(), widthFret*1, paint)

        val margin = 200f
        val stringInterval :Float = ((width-(margin*2)) / 3).toFloat()
        paint.color = Color.GRAY
        paint.strokeWidth = 20f
        for (i in 1..3){
            canvas.drawLine(margin+stringInterval*i,0f,
                margin+stringInterval*i, height.toFloat(),paint )
            strings[i] = margin + stringInterval * i
        }

        binding.surfaceView.holder.unlockCanvasAndPost(canvas)
    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {
        TODO("Not yet implemented")
    }
}