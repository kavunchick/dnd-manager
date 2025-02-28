package com.dndmanager.service

import com.dndmanager.dto.BaseCreateDTO
import com.dndmanager.dto.BaseFindDTO
import com.dndmanager.dto.BaseGetDTO
import com.dndmanager.dto.BaseUpdateDTO
import com.dndmanager.service.additional.ConverterService
import jakarta.transaction.Transactional

interface BaseService< C: BaseCreateDTO, G: BaseGetDTO, F: BaseFindDTO, U: BaseUpdateDTO> {

    val converter: ConverterService

    @Transactional
    fun getById(id: Long) : G

    @Transactional
    fun getAll() : List<F>

    @Transactional
    fun update(id: Long, dto: U) : G

    @Transactional
    fun create(dto: C) : G

    @Transactional
    fun delete(id: Long)
}