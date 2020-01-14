package com.phz.dataselectordemo

import com.phz.dateselectordemo.R
import com.phz.dateselectordemo.util.DateSelector
import com.phz.dateselectordemo.util.TimeUtil
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {
    var StartTime = "1949-1-1 00:00:00"
    var EndTime = "2218-12-31 00:00:00"
    /**
     * 打印标签
     */
    private var tag=MainActivity::class.java.canonicalName

    //开始日期
    private var stringStartDate: String? = null
    //结束日期
    private var stringEndDate: String? = null

    /**
     * 开始日期选择器
     */
    private var dateSelectorStart: DateSelector? = null
    /**
     * 结束日期选择器
     */
    private var dateSelectorStop: DateSelector? = null


    override fun getContenView(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        stringStartDate=TimeUtil.getDateByInterval(System.currentTimeMillis(),0)
        stringEndDate=TimeUtil.getDateByInterval(System.currentTimeMillis(),1)
        tv_start.setOnClickListener {
            dateSelectorStart=DateSelector(this,object :DateSelector.Companion.ResultHandler{
                override fun handle(time: String) {
                    stringStartDate=time
                    tv_start.text=time
                }
            }, StartTime,EndTime, TimeUtil.format(Date(), "yyyy-MM-dd"))
            dateSelectorStart!!.show(selectDate = stringStartDate!!)
        }
        tv_end.setOnClickListener {
            dateSelectorStop=DateSelector(this,object :DateSelector.Companion.ResultHandler{
                override fun handle(time: String) {
                    stringEndDate=time
                    tv_end.text=time
                }
            }, StartTime,EndTime, TimeUtil.format(Date(), "yyyy-MM-dd"))
            dateSelectorStop!!.show(selectDate = stringEndDate!!)
        }
    }


}
