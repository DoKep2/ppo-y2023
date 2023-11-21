package ru.quipy.entity

import java.util.*

class AccountEntity (
    var accountId: UUID,
    var isClosed: Boolean,
    var balance: Int
)