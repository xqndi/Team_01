package at.tu.graz.coffee

import android.app.Application
import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco


class CoffeeApplication : Application() {

    companion object {
        var ctx: Context? = null
    }

    override fun onCreate() {
        super.onCreate()

        ctx = applicationContext
        Fresco.initialize(ctx)
    }
}