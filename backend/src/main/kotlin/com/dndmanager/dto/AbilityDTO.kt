package com.dndmanager.dto

data class AbilityCreateDTO(val name: String, val description: String?) : BaseCreateDTO()

data class AbilityGetDTO(val id: Long, val name: String, val description: String?) : BaseGetDTO()

data class AbilityFindDTO(val id: Long, val name: String, val description: String?) : BaseFindDTO()

data class AbilityUpdateDTO(val name: String?, val description: String?) : BaseUpdateDTO()