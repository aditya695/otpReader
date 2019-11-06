package com.example.otpreader

enum class MyOtpCollection(var regexForOtp: String) {
    OTP("([0-9]+)[ ][iI][sS][ ][oO][tT][pP]"),
    OTP1("([0-9]+)[ ][iI][sS][ ][yY][oO][uU][rR][ ][oO][nN][eE][ ][tT][iI][mM][eE] [pP][aA][sS][sS][wW][oO][rR][dD]"),
    OTP2("[oO][nN][eE][ ][tT][iI][mM][eE] [pP][aA][sS][sS][wW][oO][rR][dD][ ][iI][sS][ ]([0-9]+)"),
    OTP3("[oO][nN][eE][ ][tT][iI][mM][eE] [pP][aA][sS][sS][wW][oO][rR][dD][(][oO][tT][pP][)][ ][iI][sS][ ]([0-9]+)");

    fun getOtpType(): String {
        return regexForOtp
    }
}