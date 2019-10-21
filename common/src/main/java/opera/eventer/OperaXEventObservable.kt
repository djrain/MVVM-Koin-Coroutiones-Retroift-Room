package opera.eventer

import android.os.Looper
import java.util.*

object OperaXEventObservable : Observable() {
    @JvmStatic
    fun notify(obj: Enum<*>) {
        notifyObservers(obj)
    }

    override fun notifyObservers(data: Any?) {
        if (data == null)
            throw NullPointerException("!event obj must not null")

        if (data.javaClass.name != "smart.base.EE")
            throw NullPointerException("!event obj must defined in the smart.base.EE")

        if (data !is Enum<*>)
            throw NullPointerException("!event obj must Enum")

        if (Looper.myLooper() != Looper.getMainLooper())
            throw IllegalThreadStateException("!event obj must be in MainThread")

        setChanged()
        super.notifyObservers(data)
    }

}