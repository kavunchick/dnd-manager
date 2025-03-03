package com.dndmanager.service

import com.dndmanager.domain.Ability
import com.dndmanager.dto.AbilityCreateDTO
import com.dndmanager.dto.AbilityFindDTO
import com.dndmanager.dto.AbilityGetDTO
import com.dndmanager.dto.AbilityUpdateDTO
import com.dndmanager.service.additional.ConverterService
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import jakarta.ws.rs.NotFoundException

@ApplicationScoped
class AbilityService(override val converter: ConverterService = ConverterService()) :
    BaseService<AbilityCreateDTO, AbilityGetDTO, AbilityFindDTO, AbilityUpdateDTO> {

    @Transactional
    override fun create(dto: AbilityCreateDTO): AbilityGetDTO {
        val ability = converter.toEntity(dto);
        ability.persistAndFlush()
        return converter.toGetDTO(ability)
    }

    @Transactional
    override fun update(id: Long, dto: AbilityUpdateDTO): AbilityGetDTO {
        var ability = Ability.findById(id) ?: throw NotFoundException()
        ability = converter.merge(ability, dto)
        ability.persistAndFlush()
        return converter.toGetDTO(ability)
    }

    override fun getById(id: Long): AbilityGetDTO {
        val ability = Ability.findById(id) ?: throw NotFoundException()
        return converter.toGetDTO(ability);
    }

    override fun getAll(): List<AbilityFindDTO> {
        val abilities = Ability.listAll()
        return abilities.map { converter.toFindDTO(it) }
    }

    @Transactional
    override fun delete(id: Long) {
        if (!Ability.deleteById(id)) throw NotFoundException()
    }
}