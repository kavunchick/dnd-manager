package com.dndmanager.dto

import com.dndmanager.domain.helper.Alignment

data class NpcCreateDTO(
    val name: String,
    val description: String,
    val health: Short,
    val alignment: Alignment,
    val npcClassId: Long,
    val npcRaceId: Long,
    val isHostile: Boolean,
    val role: String,
    val locationId: Long?
) : BaseCreateDTO()

data class NpcUpdateDTO(
    val name: String?,
    val description: String?,
    val health: Short?,
    val alignment: Alignment?,
    val npcClassId: Long?,
    val npcRaceId: Long?,
    val isHostile: Boolean?,
    val role: String?,
    val locationId: Long?
) : BaseUpdateDTO()

data class NpcGetDTO(
    val id: Long,
    val name: String,
    val description: String,
    val health: Short,
    val alignment: Alignment,
    val npcClass: ClassFindDTO,
    val npcRaceId: RaceFindDTO,
    val isHostile: Boolean,
    val role: String,
    val location: LocationFindDTO?
) : BaseGetDTO()

data class NpcFindDTO(
    val id: Long,
    val name: String,
    val alignment: Alignment,
    val npcClass: ClassFindDTO,
    val npcRaceId: RaceFindDTO,
    val isHostile: Boolean,
    val role: String,
    val location: LocationFindDTO?
) : BaseFindDTO()