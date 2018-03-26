package isfaaghyth.app.rxkpm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val test1 = listOf<String>("komunitas", "programmer", "makassar")
        val test2 = listOf<String>("butta", "daeng")

        val test1Obs = Observable.just(test1)
        val test2Obs = Observable.just(test2)

        test1Obs
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    res -> Log.d("TAG", res.toString())
                }, {

                }, {
                    test2Obs.subscribe()
                })
    }
}
