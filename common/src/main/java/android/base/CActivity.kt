package android.base

import android.content.Context
import android.log.Log
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import java.util.*
import kotlin.properties.Delegates

abstract class CActivity : AppCompatActivity() {

    lateinit var mActivity: CActivity
    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
        mContext = this
        parseExtra()
        loadOnce()
        reload()
        updateUI()
    }

    protected fun parseExtra() = try {
        onParseExtra()
    } catch (e: Exception) {
        Log.printStackTrace(e)
    }

    protected fun loadOnce() = onLoadOnce()

    fun reload() {
        clear()
        load()
    }

    protected fun clear() = try {
        onClear()
    } catch (e: Exception) {
        Log.printStackTrace(e)
    }

    protected var mIsLoading = false
    protected fun load() {
        if (mIsLoading) {
            Log.w("mIsLoading=", mIsLoading)
            return
        }
        if (lifecycle.currentState == Lifecycle.State.DESTROYED) {
            Log.w("Lifecycle destroyed")
            return
        }
        try {
            onLoad()
        } catch (e: Exception) {
            Log.printStackTrace(e)
        }

    }

    protected fun updateUI() {
        try {
            onUpdateUI()
        } catch (e: Exception) {
            Log.printStackTrace(e)
        }
    }

    open fun onParseExtra() {}
    open fun onLoadOnce() {}
    open fun onClear() {}
    open fun onLoad() {}
    open fun onUpdateUI() {}

    val progress by lazy { createProgress() }
}