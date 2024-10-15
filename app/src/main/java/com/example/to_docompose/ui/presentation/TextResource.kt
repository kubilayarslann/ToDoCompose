package com.example.to_docompose.ui.presentation

import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource

// TODO: Check https://developer.android.com/develop/ui/compose/performance/stability for stability considerations.
//  Here at least immutable collections should be used (ImmutableList instead of List) + probably `@Immutable` should be
//  used on all classes as Any type is used.
//  When checking potential stability problems use official guidelines
//  https://developer.android.com/develop/ui/compose/performance/stability/diagnose.
sealed interface TextResource {
    companion object {
        fun fromString(text: String): TextResource = Text(text)
        fun fromId(@StringRes id: Int, vararg formatArgs: Any): TextResource = Id(id, listOf(*formatArgs))
        fun fromIdWithArg(@StringRes id: Int, vararg formatArgs: Any): TextResource = ArgId(id, listOf(*formatArgs))
        fun fromPlural(@PluralsRes id: Int, count: Int, vararg formatArgs: Any): TextResource = Plural(id, count, listOf(*formatArgs))
    }
}

@Suppress("SpreadOperator")
@Composable
fun TextResource.asString(): String =
    when (this) {
        is Text -> text
        is Id -> stringResource(id, *formatArgs.toTypedArray())
        is Plural -> pluralStringResource(pluralId, count, *formatArgs.toTypedArray())
        is ArgId -> {
            val resolvedArgs = formatArgs.map {
                when (it) {
                    is Int -> stringResource(it)
                    else -> it
                }
            }.toTypedArray()
            stringResource(id, *resolvedArgs)
        }
    }

private data class Text(
    val text: String
) : TextResource

private data class Id(
    @StringRes val id: Int,
    val formatArgs: List<Any>
) : TextResource

private data class Plural(
    @PluralsRes val pluralId: Int,
    val count: Int,
    val formatArgs: List<Any>
) : TextResource

private data class ArgId(
    @StringRes val id: Int,
    val formatArgs: List<Any>
) : TextResource
