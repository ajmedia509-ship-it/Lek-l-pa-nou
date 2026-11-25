package com.example.navigation

object AppRoutes {
    const val ROUTE_HOME = "home"
    const val ROUTE_WORKSHOPS = "workshops"
    const val ARG_TRADE_ID = "tradeId"
    const val ROUTE_COURSE_DETAIL = "course_detail/{$ARG_TRADE_ID}"

    fun courseDetailRoute(tradeId: String): String = "course_detail/$tradeId"
}
