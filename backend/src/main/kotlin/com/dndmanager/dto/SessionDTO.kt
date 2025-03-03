package com.dndmanager.dto

import java.time.Instant

data class SessionFindDTO(val id: Long, val name: String, val players: List<CharacterFindDTO>) : BaseFindDTO()

data class SessionCreatDTO(val name: String) : BaseCreateDTO()

data class SessionGetDTO(val id: Long, val name: String, val start: Instant, val lastUpdated: Instant?, val players: List<CharacterFindDTO>) : BaseGetDTO()

data class SessionUpdateDTO(val name: String) : BaseUpdateDTO()