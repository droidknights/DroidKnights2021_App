package com.droidknights.app2021.shared.result

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}

/**
 * `true` if [Result] is of type [Success] & holds non-null [Success.data].
 */
val Result<*>.succeeded
    get() = this is Result.Success && data != null

fun <T> Result<T>.successOr(fallback: T): T {
    return (this as? Result.Success<T>)?.data ?: fallback
}

val <T> Result<T>.data: T?
    get() = (this as? Result.Success)?.data

inline fun <R, T> Result<T>.map(transform: (T) -> R): Result<R> {
    return when (this) {
        is Result.Success -> Result.Success(transform(data))
        is Result.Error -> Result.Error(exception)
        Result.Loading -> Result.Loading
    }
}

inline fun <R, T> Result<T>.mapCatching(transform: (T) -> R): Result<R> {
    return when (this) {
        is Result.Success -> {
            try {
                Result.Success(transform(data))
            } catch (e: Throwable) {
                Result.Error(e)
            }
        }
        is Result.Error -> Result.Error(exception)
        Result.Loading -> Result.Loading
    }
}