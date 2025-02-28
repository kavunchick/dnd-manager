package com.dndmanager.controller

import com.dndmanager.dto.BaseCreateDTO
import com.dndmanager.dto.BaseFindDTO
import com.dndmanager.dto.BaseGetDTO
import com.dndmanager.dto.BaseUpdateDTO

interface BaseController
       <C : BaseCreateDTO,
        U : BaseUpdateDTO,
        G : BaseGetDTO,
        F : BaseFindDTO> {

    fun create(createDTO: C) : G

    fun getAll(): List<F>

    fun getById(id: Long): G

    fun update(id: Long, updateDTO: U): G

    fun delete(id: Long)
}