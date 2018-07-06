package com.smilehacker.retrofitleak

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk15.listeners.onClick

class TestLeakActivity: AppCompatActivity(), AnkoLogger {

    private lateinit var mTvMsg: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {

            mTvMsg = textView().lparams(matchParent, wrapContent)

            button("request") {
                onClick {
                    loadFeed()
                }
            }.lparams {
                topMargin = dip(10)
            }
        }
    }


    /**
     * Call同步请求会把okhttp的resp关闭 不会泄露
     */
    private fun loadFeed() {
        doAsync {
            val resp = Client.API.getHotFeed().execute()
            debug("resp[${resp.code()} ${resp.message()}")
            uiThread {
                toast("resp")
                mTvMsg.text = "load feed direct: result=${resp.body()}"
            }
        }
    }

    private fun loadFeedWithResp() {
        doAsync {
            val resp = Client.API.getHotFeedInResp().execute()
            debug("resp[${resp.code()} ${resp.message()}")
            uiThread {
                toast("resp")
                mTvMsg.text = "load feed direct: result=${resp.body()}"
            }
        }
    }

}