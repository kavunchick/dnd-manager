package com.dndmanager.service

import com.dndmanager.domain.Npc
import com.dndmanager.dto.NpcCreateDTO
import com.dndmanager.dto.NpcFindDTO
import com.dndmanager.dto.NpcGetDTO
import com.dndmanager.dto.NpcUpdateDTO
import com.dndmanager.service.additional.ConverterService
import io.quarkus.panache.common.Sort
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import jakarta.ws.rs.NotFoundException

@ApplicationScoped
class NpcService : BaseService<NpcCreateDTO, NpcGetDTO, NpcFindDTO, NpcUpdateDTO> {

    override val converter = ConverterService()

    override fun getById(id: Long): NpcGetDTO {
        val npc = Npc.findById(id)?: throw NotFoundException()
        return converter.toGetDTO(npc)
    }

    override fun getAll(): List<NpcFindDTO> {
        val npcList = Npc.listAll(Sort.by("name"))
        return npcList.map { converter.toFindDTO(it) }
    }

    @Transactional
    override fun delete(id: Long) {
        if (!Npc.deleteById(id)) throw NotFoundException()
    }

    @Transactional
    override fun create(dto: NpcCreateDTO): NpcGetDTO {
        val entity = converter.toEntity(dto)
        entity.persistAndFlush()
        return converter.toGetDTO(entity)
    }

    @Transactional
    override fun update(id: Long, dto: NpcUpdateDTO): NpcGetDTO {
        var npc = Npc.findById(id) ?: throw NotFoundException()
        npc = converter.merge(npc, dto)
        npc.persistAndFlush()
        return converter.toGetDTO(npc)
    }
}