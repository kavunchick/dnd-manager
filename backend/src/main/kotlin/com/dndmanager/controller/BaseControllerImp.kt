package com.dndmanager.controller

import com.dndmanager.dto.BaseCreateDTO
import com.dndmanager.dto.BaseFindDTO
import com.dndmanager.dto.BaseGetDTO
import com.dndmanager.dto.BaseUpdateDTO
import com.dndmanager.service.BaseService
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.PATCH
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path

abstract class BaseControllerImp<
        S : BaseService<C, G, F, U>,
        C : BaseCreateDTO,
        U : BaseUpdateDTO,
        G : BaseGetDTO,
        F : BaseFindDTO> : BaseController<C, U, G, F> {

    abstract val service: S

    @GET
    override fun getAll(): List<F> {
        return service.getAll()
    }

    @GET
    @Path("/{id}")
    override fun getById(id: Long): G {
        return service.getById(id)
    }

    @PATCH
    @Path("/{id}")
    override fun update(id: Long, updateDTO: U): G {
        return service.update(id, updateDTO)
    }

    @DELETE
    @Path("/{id}")
    override fun delete(id: Long) {
        service.delete(id)
    }

    @PUT
    override fun create(createDTO: C): G {
        return service.create(createDTO)
    }

}