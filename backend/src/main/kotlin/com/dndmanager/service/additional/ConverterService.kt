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
        Session(name, Instant.now(), null, emptyList())
    }

    fun toEntity(equipmentCreateDTO: EquipmentCreateDTO): Equipment = equipmentCreateDTO.run {
        Equipment(name, description, suggestedPriceGp, weight)
    }

    fun toEntity(ciCreateDTO: CharacterInventoryCreateDTO) : CharacterInventory = ciCreateDTO.run {
        CharacterInventory(amount, SessionsCharacter.findById(character)!!, Equipment.findById(equipment)!!)
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

    fun toGetDTO(equipment: Equipment): EquipmentGetDTO = equipment.run {
        EquipmentGetDTO(id ?: 0, name, description ?: "", suggestedPriceGp, weight)
    }

    fun toGetDTO(ci: CharacterInventory) : CharacterInventoryGetDTO = ci.run {
        CharacterInventoryGetDTO(id ?: 0, amount, toFindDTO(equipment))
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

    fun toFindDTO(equipment: Equipment): EquipmentFindDTO =
        equipment.run { EquipmentFindDTO(id ?: 0, name, weight) }

    fun toFindDTO(ci: CharacterInventory) : CharacterInventoryFindDTO =
        ci.run { CharacterInventoryFindDTO(id ?: 0, amount, toFindDTO(equipment)) }

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
        Session(sessionDto.name, session.start, Instant.now(), characters)
    }

    fun merge(equipment: Equipment, equipmentDto: EquipmentUpdateDTO): Equipment = equipment.run {
        Equipment(
            equipmentDto.name ?: name,
            equipmentDto.description ?: description,
            equipmentDto.suggestedPriceGp ?: suggestedPriceGp,
            equipmentDto.weight ?: weight
        )
    }

    fun merge(ci: CharacterInventory, ciDto: CharacterInventoryUpdateDTO): CharacterInventory = ci.run {
        CharacterInventory(ciDto.amount, character, equipment)
    }
}