package com.dndmanager.dto

import com.dndmanager.domain.helper.Alignment

data class CharacterCreateDTO(
    val name: String,
    val background: String?,
    val ideals: String?,
    val bonds: String?,
    val flaws: String?,
    val personalityTraits: String?,
    val alignment: Alignment,
    val classId: Long,
    val raceId: Long,
    val raceAbilityId: Long
) : BaseCreateDTO()

data class CharacterUpdateDTO(
    val name: String?,
    val background: String?,
    val ideals: String?,
    val bonds: String?,
    val flaws: String?,
    val personalityTraits: String?,
    val alignment: Alignment?,
    val classId: Long?,
    val raceId: Long?,
    val raceAbilityId: Long?
) : BaseUpdateDTO()

data class CharacterFindDTO(
    val name: String,
    val characterClass: ClassFindDTO,
    val characterRace: RaceFindDTO,
) : BaseFindDTO()

data class CharacterGetDTO(
    val name: String,
    val background: String?,
    val ideals: String?,
    val bonds: String?,
    val flaws: String?,
    val personalityTraits: String?,
    val alignment: Alignment,
    val characterClass: ClassFindDTO,
    val characterRace: RaceFindDTO,
    val raceAbilityBonus: RaceAbilityBonusFindDTO
) : BaseGetDTO()