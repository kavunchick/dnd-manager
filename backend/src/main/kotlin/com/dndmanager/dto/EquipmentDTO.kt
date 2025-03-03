package com.dndmanager.dto

data class EquipmentCreateDTO(val name: String, val description: String, val suggestedPriceGp: Short, val weight: Double) : BaseCreateDTO()

data class EquipmentUpdateDTO(val name: String, val description: String?, val suggestedPriceGp: Short?, val weight: Double?) : BaseUpdateDTO()

data class EquipmentFindDTO(val id: Long, val name: String, val weight: Double) : BaseFindDTO()

data class EquipmentGetDTO(val id: Long, val name: String, val description: String, val suggestedPriceGp: Short, val weight: Double) : BaseGetDTO()
