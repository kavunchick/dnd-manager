package com.dndmanager.dto

data class LocationCreateDTO (val sessionId: Long, val name: String, val description: String?): BaseCreateDTO()

data class LocationUpdateDTO(val sessionId: Long?, val name: String?, val description: String?): BaseUpdateDTO()

data class LocationGetDTO(val id: Long, val session: SessionFindDTO, val name: String, val description: String?): BaseGetDTO()

data class LocationFindDTO (val id: Long, val name: String, val description: String?): BaseFindDTO()