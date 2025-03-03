package com.dndmanager.service.additional

import com.dndmanager.domain.*
import com.dndmanager.dto.*
import java.time.Instant

class ConverterService {
    // toEntity
    fun toEntity(abilityDTO: AbilityCreateDTO): Ability = abilityDTO.run {
        Ability(name, description)
    }

    fun toEntity(characterDto: CharacterCreateDTO): Character = characterDto.run {
        Character(
            name, background, ideals, bonds, flaws, personalityTraits, alignment,
            Class.findById(classId)!!, Race.findById(raceId)!!, RaceAbilityBonus.findById(raceAbilityId)!!
        )
    }

    fun toEntity(sessionCreatDTO: SessionCreatDTO): Session = sessionCreatDTO.run {
        Session (name, Instant.now(), null, emptyList())
    }

    // toGetDTO
    fun toGetDTO(ability: Ability): AbilityGetDTO = ability.run {
        AbilityGetDTO(id ?: -1, name, description)
    }

    fun toGetDTO(session: Session): SessionGetDTO = session.run {
        SessionGetDTO(id ?: 0, name, start, lastUpdated, characters.map { toFindDTO(it.character) })
    }

    fun toGetDTO(character: Character): CharacterGetDTO = character.run {
        CharacterGetDTO(
            id ?: 0, name, background, ideals, bonds, flaws, personalityTraits, alignment,
            toFindDTO(characterClass), toFindDTO(race), toFindDTO(abilityBonus)
        )
    }

    //    toFindDTO
    fun toFindDTO(ability: Ability): AbilityFindDTO =
        ability.run { AbilityFindDTO(id ?: 0, name) }

    fun toFindDTO(session: Session): SessionFindDTO =
        session.run { SessionFindDTO(id ?: 0, name, characters.map { toFindDTO(it.character) }) }

    fun toFindDTO(character: Character): CharacterFindDTO =
        character.run { CharacterFindDTO(id ?: 0, name, toFindDTO(characterClass), toFindDTO(race)) }

    fun toFindDTO(abilityBonus: RaceAbilityBonus): RaceAbilityBonusFindDTO =
        abilityBonus.run { RaceAbilityBonusFindDTO(id ?: 0, race.id ?: 0, ability.id ?: 0) }

    fun toFindDTO(race: Race): RaceFindDTO =
        race.run { RaceFindDTO(id ?: 0, name) }

    fun toFindDTO(classEntity: Class): ClassFindDTO =
        classEntity.run { ClassFindDTO(id ?: 0, name) }

    // merge
    fun merge(ability: Ability, abilityDTO: AbilityUpdateDTO): Ability = ability.run {
        Ability(abilityDTO.name ?: name, abilityDTO.description ?: description)
    }

    fun merge(character: Character, characterDto: CharacterUpdateDTO): Character = character.run {
        Character(
            characterDto.name ?: name,
            characterDto.background ?: background,
            characterDto.ideals ?: ideals,
            characterDto.bonds ?: bonds,
            characterDto.flaws ?: flaws,
            characterDto.personalityTraits ?: personalityTraits,
            characterDto.alignment ?: alignment,
            characterDto.classId?.let { Class.findById(it)!! } ?: character.characterClass,
            characterDto.raceId?.let { Race.findById(it)!! } ?: character.race,
            characterDto.raceAbilityId?.let { RaceAbilityBonus.findById(it)!! } ?: character.abilityBonus
            )
    }

    fun merge(session: Session, sessionDto: SessionUpdateDTO): Session = session.run {
        Session (sessionDto.name, session.start, Instant.now(), characters)
    }
}