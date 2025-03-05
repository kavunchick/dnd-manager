package com.dndmanager.service.additional

import com.dndmanager.domain.*
import com.dndmanager.dto.*
import jakarta.ws.rs.NotFoundException
import java.time.Instant

class ConverterService {
    // toEntity
    fun toEntity(abilityDTO: AbilityCreateDTO): Ability = abilityDTO.run {
        Ability(name, description)
    }

    fun toEntity(characterDto: CharacterCreateDTO): Character = characterDto.run {
        Character(
            name, background, ideals, bonds, flaws, personalityTraits, alignment,
            Class.findById(classId) ?: throw NotFoundException(),
            Race.findById(raceId) ?: throw NotFoundException(),
            RaceAbilityBonus.findById(raceAbilityId) ?: throw NotFoundException()
        )
    }

    fun toEntity(sessionCreatDTO: SessionCreatDTO): Session = sessionCreatDTO.run {
        Session(name, Instant.now(), null, emptyList())
    }

    fun toEntity(equipmentCreateDTO: EquipmentCreateDTO): Equipment = equipmentCreateDTO.run {
        Equipment(name, description, suggestedPriceGp, weight)
    }

    fun toEntity(ciCreateDTO: CharacterInventoryCreateDTO): CharacterInventory = ciCreateDTO.run {
        CharacterInventory(
            amount,
            SessionsCharacter.findById(character) ?: throw NotFoundException(),
            Equipment.findById(equipment) ?: throw NotFoundException()
        )
    }

    fun toEntity(npcCreateDTO: NpcCreateDTO): Npc = npcCreateDTO.run {
        Npc(
            name, description, health, alignment, Class.findById(npcClassId) ?: throw NotFoundException(),
            Race.findById(npcRaceId) ?: throw NotFoundException(),
            isHostile, role, locationId?.let { Location.findById(it) ?: throw NotFoundException() }
        )
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

    fun toGetDTO(ci: CharacterInventory): CharacterInventoryGetDTO = ci.run {
        CharacterInventoryGetDTO(id ?: 0, amount, toFindDTO(equipment))
    }

    fun toGetDTO(npc: Npc): NpcGetDTO = npc.run {
        NpcGetDTO(
            id ?: 0, name, description, health, alignment, toFindDTO(classField),
            toFindDTO(race), isHostile, role, location?.let { toFindDTO(it) }
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

    fun toFindDTO(equipment: Equipment): EquipmentFindDTO =
        equipment.run { EquipmentFindDTO(id ?: 0, name, weight) }

    fun toFindDTO(ci: CharacterInventory): CharacterInventoryFindDTO =
        ci.run { CharacterInventoryFindDTO(id ?: 0, amount, toFindDTO(equipment)) }

    fun toFindDTO(location: Location): LocationFindDTO =
        location.run { LocationFindDTO(id ?: 0, name, description) }

    fun toFindDTO(npc: Npc): NpcFindDTO =
        npc.run {
            NpcFindDTO(
                id ?: 0, name, alignment, toFindDTO(classField),
                toFindDTO(race), isHostile, role, location?.let { toFindDTO(it) })
        }

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
            characterDto.classId?.let { Class.findById(it) ?: throw NotFoundException() } ?: character.characterClass,
            characterDto.raceId?.let { Race.findById(it) ?: throw NotFoundException() } ?: character.race,
            characterDto.raceAbilityId?.let { RaceAbilityBonus.findById(it) ?: throw NotFoundException() }
                ?: character.abilityBonus
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

    fun merge(npc: Npc, npcDto: NpcUpdateDTO): Npc = npc.run {
        Npc(
            npcDto.name ?: name, npcDto.description ?: description, npcDto.health ?: health,
            npcDto.alignment ?: alignment,
            npcDto.npcClassId?.let { Class.findById(it) ?: throw NotFoundException() } ?: classField,
            npcDto.npcRaceId?.let { Race.findById(it) ?: throw NotFoundException() } ?: race,
            npcDto.isHostile ?: isHostile, npcDto.role ?: role,
            npcDto.locationId?.let { Location.findById(it) ?: throw NotFoundException() } ?: location
        )
    }
}