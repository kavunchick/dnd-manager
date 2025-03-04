package com.dndmanager.dto

data class CharacterInventoryCreateDTO (val amount: Int, val character: Long, val equipment: Long) : BaseCreateDTO()

data class CharacterInventoryUpdateDTO (val amount: Int) : BaseUpdateDTO()

data class CharacterInventoryFindDTO (val id: Long, val amount: Int, val equipment: EquipmentFindDTO) : BaseFindDTO()

data class CharacterInventoryGetDTO (val id: Long, val amount: Int, val equipment: EquipmentFindDTO) : BaseGetDTO()