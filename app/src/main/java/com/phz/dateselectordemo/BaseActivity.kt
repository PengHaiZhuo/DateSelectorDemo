package com.phz.dataselectordemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author 彭海卓 on 2019/11/14
 * @introduction
 */
abstract class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContenView())
        initData()
    }

    abstract fun initData()
    abstract fun getContenView():Int
}