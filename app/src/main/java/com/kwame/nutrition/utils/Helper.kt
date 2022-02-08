package com.kwame.nutrition.utils

object Helper {

    fun abbreviateName(name: String): String {
        if(name.trim() == "") {
            return ""
        }
        val parts = name.split(" ");
        var abbreviation = ""

        if (parts.isEmpty()) return abbreviation;

        for(part in parts) {
            abbreviation = abbreviation.plus(part[0]).uppercase()
        }
        return abbreviation;
    }

}