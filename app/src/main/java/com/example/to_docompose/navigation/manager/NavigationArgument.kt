package com.smarthome.core.presentation.navigation.manager

fun String.populatePathNavArgs(args: Map<String, Any>): String {
    var routeWithArgs = this
    args.forEach { (key, value) ->
        routeWithArgs = routeWithArgs.replace("{$key}", value.toString())
    }
    return routeWithArgs
}

fun String.appendQueryNavArgs(args: List<String>): String {
    return if (args.isEmpty()) {
        this
    } else {
        "$this?${args.joinToString("&") { "$it={$it}" }}"
    }
}

fun String.appendQueryNavArgs(args: Map<String, Any>): String {
    return if (args.isEmpty()) {
        this
    } else {
        "$this?${args.asIterable().joinToString("&") { "${it.key}=${it.value}" }}"
    }
}