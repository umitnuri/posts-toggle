package biz.aydin.toggle.domain

sealed class Toggle<ReturnType : Any> {
    lateinit var returnValue: ReturnType

    class On<ReturnType : Any> : Toggle<ReturnType>()
    class Off<ReturnType : Any> : Toggle<ReturnType>()

    inline fun on(body: () -> ReturnType): Toggle<ReturnType> {
        if (this is On) {
            returnValue = body()
        }
        return this
    }

    inline fun off(body: () -> ReturnType): Toggle<ReturnType> {
        if (this is Off) {
            returnValue = body()
        }
        return this
    }

    fun get(): ReturnType {
        if (!::returnValue.isInitialized) {
            throw Throwable("You must provide both off and on body")
        }
        return returnValue
    }

    operator fun invoke(): ReturnType {
        return get()
    }
}

fun <R : Any> on(): Toggle.On<R> = Toggle.On()
fun <R : Any> off(): Toggle.Off<R> = Toggle.Off()
