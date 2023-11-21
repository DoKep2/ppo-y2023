package ru.quipy.dto

import java.util.UUID

class TransferDto (
    var accountFromId: UUID,
    var accountToId: UUID,
    var delta: Int
)