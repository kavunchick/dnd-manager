package com.dndmanager.service

import com.dndmanager.domain.CharacterInventory
import com.dndmanager.domain.Equipment
import com.dndmanager.domain.SessionsCharacter
import com.dndmanager.dto.*
import com.dndmanager.service.additional.ConverterService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import jakarta.ws.rs.NotFoundException
import jakarta.ws.rs.WebApplicationException

@ApplicationScoped
class CharacterInventoryService :
    BaseService<CharacterInventoryCreateDTO, CharacterInventoryGetDTO, CharacterInventoryFindDTO, CharacterInventoryUpdateDTO> {

    override val converter = ConverterService()

    override fun getById(id: Long): CharacterInventoryGetDTO {
        val ci = CharacterInventory.findById(id) ?: throw NotFoundException()
        return converter.toGetDTO(ci);
    }

    override fun getAll(): List<CharacterInventoryFindDTO> {
        throw WebApplicationException(501)
    }

    @Transactional
    override fun delete(id: Long) {
        if (!CharacterInventory.deleteById(id)) throw NotFoundException()
    }

    @Transactional
    override fun create(dto: CharacterInventoryCreateDTO): CharacterInventoryGetDTO {
        if (Equipment.count("id", dto.equipment) == 0L ||
            SessionsCharacter.count("id", dto.character) == 0L
        ) throw NotFoundException()
        val ciEntity = converter.toEntity(dto)
        ciEntity.persistAndFlush()
        return converter.toGetDTO(ciEntity)
    }

    @Transactional
    override fun update(id: Long, dto: CharacterInventoryUpdateDTO): CharacterInventoryGetDTO {
        var entry = CharacterInventory.findById(id) ?: throw NotFoundException()
        entry = converter.merge(entry, dto)
        val res = converter.toGetDTO(entry)
        if (entry.amount == 0)
            entry.delete()
        return res
    }

    fun getAllByCharacter(id: Long) : List<CharacterInventoryFindDTO> {
        return CharacterInventory.list("character", id).map { converter.toFindDTO(it) }
    }
}