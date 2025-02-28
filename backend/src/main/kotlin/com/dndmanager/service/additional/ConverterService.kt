package com.dndmanager.service.additional

import com.dndmanager.domain.Ability
import com.dndmanager.dto.AbilityCreateDTO
import com.dndmanager.dto.AbilityFindDTO
import com.dndmanager.dto.AbilityGetDTO
import com.dndmanager.dto.AbilityUpdateDTO

class ConverterService {
    // toEntity
    fun toEntity(abilityDTO: AbilityCreateDTO): Ability = abilityDTO.run {
        Ability(name, description)
    }

    // toGetDTO
    fun toGetDTO(ability: Ability): AbilityGetDTO = ability.run {
        AbilityGetDTO(id ?: -1, name, description)
    }

    //    toFindDTO
    fun toFindDTO(abilities: List<Ability>): List<AbilityFindDTO> =
        abilities.map { AbilityFindDTO(it.id ?: -1, it.name, it.description) }

    // merge
    fun merge(ability: Ability, abilityDTO: AbilityUpdateDTO): Ability = ability.run {
        Ability(abilityDTO.name ?: name, abilityDTO.description ?: description)
    }
}