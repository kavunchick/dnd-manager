package com.dndmanager.service

import com.dndmanager.domain.Character
import com.dndmanager.domain.Class
import com.dndmanager.domain.Race
import com.dndmanager.domain.RaceAbilityBonus
import com.dndmanager.dto.CharacterCreateDTO
import com.dndmanager.dto.CharacterFindDTO
import com.dndmanager.dto.CharacterGetDTO
import com.dndmanager.dto.CharacterUpdateDTO
import com.dndmanager.service.additional.ConverterService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import jakarta.ws.rs.NotFoundException
import jakarta.ws.rs.WebApplicationException

@ApplicationScoped
class CharacterService(override val converter: ConverterService = ConverterService()) : BaseService<CharacterCreateDTO, CharacterGetDTO, CharacterFindDTO, CharacterUpdateDTO> {

    override fun getById(id: Long): CharacterGetDTO {
        val character = Character.findById(id) ?: throw NotFoundException()
        return converter.toGetDTO(character)
    }

    //No need, at least for now
    override fun getAll(): List<CharacterFindDTO> = throw WebApplicationException(501)

    @Transactional
    override fun delete(id: Long) {
        val character = Character.findById(id) ?: throw NotFoundException()
        character.delete()
    }

    @Transactional
    override fun create(dto: CharacterCreateDTO): CharacterGetDTO {
        if (Race.findById(dto.raceId) == null) throw NotFoundException()
        if (Class.findById(dto.classId) == null) throw NotFoundException()
        if (RaceAbilityBonus.findById(dto.raceAbilityId) == null) throw NotFoundException()
        val character = converter.toEntity(dto)
        character.persistAndFlush()
        return converter.toGetDTO(character)
    }

    @Transactional
    override fun update(id: Long, dto: CharacterUpdateDTO): CharacterGetDTO {
        val character = Character.findById(id) ?: throw NotFoundException()
        val updatedCharacter = converter.merge(character, dto)
        updatedCharacter.persistAndFlush()
        return converter.toGetDTO(updatedCharacter)
    }
}